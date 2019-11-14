const firebase = require('firebase-admin');
var serviceAccount = require("../config/serviceAccountKey.json");

firebase.initializeApp({
  credential: firebase.credential.cert(serviceAccount),
  databaseURL: "https://psique-241319.firebaseio.com"
});

class PacientController {
  /**
   * List of Pacients
   * @param {*} req
   * @param {*} res
   */
  async getAllPatient(req, res) {
    let resp = null;

    var db = firebase.database();
    var ref = db.ref("/Pessoas");

    await ref.once("value")
      .then(snapshot => {
        resp = snapshot.val();
      });

    let data = [];
    Object.keys(resp).map(key => data.push(resp[key]));
    return res.send({ data, _total: data.length });
  }

  /**
   * List of Doctor
   * @param {*} req
   * @param {*} res
   */
  async getAllDoctor(req, res) {
    let resp = null;

    var db = firebase.database();
    var ref = db.ref("/Doctor");

    await ref.once("value")
      .then(snapshot => {
        resp = snapshot.val();
      });

    let data = [];
    Object.keys(resp).map(key => data.push(resp[key]));
    return res.send({ data, _total: data.length });
  }

  /**
   * Remove an doctor in database
   * @param {*} req
   * @param {*} res
   */
  deleteDoctor(req, res) {
    let resp = null;
    const id = req.params.id;

    var db = firebase.database();
    var ref = db.ref("/Doctor");

    ref.destroy({
      where: { id }
    }).then(() => res.redirect("/patients"));
  }

  /**
    * Crea te a doctor Form
    * @param {*} req
    * @param {*} res
    */
  createDoctor(req, res, doctor) {
    let resp = null;

    var db = firebase.database();
    var ref = db.ref("/Doctor");

    await ref.once("value")
      .then(snapshot => {
        resp = snapshot.val();
      });

    let data = [];
    Object.keys(resp).map(key => data.push(resp[key]));
    return res.render("/doctor/", { doctor });
  }

  update(req, res) {
    const id = req.params.id;

    var db = firebase.database();
    var ref = db.ref("/Doctor");

    ref.findById(id).then(doctor =>
      res.render("doctor/update", { doctor })
    );
  }
}
module.exports = PacientController;