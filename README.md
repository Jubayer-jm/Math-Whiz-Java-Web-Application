# JUBAYER AHMED – MATH WHIZ

**Java Web Application Development | Lab Assignment**

A web-based mathematical quiz game developed using Java Servlet, JSP, JDBC, and MySQL.

Math Whiz is an interactive mathematical game where players solve four mathematical challenges covering Prime Numbers, Modulus Operations, and Trigonometry. The application automatically evaluates answers, calculates scores out of 10, stores player records in a MySQL database, and displays a Top 10 Leaderboard.

---

## 1. Student Information

| Information | Details |
|---|---|
| Student Name | Jubayer Ahmed |
| Student ID | IT-24027 |
| Project Name | Math Whiz |
| Course | Java Web Application Development |
| Lab Practice | Java Servlet & JDBC |
| Difficulty Level | NORMAL |
| Total Marks | 10 |

---

## 2. Project Objectives

- Develop an interactive mathematical quiz game.
- Implement reusable mathematical methods in Java.
- Apply server-side processing using Java Servlet.
- Connect Java applications with MySQL using JDBC.
- Store player names, scores, difficulty levels, and timestamps.
- Display the Top 10 players through a leaderboard.

---

## 3. Technologies Used

- Java
- Java Servlet
- JSP
- JDBC
- MySQL
- HTML5
- CSS3
- Apache Tomcat
- IntelliJ IDEA
- MySQL Workbench

---

## 4. Game Features

- Player name input system.
- Interactive welcome page.
- Four mathematical questions.
- Prime number checking.
- Modulus calculation.
- Trigonometric calculations (Sin, Cos, Tan).
- Automatic answer evaluation.
- Automatic score calculation.
- Maximum score of 10 marks.
- Result page with correct answers.
- MySQL database integration.
- Top 10 leaderboard.
- Player score and date/time tracking.

---

## 5. Game Rules & Scoring System

The game contains four mathematical questions.

| Question | Mathematical Topic | Marks |
|---|---|---:|
| Q1 | Prime Number | 2 |
| Q2 | Modulus Operation | 2 |
| Q3 | Trigonometry | 3 |
| Q4 | Trigonometry | 3 |
| **Total** | | **10** |

### Mathematical Rules

**Prime Number**
- Return 1 if the number is prime.
- Return 0 if the number is not prime.
- Numbers less than 2 are not prime.

**Modulus**
- Calculate the remainder using the `%` operator.
- Accept integer operands only.
- Division by zero is not allowed.

**Trigonometry**
- Calculate sine, cosine, and tangent using Java's Math class.
- Accept angles in degrees.
- Convert degrees into radians before calculation.
- Compare decimal answers using an appropriate tolerance.

---

## 6. Database Configuration

**Database Name:** `math_whiz_db`

**Table Name:** `game_scores`

### Database Table Structure

| Field | Data Type |
|---|---|
| id | INT PRIMARY KEY AUTO_INCREMENT |
| player_name | VARCHAR(100) |
| score | INT |
| difficulty | VARCHAR(20) |
| played_at | TIMESTAMP |

### Database Creation SQL

```sql
CREATE DATABASE math_whiz_db;

USE math_whiz_db;

CREATE TABLE game_scores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    player_name VARCHAR(100) NOT NULL,
    score INT NOT NULL,
    difficulty VARCHAR(20) NOT NULL,
    played_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Leaderboard SQL Query

```sql
SELECT *
FROM game_scores
ORDER BY score DESC, played_at ASC
LIMIT 10;
```

---
## 7. Application Screenshots

The following screenshots demonstrate the main interfaces of the Math Whiz application.

### 1. Welcome Page
![Welcome Page](home.png)

### 2. Game Page
![Game Page](game.png)

### 3. Result Page
![Result Page](result.png)

### 4. Leaderboard
![Leaderboard](leaderboard.png)

---

## 8. Software Requirements

To run this project, the following software is required:

- JDK (Java Development Kit)
- Apache Tomcat Server
- MySQL Server
- MySQL Workbench
- IntelliJ IDEA or another Java IDE
- Web Browser

---

## 9. How to Run the Project

Follow these steps to run the application:

1. Clone or download the project repository.
2. Open the project in IntelliJ IDEA.
3. Configure the JDK in the IDE.
4. Configure Apache Tomcat Server.
5. Start MySQL Server.
6. Open MySQL Workbench.
7. Create the `math_whiz_db` database.
8. Execute the database SQL script.
9. Configure the JDBC connection with your MySQL username and password.
10. Deploy the application on Apache Tomcat.
11. Start the Tomcat server.
12. Open the application in your web browser.

---

## 10. Testing & Validation

The application can be tested using the following mathematical examples.

| Test Case | Expected Result |
|---|---|
| Prime input: 7 | 1 |
| Prime input: 8 | 0 |
| Prime input: 1 | 0 |
| Modulus: 17 % 5 | 2 |
| Sine: 30° | 0.5 |
| Cosine: 60° | 0.5 |
| Tangent: 45° | 1.0 |
| Divisor: 0 | Validation Error |
| All answers correct | 10 Marks |

---

## 11. Project Structure

```text
MathWhiz/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── controller/
│       │   ├── model/
│       │   ├── service/
│       │   └── dao/
│       │
│       └── webapp/
│           ├── index.jsp
│           ├── game.jsp
│           ├── result.jsp
│           └── leaderboard.jsp
│
├── database/
│   └── math_whiz_db.sql
│
├── screenshots/
│   ├── Screenshot 2026-11-09 214054.png
│   ├── Screenshot 2026-11-09 213428.png
│   ├── Screenshot 2026-11-09 213411.png
│   └── Screenshot 2026-11-09 213356.png
│
└── README.md
```

---

## 12. Learning Outcomes

Through this project, I gained practical experience in:

- Developing reusable Java methods.
- Applying conditional statements and logical operations.
- Understanding Servlet request and response processing.
- Connecting Java applications with MySQL using JDBC.
- Performing database INSERT and SELECT operations.
- Using PreparedStatement for database operations.
- Implementing score calculation and leaderboard functionality.
- Developing and documenting a Java web application.
- Managing project files using GitHub.

---

## 13. Author Information

**Developed By:** Jubayer Ahmed

**Student ID:** IT-24027

**Project Title:** Math Whiz

**Course:** Java Web Application Development

**Lab Practice:** Java Servlet & JDBC

---

## 14. GitHub Repository

**Project Repository:** Math-Whiz-Java-Web-Application

---

**Thank You for Visiting Math Whiz!**

*Developed as part of the Java Web Application Development Lab Assignment.*
