const mongoose = require("mongoose");

mongoose.connect(process.env.MONGO_URI)
  .then(() => console.log())
  .catch((error) => console.error("MongoDB connection error:", error));

const db = mongoose.connection;
db.on("error", console.error.bind(console, "MongoDB connection error:"));
db.once("open", () => {
  console.log();
});

module.exports = db;