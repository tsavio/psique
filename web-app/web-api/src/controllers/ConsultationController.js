const table = require('../config/firebaseKey');
const Consultation = require('../model/consultation.modal');

class ConsultationController {

 /*
  * [GET] Get all consultation from firebase
  *
  * 
  */
 async getAll(req, res) {

  const { userid: userId } = req.headers;
    if (!userId) {
      return res.status(400).json({
        status: 'error',
        message: 'Header userId is required.'
      })
    }
    try {
      let ref = await req.firebase.ref(`/${table.CONSULTATION}`).once("value");
      const data = ref.val();

      let object = [];
      if (data)
        Object.keys(data).forEach(key => {
          if (data[key].doctorId == userId) 
          object.push({ ...data[key], id: key })
      });

      return res.json({ object, _total: object.length });
    } catch (error) {

      console.log(`Error #PatientController.getAll : `, error);
      return res.status(500).json(error);
    }
  }

   /*
  * [POST] Store AvailabilityTimeController
  *
  * 
  */
 async store(req, res){
  try {
    
    const data = req.body;
    const consultation = new Consultation(data);
    let ref = await req.firebase.ref(`/${table.CONSULTATION}`);
    const id = await ref.push(consultation).key;
    return res.status(200).json({
      status: 'success',
      id,
    });
  } catch (error) {

    console.log(`Error #AvailabilityTimeController.store : `, error);
    return res.status(500).json(error);
  }
}

}

module.exports = ConsultationController;