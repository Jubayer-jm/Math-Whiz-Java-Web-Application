<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>YOUR NAME – MATH WHIZ</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <h1>YOUR NAME – MATH WHIZ</h1>
  <p class="sub">Prime numbers, modulus and trigonometry. 4 questions, 10 marks. Difficulty: NORMAL</p>
  <c:if test="${not empty error}"><div class="error"><c:out value="${error}"/></div></c:if>
  <form method="post" action="${pageContext.request.contextPath}/game">
    <input type="hidden" name="action" value="start">
    <label for="playerName">Player Name</label>
    <input type="text" id="playerName" name="playerName" maxlength="100" required placeholder="Enter your name">
    <div class="actions"><button class="btn" type="submit">Start Game</button></div>
  </form>
  <div class="actions"><a class="btn secondary" href="${pageContext.request.contextPath}/game?action=leaderboard">View Leaderboard</a></div>
</div>
</body>
</html>
