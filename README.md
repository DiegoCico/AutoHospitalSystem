# Hospital Management System

## Overview
The **Hospital Management System** is a Java-based console application that simulates hospital room and patient management. It enables users to manage hospital rooms, admit and discharge patients, assign doctors, and maintain patient waitlists based on priority levels.

## Features
- **Patient Management**: Add new patients with names, ages, and injury descriptions.
- **Priority-Based Waitlist**: Patients are automatically prioritized based on the severity of their injuries.
- **Room Management**: Allocate patients to rooms and discharge them as needed.
- **Doctor Assignment**: Assign doctors to rooms in a round-robin manner.
- **Visitation Control**: Enable or disable visitation for rooms.
- **Hospital Operations**: Open and close the hospital, display room statuses, and manage doctors.

## Usage
Upon running the application, you will be prompted to enter the number of hospital rooms available. You can then interact with the system using the menu options:

### Menu Options
| Option | Description |
|--------|-------------|
| 1 | Add a new patient to the waitlist |
| 2 | Dispatch a patient from a room |
| 3 | Find a patient's room |
| 7 | Show all room statuses |
| 8 | Add or change doctors |
| 9 | Add a new hospital room |
| 0 | Open the hospital and admit patients to rooms |
| -1 | Close the hospital and exit |

## Class Structure
### `Room.java`
- Represents a hospital room
- Tracks usage status, visitation, assigned doctor, and patient
- Methods to admit and discharge patients

### `Patient.java`
- Represents a patient with attributes: name, age, injury description, priority, and doctor notes
- Automatic priority assignment based on injury severity

### `HospitalHandler.java`
- Manages rooms, waitlists, and doctors
- Handles patient allocation and discharge

### `App.java`
- Entry point of the application
- Handles user interactions via a console-based menu

## Future Enhancements
- Implement a GUI for better user experience
- Add database integration for persistent data storage
- Extend patient management with medical history and billing features
