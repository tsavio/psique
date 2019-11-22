
class PacientController {
 
  /*
  * [GET] Get all pacients from firebase
  *
  * 
  */
  async getAll(req, res) {
    let ref = req.firebase.ref("/Paciente");

    const response = await ref.once("value");
    const data = response.val();

    const jsonData = Object.keys(data).map(key => data[key]);
    return res.json({ jsonData, _total: jsonData.length });
  }

  /*
  * [GET] Get patient by param :ID
  *
  * 
  */
  async getById(req, res){
    let { id } = req.params;

    let ref = req.firebase.ref("/Paciente");
    let response = await ref.once("value");
    const returns = response.val();
    const isExist = Object.keys(returns).filter(key => key === id);
    response = returns[isExist];

    if(!response){
      return res.status(400).json({status:'failed', message:'We cat\' find this pacient id.'})
    }

    return res.json(response);
  }

}

module.exports = PacientController;