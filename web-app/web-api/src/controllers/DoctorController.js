
const Doctor = require('../model/doctor');
const table = require('../config/firebaseKey');

class DoctorController {

    /* [GET] Get all doctors from firebase
    *
    *
    */
    async getAll(req, res) {

        try {

            let ref = await req.firebase.ref(`/${table.DOCTOR}`).once("value");
            const data = ref.val();

            let object = [];
            if (data)
                Object.keys(data).forEach(key => object.push({ ...data[key], id: key }));

            return res.json({ object, _total: object.length });
        } catch (error) {

            console.log(`Error #DoctorController.getAll : `, error);
            return res.status(500).json(error);
        }

    }

    /* [GET] Get all doctors from firebase
    *
    *
    */
    async getById(req, res) {

        let { id } = req.params;
        try {
            const response = await req.firebase.ref(`/${table.DOCTOR}/${id}`).once('value');

            if (!response.val()) {
                return res.status(400).json({ status: 'failed', message: 'We cant\'t find this patient id.' })
            }
            return res.json(response.val());
        } catch (error) {
            console.log(`Error #getById : `, error);
            return res.status(500).json(error);
        }
    }

    /* [POST] Insert patient in firebase
    *
    *
    */
    async store(req, res) {
        const data = req.body;
        const $doctor = new Doctor(data);
        try {
            let doctorRef = req.firebase.ref(`/${table.DOCTOR}`);
            const insert = await doctorRef.push($doctor).key;
            return res.json({ status: 'success', id: insert });
        } catch (error) {
            console.log(`Error #store : `, error);
            return res.status(500).json(error);
        }
    }

    /* [POST] Update doctor in firebase
    *
    *
    */
    async update(req, res) {

        const { id } = req.params;
        const data = req.body;
        try {
            let doctorRef = await req.firebase.ref(`/${table.DOCTOR}/${id}`);
            const update = await doctorRef.update(data);

            return res.json({ status: 'success', url: update });
        } catch (error) {
            console.log(`Error #update : `, error);
            return res.status(500).json(error);
        }
    }

    /* [DELETE] Delete doctor in firebase
    *
    *
    */
    async destroy(req, res) {

        const { id } = req.params;
        try {
            await req.firebase.ref(`/${table.DOCTOR}/${id}`).remove();

            return res.json({ status: 'success' });
        } catch (error) {
            console.log('Error #DoctorController.destroy : ', error);
            return res.status(500).json(error);
        }
    }
}

module.exports = DoctorController;