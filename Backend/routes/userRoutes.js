const express = require('express');
const { signup, login, getAllUsers, getUserById, updateUser } = require('../controllers/userController');
const router = express.Router();

// Route to handle user signup
router.post('/signup', signup);

// Route to handle user login
router.post('/login', login);

// Route to fetch all users
router.get('/', getAllUsers);

// Route to fetch a single user by ID
router.get('/:id', getUserById);

// Route to update user information
router.put('/:id', updateUser);

module.exports = router;
