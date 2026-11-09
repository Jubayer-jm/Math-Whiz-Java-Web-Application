<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>YOUR NAME – MATH WHIZ | Leaderboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container" style="max-width:780px">
  <h1>YOUR NAME – MATH WHIZ</h1>
  <h2 style="text-align:center">Top 10 Leaderboard</h2>
  <c:if test="${not empty dbError}"><div class="error"><c:out value="${dbError}"/></div></c:if>
  <table>
    <tr><th>#</th><th>Player</th><th>Score</th><th>Difficulty</th><th>Date / Time</th></tr>
    <c:forEach var="s" items="${scores}" varStatus="st">
      <tr>
        <td>${st.count}</td>
        <td><c:out value="${s.playerName}"/></td>
        <td>${s.score}</td>
        <td>${s.difficulty}</td>
        <td><fmt:formatDate value="${s.playedAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
      </tr>
    </c:forEach>
    <c:if test="${empty scores}"><tr><td colspan="5">No scores yet. Be the first to play!</td></tr></c:if>
  </table>
  <div class="actions"><a class="btn" href="${pageContext.request.contextPath}/index.jsp">Play Game</a></div>
</div>
</body>
</html>
