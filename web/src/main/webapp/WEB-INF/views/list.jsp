<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> Happy WOrld </title>
</head>
<body>
<h3>save</h3>
<form action="save">
    번호 : <input type="text" name="privateKey">
    이름 : <input type="text" name="name">
    나이 : <input type="text" name="age">
    <input type="submit" value="저장"/>
</form>

<hr>
<h3>list</h3>
<c:forEach items="${list}" var="item">
    ${item.privateKey}번 , ${item.name} 는 ${item.age} 살 ::
    <a href="${pageContext.request.contextPath}/get?key=${item.privateKey}"> Get 이동</a>
    <br>
</c:forEach>



</body>
</html>