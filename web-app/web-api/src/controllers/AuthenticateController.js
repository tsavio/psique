const DoctorController = require('./DoctorController');
const table = require('../config/firebaseKey');

class AuthenticateController {

    async login(req, res) {
        const { login, password } = req.body;

        try {
            let ref = await req.firebase.ref(`/${table.DOCTOR}`).once("value");
            let data = ref.val();

            let object = [];
            if (data)
                Object.keys(data).forEach(key => object.push({ ...data[key], id: key }));

            // console.log(object);
            const filtered = object.filter(obj => obj.login == login && obj.password == password);

            if (filtered.length < 1) {
                return res.status(401).json({
                    error: true,
                    message: 'Login or password invalid.',
                });
            }

            return res.status(200).json(filtered[0]);
        } catch (error) {
            console.log(`Error #AuthenticateController.login : `, error);
            return res.status(500).json(error);
        }

    }

    async register(req, res) {
        const { login, email, cpf, crp } = req.body;
        try {
            let ref = await req.firebase.ref(`/${table.DOCTOR}`).once("value");
            let data = ref.val();

            let object = [];
            if (data)
                Object.keys(data).forEach(key => object.push({ ...data[key], id: key }));

            // console.log(object);
            const filtered = object.filter(obj => obj.login == login || obj.email == email || obj.cpf == cpf || obj.crp == crp);
            if (filtered.length > 0) {
                return res.status(401).json({
                    error: true,
                    message: 'This login, email or cpf already in use.'
                });
            }

            return await new DoctorController().store(req, res);
        } catch (e) {
            console.log(e);
            return res.status(500).json(e);
        }
    }

}

module.exports = AuthenticateController;
