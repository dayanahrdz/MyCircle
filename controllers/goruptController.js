const Group = require("../models/group");

// Controller to create a new group
exports.createGroup = async (req, res) => {
  try {
    const group = new Group(req.body);
    const savedGroup = await group.save();
    res.status(201).json(savedGroup);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

// Controller to get all groups
exports.getGroups = async (req, res) => {
  try {
    const groups = await Group.find().populate("members", "name email"); // Populates user details
    res.status(200).json(groups);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

// Controller to update a group
exports.updateGroup = async (req, res) => {
  try {
    const updatedGroup = await Group.findByIdAndUpdate(req.params.id, req.body, { new: true });
    if (!updatedGroup) return res.status(404).json({ message: "Group not found" });
    res.status(200).json(updatedGroup);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

// Controller to delete a group
exports.deleteGroup = async (req, res) => {
  try {
    const deletedGroup = await Group.findByIdAndDelete(req.params.id);
    if (!deletedGroup) return res.status(404).json({ message: "Group not found" });
    res.status(200).json({ message: "Group deleted successfully" });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
