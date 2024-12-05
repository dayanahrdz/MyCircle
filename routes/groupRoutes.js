const express = require("express");
const router = express.Router();
const groupController = require("../controllers/groupController");

// Route to create a new group
router.post("/", groupController.createGroup);

// Route to get all groups
router.get("/", groupController.getGroups);

// Route to update a group by ID
router.put("/:id", groupController.updateGroup);

// Route to delete a group by ID
router.delete("/:id", groupController.deleteGroup);

module.exports = router;

