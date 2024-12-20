// Connect to the database
use MyCircle;

// Create Users Collection
db.createCollection("users", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["username", "email", "password_hash", "created_at"],
      properties: {
        username: {
          bsonType: "string",
          description: "Username is required and must be a string",
        },
        email: {
          bsonType: "string",
          description: "Email is required and must be a string",
        },
        password_hash: {
          bsonType: "string",
          description: "Password hash is required and must be a string",
        },
        profile_picture: {
          bsonType: "string",
          description: "Optional profile picture URL",
        },
        created_at: {
          bsonType: "date",
          description: "Creation date is required and must be a date",
        },
      },
    },
  },
});

// Create Locations Collection
db.createCollection("locations", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "latitude", "longitude", "created_at"],
      properties: {
        name: {
          bsonType: "string",
          description: "Location name is required and must be a string",
        },
        latitude: {
          bsonType: "double",
          description: "Latitude is required and must be a double",
        },
        longitude: {
          bsonType: "double",
          description: "Longitude is required and must be a double",
        },
        description: {
          bsonType: "string",
          description: "Optional location description",
        },
        created_at: {
          bsonType: "date",
          description: "Creation date is required and must be a date",
        },
      },
    },
  },
});

// Create Events Collection
db.createCollection("events", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "event_date", "created_by", "created_at"],
      properties: {
        name: {
          bsonType: "string",
          description: "Event name is required and must be a string",
        },
        description: {
          bsonType: "string",
          description: "Optional event description",
        },
        location_id: {
          bsonType: "objectId",
          description: "Optional reference to a location",
        },
        event_date: {
          bsonType: "date",
          description: "Event date is required and must be a date",
        },
        created_by: {
          bsonType: "objectId",
          description: "Reference to the user who created the event",
        },
        created_at: {
          bsonType: "date",
          description: "Creation date is required and must be a date",
        },
      },
    },
  },
});

