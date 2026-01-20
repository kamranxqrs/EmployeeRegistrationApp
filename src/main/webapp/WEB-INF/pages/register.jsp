<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employee Registration</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container">

    <h2>Employee Registration</h2>

    <form action="register" method="post">

        <label>Name</label>
        <input type="text" name="name" required />

        <label>Date of Birth</label>
        <input type="date" name="dob" required />

        <label>Gender</label>
        <div class="radio-group">
            <label class="radio-item">
                <input type="radio" name="gender" value="Male" required />
                <span>Male</span>
            </label>

            <label class="radio-item">
                <input type="radio" name="gender" value="Female" />
                <span>Female</span>
            </label>
        </div>

        <label>Address</label>
        <textarea name="address" rows="3" required></textarea>

        <div class="row">
            <div class="field">
                <label>City</label>
                <input type="text" name="city" required />
            </div>

            <div class="field">
                <label>State</label>
                <input type="text" name="state" required />
            </div>
        </div>

        <label>Login ID</label>
        <input type="text" name="loginId" required />

        <label>Password</label>
        <input type="password" name="password" required />

        <input type="submit" value="Register" />

    </form>

    <a href="login">Already registered? Login here</a>

</div>

</body>
</html>
