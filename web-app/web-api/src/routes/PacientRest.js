const express = require('express');
const router = express.Router();

const PacientController = require("../controllers/PacientController");
const controller = new PacientController();

router.get("/", (req, res) => controller.getAll(req, res));
router.get("/:id", (req, res) => controller.getById(req, res));

module.exports = router;