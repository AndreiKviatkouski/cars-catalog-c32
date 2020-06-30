<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<html>
<head>
    <title>PersonalAccount</title>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
            <a class="nav-link" href="/">Home   <span class="sr-only">(current)</span></a>
        </li>
            <li class="nav-item active">
                <a class="nav-link" href="/pers/editProfile">   Edit you profile  <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/pers/youAdvert">   You advert   <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/pers//interestingAdvert">  Interesting advert <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<dl class="row" >
    <dt class="col-sm-2 offset-sm-2"> You profile </dt>
</dl>
<dl class="row" >
    <dt class="col-sm-2 offset-sm-1"> Name </dt>
    <dd class="col-sm-8">${requestScope.user.name}</dd>
    <dt class="col-sm-2 offset-sm-1"> Last Name </dt>
    <dd class="col-sm-8">${requestScope.user.lastName}</dd>
    <dt class="col-sm-2 offset-sm-1"> Login </dt>
    <dd class="col-sm-8">${requestScope.user.login}</dd>
    <dt class="col-sm-2 offset-sm-1"> Password </dt>
    <dd class="col-sm-8">${requestScope.user.password}</dd>
    <dt class="col-sm-2 offset-sm-1"> Phone </dt>
    <dd class="col-sm-8">${requestScope.user.phone}</dd>
</dl>

<h4>${requestScope.messageUpdate}</h4>

</body>
</html>
