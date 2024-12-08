const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors"); // Requiring the cors module
const mongoose = require("mongoose");
require("dotenv").config();

const app = express();
const PORT = process.env.PORT || 5001;

// Middleware
app.use(cors()); // Adding the cors middleware
app.use(bodyParser.json());

// Database Connection
mongoose
  .connect(process.env.MONGO_URI, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log("Connected to MongoDB!"))
  .catch((error) => console.error("MongoDB connection error:", error));

// Routes
const userRoutes = require("./routes/userRoutes");
const eventRoutes = require("./routes/eventRoutes");

app.use("/api/users", userRoutes);
app.use("/api/events", eventRoutes);

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
