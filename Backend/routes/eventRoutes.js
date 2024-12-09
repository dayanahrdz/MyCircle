const express = require('express');
const { createEvent, getEvents, getEventById, updateEvent, deleteEvent } = require('../controllers/eventController');
const authenticate = require('../middleware/auth');

const router = express.Router();

// Route to create a new event
router.post('/', authenticate, createEvent);

// Route to retrieve all events for the logged-in user
router.get('/', authenticate, getEvents);

// Route to retrieve a single event by ID
router.get('/:id', authenticate, getEventById);

// Route to update an existing event by ID
router.put('/:id', authenticate, updateEvent);

// Route to delete an event by ID
router.delete('/:id', authenticate, deleteEvent);

module.exports = router;
