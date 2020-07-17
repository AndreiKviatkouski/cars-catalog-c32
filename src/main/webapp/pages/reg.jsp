<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form action="/reg" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="lastName" placeholder="Last name">
    <input type="text" name="login" placeholder="Login">
    <input type="password" name="password" placeholder="Password">
    <input type="text" name="phone" placeholder="Phone">
    <button>Submit</button>
</form>

<p> ${sessionScope.messageReg} </p>
<a href="/">Return</a>


</body>
</html>
