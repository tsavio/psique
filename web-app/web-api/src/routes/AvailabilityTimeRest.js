const express = require('express');
const router = express.Router();

const AvailabilityTimeController = require("../controllers/AvailabilityTimeController");
const controller = new AvailabilityTimeController();

router.get("/", (req, res) => controller.getAll(req, res));

module.exports = router;