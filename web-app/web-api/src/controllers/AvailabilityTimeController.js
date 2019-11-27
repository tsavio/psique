const table = require('../config/firebaseKey');
const AvailabilityTime = require('../model/availabilityTime.model');

class AvailabilityTimeController {

  /*
  * [POST] Store AvailabilityTimeController
  *
  * 
  */
  async store(req, res) {
    try {

      const data = req.body;
      const avModel = new AvailabilityTime(data);
      let ref = await req.firebase.ref(`/${table.AVALIBALITYTIME}`);
      const id = await ref.push(avModel).key;
      return res.status(200).json({
        status: 'success',
        id,
      });
    } catch (error) {

      console.log(`Error #AvailabilityTimeController.store : `, error);
      return res.status(500).json(error);
    }
  }


  /*
* [DELETE] Delete AvailabilityTimeController
*
* 
*/
  async deleteTime(req, res) {
    const avaId = req.params.id;
    try {
      await req.firebase.ref(`/${table.AVALIBALITYTIME}/${avaId}`).remove()

      return res.status(200).json({
        status: 'success'
      });
    } catch (error) {
      console.log(`Error #AvailabilityTimeController.deleteTime : `, error);
      return res.status(500).json(error);
    }

  }

  /*
   * [GET] Get all avalibityTime from firebase
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
      let ref = await req.firebase.ref(`/${table.AVALIBALITYTIME}`).once("value");
      const data = ref.val();

      let object = [];
      if (data)
        Object.keys(data).forEach(key => {
          if (data[key].doctorId == userId && data[key].using == false)
            object.push({ ...data[key], id: key })
        });

      return res.json({ object, _total: object.length });
    } catch (error) {

      console.log(`Error #AvailabilityTimeController.getAll : `, error);
      return res.status(500).json(error);
    }
  }

  /* [POST] Set availabilityTime using true in firebase
    *
    *
    */

  async setUsing(req, res) {

    const { id } = req.body;
    try {
      let doctorRef = await req.firebase.ref(`/${table.AVALIBALITYTIME}/${id}`);
      const update = await doctorRef.update({using: true});

      return res.json({ status: 'success', url: update });
    } catch (error) {
      console.log(`Error #update : `, error);
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
      let doctorRef = await req.firebase.ref(`/${table.AVALIBALITYTIME}/${id}`);
      const update = await doctorRef.update(data);

      return res.json({ status: 'success', url: update });
    } catch (error) {
      console.log(`Error #update : `, error);
      return res.status(500).json(error);
    }
  }
}
module.exports = AvailabilityTimeController;