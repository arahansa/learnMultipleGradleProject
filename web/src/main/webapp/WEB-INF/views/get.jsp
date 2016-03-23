<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> Happy WOrld </title>
</head>
<body>
<h3>get</h3>

이름 : ${domain.name}
나이 : ${domain.age}

<hr>
<a href="${pageContext.request.contextPath}/list">리스트로 이동</a>
</body>
</html>