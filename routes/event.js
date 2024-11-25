const express = require('express');
const Event = require('../models/Event');
const { verifyToken } = require('../middleware/auth');

const router = express.Router();

/**
 * Create a new event
 */
router.post('/create', verifyToken, async (req, res) => {
    try {
        const { title, description, location, color, startTime, endTime, isRecurring, visibility } = req.body;

        // Check for overlapping events
        const overlappingEvents = await Event.find({
            creator: req.user.id,
            $or: [
                { startTime: { $lt: endTime, $gte: startTime } },
                { endTime: { $gt: startTime, $lte: endTime } }
            ]
        });

        if (overlappingEvents.length > 0) {
            return res.status(400).json({ message: 'Overlapping events detected.' });
        }

        const newEvent = new Event({
            creator: req.user.id,
            title,
            description,
            location,
            color,
            startTime,
            endTime,
            isRecurring,
            visibility
        });

        await newEvent.save();
        res.status(201).json({ message: 'Event created successfully!', event: newEvent });
    } catch (err) {
        res.status(500).json({ message: 'Error creating event.', error: err.message });
    }
});

/**
 * Fetch events (personal and shared)
 */
router.get('/my-events', verifyToken, async (req, res) => {
    try {
        const userId = req.user.id;

        const events = await Event.find({
            $or: [
                { creator: userId },
                { visibility: userId, acceptedBy: userId }
            ]
        }).populate('creator', 'username email');

        res.status(200).json({ events });
    } catch (err) {
        res.status(500).json({ message: 'Error fetching events.', error: err.message });
    }
});

/**
 * Update an event
 */
router.patch('/update/:id', verifyToken, async (req, res) => {
    try {
        const { id } = req.params;
        const updates = req.body;

        const event = await Event.findById(id);
        if (!event) return res.status(404).json({ message: 'Event not found.' });
        if (event.creator.toString() !== req.user.id) {
            return res.status(403).json({ message: 'You are not authorized to update this event.' });
        }

        Object.assign(event, updates);

        // Trigger reconfirmation for updates to time or location
        if (updates.startTime || updates.endTime || updates.location) {
            event.acceptedBy = []; // Clear acceptances
        }

        await event.save();
        res.status(200).json({ message: 'Event updated successfully!', event });
    } catch (err) {
        res.status(500).json({ message: 'Error updating event.', error: err.message });
    }
});

/**
 * Delete an event
 */
router.delete('/delete/:id', verifyToken, async (req, res) => {
    try {
        const { id } = req.params;

        const event = await Event.findById(id);
        if (!event) return res.status(404).json({ message: 'Event not found.' });
        if (event.creator.toString() !== req.user.id) {
            return res.status(403).json({ message: 'You are not authorized to delete this event.' });
        }

        await event.remove();

        // Notify invitees about cancellation
        // (Assume a notification function exists)
        if (event.visibility.length > 0) {
            // Example: sendNotification(event.visibility, "Event canceled");
        }

        res.status(200).json({ message: 'Event deleted successfully!' });
    } catch (err) {
        res.status(500).json({ message: 'Error deleting event.', error: err.message });
    }
});

module.exports = router;
