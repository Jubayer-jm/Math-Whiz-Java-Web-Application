<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>YOUR NAME – MATH WHIZ | Result</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <h1>YOUR NAME – MATH WHIZ</h1>
  <h2 style="text-align:center">Result for <c:out value="${playerName}"/></h2>
  <div class="score">${score} / 10</div>
  <p class="sub">Difficulty: ${difficulty}</p>
  <c:if test="${not empty dbError}"><div class="error"><c:out value="${dbError}"/></div></c:if>

  <table>
    <tr><th>Question</th><th>Correct Answer</th><th>Result</th></tr>
    <tr><td>Q1. Is ${round.primeNumber} prime? (2)</td><td>${expectedPrime}</td>
        <td><c:choose><c:when test="${primeCorrect}"><span class="ok">Correct +2</span></c:when><c:otherwise><span class="bad">Wrong 0</span></c:otherwise></c:choose></td></tr>
    <tr><td>Q2. ${round.modA} % ${round.modB} (2)</td><td>${expectedMod}</td>
        <td><c:choose><c:when test="${modCorrect}"><span class="ok">Correct +2</span></c:when><c:otherwise><span class="bad">Wrong 0</span></c:otherwise></c:choose></td></tr>
    <tr><td>Q3. ${round.trig1Func}(${round.trig1Angle}°) (3)</td><td>${expectedTrig1}</td>
        <td><c:choose><c:when test="${trig1Correct}"><span class="ok">Correct +3</span></c:when><c:otherwise><span class="bad">Wrong 0</span></c:otherwise></c:choose></td></tr>
    <tr><td>Q4. ${round.trig2Func}(${round.trig2Angle}°) (3)</td><td>${expectedTrig2}</td>
        <td><c:choose><c:when test="${trig2Correct}"><span class="ok">Correct +3</span></c:when><c:otherwise><span class="bad">Wrong 0</span></c:otherwise></c:choose></td></tr>
  </table>

  <div class="actions">
    <a class="btn" href="${pageContext.request.contextPath}/index.jsp">Play Again</a>
    <a class="btn secondary" href="${pageContext.request.contextPath}/game?action=leaderboard">Leaderboard</a>
  </div>
</div>
</body>
</html>
