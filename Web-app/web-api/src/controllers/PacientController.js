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
    async index(req, res) {
        let resp = null;

        var db = firebase.database();
        var ref = db.ref("/Pessoas");


        await ref.once("value")
        .then(snapshot => {
          resp = snapshot.val();
        });
        let data = [];
        Object.keys(resp).map(key => data.push(resp[key]));
        return res.send({ data, _total: data.length});
    }
  }
  
  module.exports = PacientController;