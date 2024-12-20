-- Use the database
// Use the database
use MyCircle;

// Insert Users
db.users.insertMany([
  {
    username: "JohnDoe",
    email: "johndoe@email.com",
    password_hash: "hashed_password",
    profile_picture: "url_to_profile_pic",
    created_at: new Date(),
  },
  {
    username: "JaneSmith",
    email: "janesmith@email.com",
    password_hash: "hashed_password",
    profile_picture: "url_to_profile_pic",
    created_at: new Date(),
  },
]);

// Insert Locations
db.locations.insertMany([
  {
    name: "Central Park",
    latitude: 40.785091,
    longitude: -73.968285,
    description: "A large city park in New York.",
    created_at: new Date(),
  },
  {
    name: "Golden Gate Park",
    latitude: 37.769042,
    longitude: -122.483519,
    description: "A famous park in San Francisco.",
    created_at: new Date(),
  },
]);

// Insert Events
db.events.insertMany([
  {
    name: "Picnic in Central Park",
    description: "Join us for a family picnic!",
    location_id: ObjectId("<replace_with_central_park_id>"),
    event_date: new Date("2024-12-25T12:00:00Z"),
    created_by: ObjectId("<replace_with_johndoe_id>"),
    created_at: new Date(),
  },
  {
    name: "Golden Gate Meetup",
    description: "Casual meetup for tech enthusiasts.",
    location_id: ObjectId("<replace_with_golden_gate_park_id>"),
    event_date: new Date("2024-12-30T10:00:00Z"),
    created_by: ObjectId("<replace_with_janesmith_id>"),
    created_at: new Date(),
  },
]);
