<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employee Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container">

    <h2>Employee Login</h2>

    <form action="login" method="post">

        <label>Login ID</label>
        <input type="text" name="loginId" required />

        <label>Password</label>
        <input type="password" name="password" required />

        <input type="submit" value="Login" />
    </form>

    <span class="error">
        ${error}
    </span>

    <a href="register">New user? Register here</a>

</div>

</body>
</html>
