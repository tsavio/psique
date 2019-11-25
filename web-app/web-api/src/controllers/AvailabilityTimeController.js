const table = require('../config/firebaseKey');

class AvailabilityTimeController {


 /*
  * [GET] Get all avalibityTime from firebase
  *
  * 
  */
 async getAll(req, res) {
    try {
      let ref = await req.firebase.ref(`/${table.AVALIBALITYTIME}`).once("value");
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
}
module.exports = AvailabilityTimeController;