# Parking Lot - Low Level Design (LLD)

# Problem Statement:
Design a scalable parking lot system that can handle:
- Multiple floors
- Different vehicle types: Car, Bike, and Truck
- Slot types per vehicle category
- Entry and exit with ticket generation
- Fee calculation based on vehicle type and duration
- Real-time display of available slots

# Features Implemented:
- Abstract Vehicle class with subclassed Car, Bike, and Truck
- Slot type mapping: COMPACT, BIKE, LARGE
- Parking lot with multiple floors and slots
- Ticket issuance and tracking
- Fee calculation using Strategy pattern
- Entrance and Exit panel logic
- Real-time display board updates for available slots
- OOP Principles: abstraction, composition, encapsulation

# Class Overview:
- ParkingLot -> Coordinates all floors, entrances, exits
- ParkingFloor -> Holds slots and updates the display board
- ParkingSlot -> Assigned to one vehicle; holds type and state
- Vehicle -> Base class for all vehicle types
- Ticket -> Tracks slots, vehicle, and entry time
- EntrancePanel -> Assigns first available slot and issues ticket
- ExitPanel -> Calculates fee and clears the slot
- DisplayBoard -> Shows available slots for each type
- ParkingRateCalculator -> Delegates fee calculation using strategy pattern

# Design Patters Used:
- Strategy Pattern:
  ParkingRateCalculator delegates to CarRateStrategy, BikeRateStrategy, or TruckRateStrategy for flexible fee logic.
- Composition
  ParkingLot -> contains -> ParkingFloor
  ParkingFloor -> contains -> ParkingSlot

# Technologies Used:
- Java 17+
- IntelliJ IDEA
- Git & Github

# How to Run:
git clone https://github.com/Krithika-Vaidyanathan/LLD-Designs.git

# Open IntelliJ and run:
ParkingLotDemo.java

Ensure you have Java 17+ configured in your IntelliJ project settings.

# Possible Extensions:
- Add electric vehicle charging support
- Use Observer pattern to auto-update display board
- REST API integration using Spring Boot
- Add slot reservation and advance booking
- Integrate caching or queuing mechanism for slot tracking.
