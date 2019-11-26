const express = require('express');
const router = express.Router();

const AuthenticateController = require("../controllers/AuthenticateController");
const controller = new AuthenticateController();

router.post("/login", controller.login);
router.post("/register", (req, res) => controller.register(req, res));

module.exports = router;

