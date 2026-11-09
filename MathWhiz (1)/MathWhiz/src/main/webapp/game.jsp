<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>YOUR NAME – MATH WHIZ | Game</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <h1>YOUR NAME – MATH WHIZ</h1>
  <p class="sub">Good luck, <b><c:out value="${sessionScope.playerName}"/></b>! (Difficulty: NORMAL)</p>
  <c:if test="${not empty error}"><div class="error"><c:out value="${error}"/></div></c:if>

  <form method="post" action="${pageContext.request.contextPath}/game">
    <input type="hidden" name="action" value="submit">
    <c:set var="r" value="${sessionScope.round}"/>

    <div class="q"><span class="marks">2 marks</span>
      <b>Q1. Prime Number</b><br>Is <b>${r.primeNumber}</b> a prime number?
      <div class="hint">Enter 1 for prime, 0 for not prime.</div>
      <input type="number" name="primeAnswer" step="1" min="0" max="1" required value="<c:out value='${param.primeAnswer}'/>">
    </div>

    <div class="q"><span class="marks">2 marks</span>
      <b>Q2. Modulus</b><br>What is <b>${r.modA} % ${r.modB}</b>?
      <div class="hint">Integer answer only.</div>
      <input type="number" name="modAnswer" step="1" required value="<c:out value='${param.modAnswer}'/>">
    </div>

    <div class="q"><span class="marks">3 marks</span>
      <b>Q3. Trigonometry</b><br>What is <b>${r.trig1Func}(${r.trig1Angle}°)</b>?
      <div class="hint">Angle in degrees. Round to 2 decimal places.</div>
      <input type="number" name="trig1Answer" step="any" required value="<c:out value='${param.trig1Answer}'/>">
    </div>

    <div class="q"><span class="marks">3 marks</span>
      <b>Q4. Trigonometry</b><br>What is <b>${r.trig2Func}(${r.trig2Angle}°)</b>?
      <div class="hint">Angle in degrees. Round to 2 decimal places.</div>
      <input type="number" name="trig2Answer" step="any" required value="<c:out value='${param.trig2Answer}'/>">
    </div>

    <div class="actions"><button class="btn" type="submit">Submit Answers</button></div>
  </form>
</div>
</body>
</html>
