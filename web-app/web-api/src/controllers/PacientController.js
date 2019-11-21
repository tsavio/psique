const firebase = require('firebase-admin');
var serviceAccount = require("../config/serviceAccountKey.json");

firebase.initializeApp({
  credential: firebase.credential.cert(serviceAccount),
  databaseURL: "https://psique-241319.firebaseio.com"
});

class PacientController {
 
  async getAllPatient(req, res) {
    let resp = null;

    var db = firebase.database();
    var ref = db.ref("/Paciente");

    await ref.once("value")
      .then(snapshot => {
        resp = snapshot.val();
      });

    let data = [];
    Object.keys(resp).map(key => data.push(resp[key]));
    return res.send({ data, _total: data.length });
  }

  async getAllDoctor(req, res) {
    let resp = null;

    var db = firebase.database();
    var ref = db.ref("/Medico");

    await ref.once("value")
      .then(snapshot => {
        resp = snapshot.val();
      });

    let data = [];
    Object.keys(resp).map(key => data.push(resp[key]));
    return res.send({ data, _total: data.length });
  }
}
module.exports = PacientController;