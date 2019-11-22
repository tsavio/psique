const firebase = require('./src/config/firebase');

const express = require('express');
const app = express();
const cors = require('cors');

const PacientRest = require("./src/routes/PacientRest");
const DoctorRest = require("./src/routes/DoctorRest");

app.use(cors());
app.use(express.json());

const firebaseMiddleware = (req, res, next) => {
    req.firebase = firebase.database();
    next();
};  
app.use(firebaseMiddleware)


app.use("/psique/rest/patient", PacientRest);
app.use("/psique/rest/doctor", DoctorRest);


app.listen(3333, () => console.log('Psique backend running in port 3333'));