const firebase = require('firebase-admin');
const serviceAccount = require("../config/serviceAccountKey.json");

try {
  firebase.initializeApp({
    credential: firebase.credential.cert(serviceAccount),
    databaseURL: "https://psique-241319.firebaseio.com"
  })
} catch (err) {
  if (!/already exists/.test(err.message)) {
    console.error('Firebase initialization error', err.stack)
  }
}

module.exports = firebase;