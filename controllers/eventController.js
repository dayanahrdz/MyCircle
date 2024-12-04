const { Event } = require('../models/db');

// Create a new event
exports.createEvent = async (req, res) => {
  const { title, description, startTime, endTime, location, isPrivate, attendees } = req.body;

  if (!title || !startTime || !endTime) {
    return res.status(400).json({ message: 'Title, startTime, and endTime are required' });
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
    res.status(500).json({ message: 'Server error', error });
  }
};

// Get all events for the logged-in user
exports.getEvents = async (req, res) => {
  try {
    const events = await Event.find({ createdBy: req.user.id }); // Filter events by user ID
    res.status(200).json(events);
  } catch (error) {
    res.status(500).json({ message: 'Server error', error });
  }
};

// Update an event by ID
exports.updateEvent = async (req, res) => {
  const { id } = req.params;

  try {
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
    res.status(500).json({ message: 'Server error', error });
  }
};

// Delete an event by ID
exports.deleteEvent = async (req, res) => {
  const { id } = req.params;

  try {
    const event = await Event.findOneAndDelete({ _id: id, createdBy: req.user.id }); // Ensure the event belongs to the logged-in user

    if (!event) {
      return res.status(404).json({ message: 'Event not found or unauthorized' });
    }

    res.status(200).json({ message: 'Event deleted successfully' });
  } catch (error) {
    res.status(500).json({ message: 'Server error', error });
  }
};
