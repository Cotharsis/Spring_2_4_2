
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>USERS</title>
</head>
<body>

<h2>Users</h2>
<table border="1" width="40%">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>year</th>
        <th>address</th>
        <th>action</th>
    </tr>
    <c:forEach var="user" items="${userList}">

        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.year}</td>
            <td>${user.address}</td>

            <td>
                <a href="/edit/${user.id}">edit      </a>


                <a href="/delete/${user.id}"> delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/admin/add" var="add"/>
<a href="${add}">Add new user</a>
</body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--    <c:if test="${empty user.name}">--%>
<%--        <title>Add</title>--%>
<%--    </c:if>--%>
<%--    <c:if test="${!empty user.name}">--%>
<%--        <title>Edit</title>--%>
<%--    </c:if>--%>
<%--</head>--%>
<%--<body>--%>
<%--<c:if test="${empty user.name}">--%>
<%--    <c:url value="/add" var="var"/>--%>
<%--</c:if>--%>
<%--<c:if test="${!empty user.name}">--%>
<%--    <c:url value="/edit" var="var"/>--%>
<%--</c:if>--%>
<%--<form action="${var}" method="POST">--%>
<%--    <c:if test="${!empty user.name}">--%>
<%--        <input type="hidden" name="id" value="${user.id}">--%>
<%--    </c:if>--%>
<%--    <label for="name">Name</label>--%>
<%--    <input type="text" name="name" id="name">--%>
<%--    <label for="year">Year</label>--%>
<%--    <input type="text" name="year" id="year">--%>
<%--    <label for="address">Address</label>--%>
<%--    <input type="text" name="address" id="address">--%>

<%--    <c:if test="${empty user.name}">--%>
<%--        <input type="submit" value="Add new user">--%>
<%--    </c:if>--%>
<%--    <c:if test="${!empty user.name}">--%>
<%--        <input type="submit" value="Edit user">--%>
<%--    </c:if>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>