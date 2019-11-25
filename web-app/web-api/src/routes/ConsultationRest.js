const express = require('express');
const router = express.Router();

const ConsultationController = require("../controllers/ConsultationController");
const controller = new ConsultationController();

router.get("/", (req, res) => controller.getAll(req, res));

module.exports = router;