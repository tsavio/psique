const table = require('../config/firebaseKey');

class PacientController {

  /*
  * [GET] Get all pacients from firebase
  *
  * 
  */
  async getAll(req, res) {
    try {
      let ref = await req.firebase.ref(`/${table.PATIENT}`).once("value");
      const data = ref.val();

      let object = [];
      if (data)
        Object.keys(data).forEach(key => object.push({ ...data[key], id: key }));

      return res.json({ object, _total: object.length });
    } catch (error) {

      console.log(`Error #PatientController.getAll : `, error);
      return res.status(500).json(error);
    }
  }

  /*
  * [GET] Get patient by param :ID
  *
  * 
  */
  async getById(req, res) {
    let { id } = req.params;

    let ref = req.firebase.ref("/Paciente");
    let response = await ref.once("value");
    const returns = response.val();
    const isExist = Object.keys(returns).filter(key => key === id);
    response = returns[isExist];

    if (!response) {
      return res.status(400).json({ status: 'failed', message: 'We cat\' find this pacient id.' })
    }

    return res.json(response);
  }

}

module.exports = PacientController;