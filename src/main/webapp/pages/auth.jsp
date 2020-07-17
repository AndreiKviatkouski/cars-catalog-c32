<%--
  Created by IntelliJ IDEA.
  User: Pelar
  Date: 04.06.2020
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>

</head>
<body>

<form action="/auth" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="password" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${requestScope.messageAuth}</p>
<a href="/">Return</a>


</body>
</html>
