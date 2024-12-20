App README

User Guide

Public Link

Access Deliverable 3 materials (app demo video and APK file):
https://drive.google.com/drive/folders/1s6mfXQIW-TQagRZjHVDeHAUJGJ9SkeSW?usp=sharing

Installation Guide

Download the APK:

Use the link provided above to download the APK file.

Enable Installation from Unknown Sources:

On Android devices, go to Settings > Security and enable Unknown Sources.

Install the APK:

Open the downloaded APK file and follow the on-screen instructions to install it.

Setup and Usage

Initial Launch:

Open the app after installation. You will be directed to the sign-up screen.

Sign-Up and Login:

Create an account by providing basic details.

Use the login credentials to access the dashboard.

Navigate Through Features:

Use the navigation drawer to access the Schedule, Day View, Week View, Month View, Groups, and Settings features.

Add new schedule items by clicking the floating action button.

Testing Strategies

Testing Goals:

Validate core functionalities (navigation, adding schedule items).

Ensure stability across supported devices.


Technology Stack

Hardware Requirements

Device: Android device with API level 21 (Lollipop) or higher.

Memory: Minimum 2 GB RAM.

Storage: At least 50 MB of free storage.

Software Requirements

Operating System: Android 5.0 or later.

Development Tools: Android Studio Dolphin or higher.

Languages: Java, XML.

Setup Guide

Development Environment Setup

Install Android Studio:

Download and install Android Studio from Android Developer.

Clone the Repository:

Use Git to clone the repository:

git clone https://github.com/username/repo-name.git

Open the Project:

Open the cloned project in Android Studio.

Sync Gradle:

Allow Android Studio to sync all Gradle dependencies.

Run the App:

Connect an Android device or use an emulator to run the app.

Production Environment Setup

Generate Signed APK:

Go to Build > Generate Signed Bundle/APK.

Follow the instructions to create a signed APK for production.

Distribute the APK:

Share the APK via email, Google Drive, or Play Store.

Features and Technical Implementation
MongoDB Scripts for Family Schedule App
This folder contains MongoDB scripts to create collections and populate data for the Family Schedule App.

Files
create_collections.js: Script to create collections and their schema.
insert_data.js: Script to populate the database with sample data.

Instructions
Prerequisites
MongoDB installed on your system.
A MongoDB client (e.g., MongoDB Compass or Mongo shell).

Steps
Open your terminal or MongoDB shell and connect to your MongoDB instance.```bash
mongo

Features

Sign-Up and Login: Secure user authentication.

Navigation Drawer: Provides access to various app features.

Schedule Management: Add, view, and manage schedule items.

Day/Week/Month Views: Navigate between different calendar views.

Group Management: Create and manage groups of contacts.

Settings: Customize app preferences.

Technical Implementation

Authentication: Firebase Authentication for secure login.

Database: Firebase Realtime Database for storing schedule and user data.

Navigation: Android Navigation Components for seamless screen transitions.

UI: Material Design for intuitive and visually appealing interfaces.

Packages and APIs

APIs and Packages Used

1. Firebase Authentication

Purpose: User sign-up and login.

Endpoint: Provided by Firebase SDK.

Authentication: Email and password.

2. Firebase Realtime Database

Purpose: Store user schedules and group data.

Endpoints: Dynamic database structure based on user IDs.

Authentication: Secure rules based on user tokens.

3. Material Components for Android

Purpose: Implement modern UI components like navigation drawer, floating action button.

Reason: Provides a consistent look and feel across devices.

4. RecyclerView

Purpose: Display schedule items in a scrollable list.

Reason: Efficiently handles dynamic data sets.

Why These Choices?

Firebase: Quick integration, scalability, and secure user management.

Material Design: Ensures modern and user-friendly interfaces.

RecyclerView: Efficient and customizable for dynamic data display.
