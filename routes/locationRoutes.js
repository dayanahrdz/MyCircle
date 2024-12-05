const express = require("express");
const router = express.Router();
const Event = require("../models/event");

// Function to calculate distance between two coordinates
function calculateDistance(lat1, lon1, lat2, lon2) {
  const toRadians = (degrees) => (degrees * Math.PI) / 180;
  const R = 6371; // Radius of Earth in kilometers
  const dLat = toRadians(lat2 - lat1);
  const dLon = toRadians(lon2 - lon1);
  const a =
    Math.sin(dLat / 2) * Math.sin(dLat / 2) +
    Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2)) *
    Math.sin(dLon / 2) * Math.sin(dLon / 2);
  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  return R * c; // Distance in kilometers
}

// Route to check location
router.post("/check-location", async (req, res) => {
  const { userId, latitude, longitude } = req.body;

  try {
    // Find current event based on time
    const now = new Date();
    const event = await Event.findOne({
      userId: userId,
      startTime: { $lte: now },
      endTime: { $gte: now }
    });

    if (!event) return res.status(404).json({ match: false, message: "No current event found" });

    // Calculate distance between current location and event location
    const distance = calculateDistance(
      latitude,
      longitude,
      event.location.latitude,
      event.location.longitude
    );

    // Match if distance is within 100 meters (0.1 km)
    if (distance <= 0.1) {
      return res.json({ match: true, message: "User is at the correct location" });
    } else {
      return res.json({ match: false, message: "User is not at the correct location" });
    }
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

module.exports = router;
