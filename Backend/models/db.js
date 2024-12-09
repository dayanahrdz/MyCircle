const mongoose = require('mongoose');

// Connect to MongoDB
mongoose
    .connect(process.env.MONGO_URI, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
    })
    .then(() => console.log(" MongoDB connected successfully!"))
    .catch((error) => {
        console.error(" MongoDB connection error:", error);
        process.exit(1); // Exit the application if the connection fails
    });

// Get the default connection
const db = mongoose.connection;

// Bind connection to error event
db.on("error", (error) => {
    console.error(" MongoDB connection error occurred:", error);
});

db.once("open", () => {
    console.log(" MongoDB connection is open and ready.");
});

module.exports = db;
