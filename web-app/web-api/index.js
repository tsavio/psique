const firebase = require('./src/config/firebase');

const express = require('express');
const app = express();
const cors = require('cors');

const PacientRest = require("./src/routes/PacientRest");
const DoctorRest = require("./src/routes/DoctorRest");
const ConsultationRest = require("./src/routes/ConsultationRest");
const AvalibilityTimeRest = require("./src/routes/AvailabilityTimeRest");

app.use(cors());
app.use(express.json());

const firebaseMiddleware = (req, res, next) => {
    req.firebase = firebase.database();
    next();
};  
app.use(firebaseMiddleware)

app.use("/psique/rest/patient", PacientRest);
app.use("/psique/rest/doctor", DoctorRest);
app.use("/psique/rest/consultation", ConsultationRest);
app.use("/psique/rest/availability", AvalibilityTimeRest);


app.listen(3333, () => console.log('Psique backend running in port 3333'));