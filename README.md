# King's Treasure Adventure: A Multithreaded Simulation

Welcome to the King's Treasure Adventure, a thrilling simulation of a kingdom's wealth management using multithreading, design patterns, and various concurrency concepts. This project aims to simulate the interactions between the king, guards, valuable transporters, miners, and accountants while ensuring thread safety and efficient resource management.

## Table of Contents

- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
- [Design Patterns Used](#design-patterns-used)
- [Concurrency Concepts Implemented](#concurrency-concepts-implemented)
- [Testing](#testing)
- [Future Improvements](#future-improvements)

## Project Structure

The project structure is as follows:

```
king_treasure_adventure/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── actors/
│   │   │   │   ├── Accountant.java
│   │   │   │   ├── King.java
│   │   │   │   ├── Miner.java
│   │   │   │   └── ValuableTransporter.java
│   │   │   ├── concurrency/
│   │   │   │   ├── Deposit.java
│   │   │   │   ├── Door.java
│   │   │   │   ├── TreasureRoom.java
│   │   │   │   └── TreasureRoomGuardsman.java
│   │   │   ├── designpatterns/
│   │   │   │   ├── Adapter.java
│   │   │   │   ├── Multiton.java
│   │   │   │   └── Singleton.java
│   │   │   ├── interfaces/
│   │   │   │   └── Treasury.java
│   │   │   └── util/
│   │   │       └── Valuable.java
│   │   └── resources/
│   │       └── log.txt
│   └── test/
│       └── java/
│           └── actors/
│               └── AccountantTest.java
├── lib/
│   ├── MyArrayList-0.1.jar
│   └── junit-4.13.2.jar
└── README.md
```

## Requirements

- Java Development Kit (JDK) 8 or later
- JUnit 4.13.2
- MyArrayList 0.1.jar

## Getting Started

1. Clone the repository: `git clone https://github.com/your-username/king_treasure_adventure.git`
2. Download the required libraries:
    - MyArrayList 0.1.jar: http://ict-engineering.dk/jar/MyArrayList-0.1.jar
    - JUnit 4.13.2: https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
3. Place the downloaded libraries in the `lib/` directory.
4. Open the project in your favorite IDE or text editor.
5. Run the main method in the `Main.java` class to start the simulation.

## Design Patterns Used

- Singleton: Used for logging actions in the `Singleton` class.
- Multiton: Implemented for different types of valuables in the `Multiton` class.
- Adapter: Created for the blocking queue adapter in the `Adapter` class.
- Proxy: Implemented for the treasure room and guardsman in the `TreasureRoomGuardsman` class.

## Concurrency Concepts Implemented

- Producer-Consumer: Implemented using the `Deposit` class with Miners and Valuable Transporters as producers and consumers, respectively.
- Readers-Writers: Implemented using the `Door` class to manage access to the treasure room and guardsman.

## Testing

JUnit testing is provided for the `Accountant` class in the `AccountantTest` class.

## Future Improvements

- Add more actors and scenarios to enhance the simulation.
- Implement a graphical user interface (GUI) for a more interactive experience.
- Improve resource management and efficiency by optimizing thread synchronization.

## License

This project is licensed under the MIT License.

## Acknowledgments

This project was inspired by the given code snippet and the provided requirements. The design patterns and concurrency concepts were implemented to create a realistic and engaging simulation of a kingdom's treasure management.
### Created by Jakub Abramek, Mateusz Samborski and Maciej Matuszewski
