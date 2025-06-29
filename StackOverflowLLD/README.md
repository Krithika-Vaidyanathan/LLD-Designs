# 📘 Stack Overflow Low-Level Design (LLD) - Java Implementation

This project is a **low-level design (LLD)** simulation of [Stack Overflow](https://stackoverflow.com/) implemented using Java, demonstrating Object-Oriented Programming (OOP) principles, SOLID design, and extensibility.

---

## ✅ Features Implemented

- Users can:
    - Post **questions**
    - Provide **answers**
    - Add **comments**
    - **Upvote/Downvote** questions and answers
    - Gain **reputation** based on activity

- System supports:
    - **Tagging** questions
    - **Search** questions by:
        - Keyword (in title/description)
        - Tag
        - User
    - **Accepting answers**
    - Displaying reputation and upvote counts

---

## 🧱 Core Java Classes

| Class/Interface      | Responsibility |
|----------------------|----------------|
| `User`               | Represents a user, manages posting and reputation |
| `Question`           | Contains question content, tags, answers, votes |
| `Answer`             | Represents an answer, handles comments and voting |
| `Comment`            | Represents a comment linked to a question/answer |
| `Tag`                | Represents a topic tag for a question |
| `ReputationEvent`    | Logs reputation changes with reasons |
| `VoteType` (Enum)    | Defines `UPVOTE` and `DOWNVOTE` |
| `ContentType` (Enum) | Marks whether a reputation event was for a question or answer |
| `Commentable` (Interface) | Shared interface for adding comments |
| `SearchService`      | Static service to search questions |
| `StackOverflowDemo`               | Demonstrates and simulates interaction flow |

---

## 🧠 Design Principles Used

- ✅ **SOLID Principles**
    - **Single Responsibility**: Each class has a well-defined role
    - **Interface Segregation**: `Commentable` interface allows flexibility

- ✅ **Design Patterns**
    - **Strategy Pattern (extendable)**: Reputation calculation can be delegated
    - **Factory Pattern (optional)**: Can be used to create objects in future
    - **Repository Pattern (optional)**: List of questions acts as an in-memory database

---

## 🧪 Example Simulation (`StackOverflowDemo.java`)

The `StackOverflowDemo` class creates:
- 2 users: Alice & Bob
- 2 questions with tags
- 1 answer, accepted by the original poster
- Votes and comments
- Final output: search results, votes, and reputation scores

---

## 📌 Future Enhancements (TODO)

- Add persistence (DB or file-based)
- RESTful API using Spring Boot
- Authentication & session management
- Notification system
- UI frontend or CLI

---

## 🛠 Requirements

- Java 8 or above
- No external dependencies (pure Java)

---

## 📜 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/Krithika-Vaidyanathan/LLD-Designs.git

2. Compile and Run:
   javac StackOverflowDemo.java
   java StackOverflowDemo

---

## ✍️ Author

Developed by Krithika Vaidyanathan as part of LLD practice for system design interviews.