const mongoose = require('mongoose');

/**
 * Event Schema for MyCircle
 */
const EventSchema = new mongoose.Schema({
    creator: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true }, // User who created the event
    title: { type: String, required: true },
    description: { type: String, default: '' },
    location: { type: String, default: '' }, // Optional location
    color: { type: String, default: '#2196F3' }, // Default event color
    startTime: { type: Date, required: true },
    endTime: { type: Date, required: true },
    isRecurring: { type: String, enum: ['none', 'weekly', 'monthly'], default: 'none' }, // Recurring frequency
    visibility: [{ type: mongoose.Schema.Types.ObjectId, ref: 'User' }], // List of friends or group members
    acceptedBy: [{ type: mongoose.Schema.Types.ObjectId, ref: 'User' }], // Users who accepted the event
    createdAt: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Event', EventSchema);
