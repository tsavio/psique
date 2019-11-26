const express = require('express');

const router = express.Router();

const DoctorController = require("../controllers/DoctorController");
const controller = new DoctorController();

router.get("/", (req, res) => controller.getAll(req, res));
router.get("/:id", (req, res) => controller.getById(req, res));

router.post("/", (req, res) => controller.store(req, res));
router.put("/:id", (req, res) => controller.update(req, res));
router.delete("/:id", (req, res) => controller.destroy(req, res));

module.exports = router;

