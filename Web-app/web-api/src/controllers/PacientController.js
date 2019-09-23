const firebase = require('firebase-admin');
var serviceAccount = require("../config/serviceAccountKey.json");

firebase.initializeApp({
  credential: firebase.credential.cert(serviceAccount),
  databaseURL: "https://psique-241319.firebaseio.com"
});

class PacientController {
    /**
     * Liste of Articles
     * @param {*} req
     * @param {*} res
     */
    async index(req, res) {
        let resp = null;

        var db = firebase.database();
        var ref = db.ref("/Pessoas");  //Set the current directory you are working in


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