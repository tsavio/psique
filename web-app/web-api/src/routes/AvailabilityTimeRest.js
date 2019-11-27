const express = require('express');
const router = express.Router();

const AvailabilityTimeController = require("../controllers/AvailabilityTimeController");
const controller = new AvailabilityTimeController();

router.get("/", (req, res) => controller.getAll(req, res));
router.post("/", (req, res) => controller.store(req, res));
router.post("/setUsing", (req, res) => controller.setUsing(req, res));
router.delete("/:id", (req, res) => controller.delete(req, res));

module.exports = router;