const Group = require("../models/group");

// Create a new group
exports.createGroup = async (req, res) => {
    try {
        const { name, members } = req.body; // Destructure fields from request body
        if (!name || !members) {
            return res.status(400).json({ message: "Name and members are required" });
        }

        const newGroup = new Group({ name, members });
        const savedGroup = await newGroup.save();

        res.status(201).json(savedGroup);
    } catch (err) {
        res.status(500).json({ error: "Error creating group", details: err.message });
    }
};

// Get all groups
exports.getGroups = async (req, res) => {
    try {
        const groups = await Group.find().populate("members", "username email"); // Populate user details
        res.status(200).json(groups);
    } catch (err) {
        res.status(500).json({ error: "Error fetching groups", details: err.message });
    }
};

// Update a group by ID
exports.updateGroup = async (req, res) => {
    try {
        const { id } = req.params;
        const updatedGroup = await Group.findByIdAndUpdate(id, req.body, { new: true });

        if (!updatedGroup) {
            return res.status(404).json({ message: "Group not found" });
        }

        res.status(200).json(updatedGroup);
    } catch (err) {
        res.status(500).json({ error: "Error updating group", details: err.message });
    }
};

// Delete a group by ID
exports.deleteGroup = async (req, res) => {
    try {
        const { id } = req.params;
        const deletedGroup = await Group.findByIdAndDelete(id);

        if (!deletedGroup) {
            return res.status(404).json({ message: "Group not found" });
        }

        res.status(200).json({ message: "Group deleted successfully" });
    } catch (err) {
        res.status(500).json({ error: "Error deleting group", details: err.message });
    }
};
