const express = require('express');
const router = express.Router();

/**
 * Routing for Articles
 */
const PacientController = require("../controllers/PacientController");
const controller = new PacientController();

router.get("/", (req, res) => controller.getAllPatient(req, res));
router.get("/patient/:patientID", (req, res) => controller.getPatient(req, res));
router.get("/doctors", (req, res) => controller.getAllDoctor(req, res));
router.get("/doctor/:doctor", (req, res) => controller.deleteDoctor(req, res));
router.post("/doctor/:doctor", (req, res) => controller.createDoctor(req, res));
router.post("/doctor/update/:doctor", (req, res) => controller.updateDoctor(req, res));

module.exports = router;