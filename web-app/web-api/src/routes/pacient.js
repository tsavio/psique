const express = require('express');
const router = express.Router();

/**
 * Routing for Articles
 */
const PacientController = require("../controllers/PacientController");
const controller = new PacientController();

router.get("/", (req, res) => controller.getAllPatient(req, res));
router.get("/:patientID", (req, res) => controller.getPatient(req, res));

module.exports = router;