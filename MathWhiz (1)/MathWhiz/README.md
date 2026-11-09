# YOUR NAME – MATH WHIZ

A web-based mathematical game built with **Java Servlets, JSP and JDBC (MySQL)**. Players answer four questions (prime number, modulus, two trigonometry questions), see their score out of 10, and compete on a Top 10 leaderboard.

> Replace `YOUR NAME` with your real name in the JSP files (`index.jsp`, `game.jsp`, `result.jsp`, `leaderboard.jsp`) and in this README.

## Project Objectives
- Build reusable Java methods for prime, modulus and trigonometric calculations.
- Process requests and responses with a Servlet (MVC: JSP view, Servlet controller, DAO/service layers).
- Save and read data using JDBC and `PreparedStatement`.
- Show a Top 10 leaderboard sorted by score (desc), then date/time (asc).

## Technologies Used
Java 17+, Jakarta Servlet / JSP, Jakarta JSTL, JDBC, MySQL 8, Apache Tomcat 10.1/11, Maven, HTML/CSS.

## Software Requirements
- JDK 17 or later
- Apache Tomcat **10.1 or 11** (uses `jakarta.servlet`)
- MySQL 8 (or MariaDB)
- Maven 3.6+
- Any IDE (Eclipse, IntelliJ, NetBeans, VS Code)

## Project Structure
```
MathWhiz/
├── src/main/java/
│   ├── controller/GameServlet.java
│   ├── model/GameScore.java, GameRound.java
│   ├── service/MathService.java
│   ├── dao/ScoreDAO.java
│   └── util/DBUtil.java
├── src/main/webapp/ (index.jsp, game.jsp, result.jsp, leaderboard.jsp, css/style.css)
├── src/test/java/service/MathServiceDemo.java
├── database/math_whiz_db.sql
└── README.md
```

## Database Configuration
Defaults are in `util/DBUtil.java` (`root` / `root`, `localhost:3306`). Override without editing code using environment variables `DB_URL`, `DB_USER`, `DB_PASSWORD`.

### Database Creation SQL
```sql
CREATE DATABASE IF NOT EXISTS math_whiz_db;
USE math_whiz_db;

CREATE TABLE IF NOT EXISTS game_scores (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(100) NOT NULL,
    score       INT          NOT NULL,
    difficulty  VARCHAR(20)  NOT NULL DEFAULT 'NORMAL',
    played_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

## Steps to Run
1. Clone the repository and open the `MathWhiz` folder.
2. Run `database/math_whiz_db.sql` in MySQL (`mysql -u root -p < database/math_whiz_db.sql`).
3. Set your MySQL username/password in `DBUtil.java` or via environment variables.
4. Build: `mvn clean package` (creates `target/MathWhiz.war`).
5. Copy the WAR to Tomcat's `webapps/` folder (or add the project to Tomcat in your IDE) and start Tomcat.
6. Open `http://localhost:8080/MathWhiz/`.

To test the maths methods only (no Tomcat or database needed), run `MathServiceDemo` (it has a `main` method).

## Game Rules and Scoring
| Question | Area | Marks |
|---|---|---|
| Q1 | Prime number (1 = prime, 0 = not prime) | 2 |
| Q2 | Modulus (integers only, divisor never 0) | 2 |
| Q3 | Trigonometry (sin/cos/tan, degrees) | 3 |
| Q4 | Trigonometry (sin/cos/tan, degrees) | 3 |
| **Total** | | **10** |

- Answers are always calculated by `MathService` methods, never stored.
- Trig answers use degrees converted to radians with `Math.toRadians`; comparison tolerance is ±0.01.
- Undefined tangent values (90°, 270°…) return `NaN` and are never asked.
- Difficulty is `NORMAL` and is saved with every score.

## Test Cases (Task 09)
| Test | Expected | Status |
|---|---|---|
| Prime 7 / 8 / 1 | 1 / 0 / 0 | Pass |
| 17 % 5 | 2 | Pass |
| sin 30° / cos 60° / tan 45° | 0.5 / 0.5 / 1.0 | Pass |
| Divisor 0 | Validation error | Pass |
| All correct | 10 marks | Pass |
| Incorrect answers | Marks not awarded | Pass |

## Application Screenshots
Add your screenshots to the `screenshots/` folder.

### Welcome Page
![Welcome Page](screenshots/home.png)

### Game Page
![Game Page](screenshots/game.png)

### Result Page
![Result Page](screenshots/result.png)

### Leaderboard
![Leaderboard](screenshots/leaderboard.png)

## GitHub Project Directory Link
https://github.com/username/repository/tree/main/MathWhiz
