const express = require("express");
const router = express.Router();
const Event = require("../models/event"); // Import the Event model

// 1. Create a new event
router.post("/", async (req, res) => {
  try {
    const event = new Event(req.body);
    const savedEvent = await event.save();
    res.status(201).json(savedEvent);
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// 2. Get all events
router.get("/", async (req, res) => {
  try {
    const events = await Event.find();
    res.json(events);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 3. Get a single event by ID
router.get("/:id", async (req, res) => {
  try {
    const event = await Event.findById(req.params.id);
    if (!event) return res.status(404).json({ message: "Event not found" });
    res.json(event);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// 4. Update an event by ID
router.put("/:id", async (req, res) => {
  try {
    const updatedEvent = await Event.findByIdAndUpdate(req.params.id, req.body, { new: true });
    if (!updatedEvent) return res.status(404).json({ message: "Event not found" });
    res.json(updatedEvent);
  } catch (err) {
    res.status(400).json({ error: err.message });
  }
});

// 5. Delete an event by ID
router.delete("/:id", async (req, res) => {
  try {
    const deletedEvent = await Event.findByIdAndDelete(req.params.id);
    if (!deletedEvent) return res.status(404).json({ message: "Event not found" });
    res.json({ message: "Event deleted successfully" });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;

