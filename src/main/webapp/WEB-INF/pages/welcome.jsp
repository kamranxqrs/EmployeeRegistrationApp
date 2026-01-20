<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Welcome</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container wide">

    <div class="welcome-header">
        <h2>Welcome, ${user.name}</h2>
        <a href="logout" class="logout-btn">Logout</a>
    </div>

    <h3 style="margin-top: 10px; color:#444;">Registered Employees</h3>

    <table>
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>City</th>
            <th>State</th>
            <th>Login ID</th>
        </tr>

        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.name}</td>
                <td>${emp.gender}</td>
                <td>${emp.city}</td>
                <td>${emp.state}</td>
                <td>${emp.loginId}</td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>
