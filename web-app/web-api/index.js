const express = require('express');
const app = express();
const cors = require('cors');

app.use(cors());
app.use(express.json());


const pacientRoutes = require("./src/routes/pacient");
app.use("/psique/rest/pacient", pacientRoutes);


app.listen(3333, () => console.log('Psique backend running in port 3333'));