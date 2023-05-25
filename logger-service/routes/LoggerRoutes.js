// simple route for logger service with parameter eventId passed from another microservice

const { logTheMessage } = require('../controllers/LoggerController');

const express = require('express');

const router = express.Router();

router.get("/log/:eventId", logTheMessage);

module.exports = router

