const express = require('express');
const router = express.Router();

const ConsultationController = require("../controllers/ConsultationController");
const controller = new ConsultationController();

router.get("/", (req, res) => controller.getAll(req, res));
router.post("/", (req, res) => controller.store(req, res));
router.delete("/:id", (req, res) => controller.delete(req, res));

module.exports = router;