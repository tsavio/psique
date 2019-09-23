const express = require("express");
const router = express.Router();

/**
 * Routing for Articles
 */
const PacientController = require("../controllers/PacientController");
const controller = new PacientController();

router.get("/", (req, res) => controller.index(req, res));

module.exports = router;