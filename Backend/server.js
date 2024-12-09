const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors"); // Requiring the CORS middleware
const mongoose = require("mongoose");
require("dotenv").config();

const app = express();

// Dynamic Port Selection
const PORT = process.env.PORT || 5001;

// Middleware
app.use(cors({ origin: "http://localhost:3000", methods: ["GET", "POST", "PUT", "DELETE"] })); // Updated CORS for specific frontend
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true })); // Added support for URL-encoded data

// Database Connection
mongoose
  .connect(process.env.MONGO_URI, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("Connected to MongoDB!"))
  .catch((error) => console.error("MongoDB connection error:", error));

const db = mongoose.connection;
db.on("error", console.error.bind(console, "MongoDB connection error:"));

// Routes
const userRoutes = require("./routes/userRoutes");
const eventRoutes = require("./routes/eventRoutes");
const groupRoutes = require("./routes/groupRoutes");

app.use("/api/groups", groupRoutes);
app.use("/api/users", userRoutes);
app.use("/api/events", eventRoutes);

// Root Endpoint
app.get("/", (req, res) => {
  res.send("Welcome to the MyCircle API!");
});

// Error handling for undefined routes
app.use((req, res, next) => {
  res.status(404).json({ error: "Route not found" });
});

// Start the server with error handling
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});

app.on("error", (err) => {
  if (err.code === "EADDRINUSE") {
    console.error(`Port ${PORT} is already in use.`);
    process.exit(1); // Exit the process to prevent further issues
  } else {
    console.error("Server error:", err);
  }
});
