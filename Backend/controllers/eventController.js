const Event = require('../models/event'); 

// Create a new event
exports.createEvent = async (req, res) => {
    const { title, description, startTime, endTime, location, isPrivate, attendees } = req.body;

    if (!title || !startTime || !endTime) {
        return res.status(400).json({ message: 'Title, startTime, and endTime are required' });
    }

    if (new Date(startTime) >= new Date(endTime)) {
        return res.status(400).json({ message: 'startTime must be before endTime' });
    }

    try {
        const event = new Event({
            title,
            description,
            startTime,
            endTime,
            location,
            isPrivate,
            attendees,
            createdBy: req.user.id, // Authenticated user ID from the middleware
        });

        await event.save();
        res.status(201).json({ message: 'Event created successfully', event });
    } catch (error) {
        console.error('Error creating event:', error);
        res.status(500).json({ message: 'Server error', error });
    }
};

// Get all events for the logged-in user
exports.getEvents = async (req, res) => {
    try {
        const events = await Event.find({ createdBy: req.user.id }); // Filter events by user ID
        res.status(200).json({ events });
    } catch (error) {
        console.error('Error fetching events:', error);
        res.status(500).json({ message: 'Server error', error });
    }
};

// Get a single event by ID
exports.getEventById = async (req, res) => {
    try {
        const { id } = req.params;
        const event = await Event.findOne({ _id: id, createdBy: req.user.id });

        if (!event) {
            return res.status(404).json({ message: 'Event not found or unauthorized' });
        }

        res.status(200).json({ event });
    } catch (error) {
        console.error('Error fetching event:', error);
        res.status(500).json({ message: 'Server error', error });
    }
};

// Update an event by ID
exports.updateEvent = async (req, res) => {
    try {
        const { id } = req.params;

        const event = await Event.findOneAndUpdate(
            { _id: id, createdBy: req.user.id }, // Ensure the event belongs to the logged-in user
            req.body,
            { new: true } // Return the updated event
        );

        if (!event) {
            return res.status(404).json({ message: 'Event not found or unauthorized' });
        }

        res.status(200).json({ message: 'Event updated successfully', event });
    } catch (error) {
        console.error('Error updating event:', error);
        res.status(500).json({ message: 'Server error', error });
    }
};

// Delete an event by ID
exports.deleteEvent = async (req, res) => {
    try {
        const { id } = req.params;

        const event = await Event.findOneAndDelete({ _id: id, createdBy: req.user.id }); // Ensure the event belongs to the logged-in user

        if (!event) {
            return res.status(404).json({ message: 'Event not found or unauthorized' });
        }

        res.status(200).json({ message: 'Event deleted successfully' });
    } catch (error) {
        console.error('Error deleting event:', error);
        res.status(500).json({ message: 'Server error', error });
    }
};
