<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddAdvert</title>
</head>
<body>

<b><a href="/">Return</a></b>
<h2>Create a new advert</h2>

<c:if test="${!requestScope.checkModelCar}">
    <ul>
        <form action="/addAdvert" method="get">
            <li> Select mark car <select name="mark">
                <c:forEach items="${requestScope.listMark}" var="list">
                    <option value="${list}"> ${list} </option>
                </c:forEach>
            </select>
            </li>
    </ul>
    <button>Submit</button>
</c:if>

<c:if test="${requestScope.checkModelCar}">
    <ul>

        <form action="/addAdvert" method="post">
            <li>
                <select name="model">
                    <option value="${requestScope.mark}">${requestScope.mark}</option>
                </select>
            </li>

            <li>Select model car <select name="mark">
                <c:forEach items="${requestScope.listCar}" var="last">
                    <option value="${last}"> ${last} </option>
                </c:forEach>
            </select>
            </li>

            <li>Select color car <select name="color">
                <c:forEach items="${requestScope.colorList}" var="list">
                    <option value="${list}"> ${list} </option>
                </c:forEach>
            </select>
            </li>

            <li>Select production year <select name="year">
                <c:forEach items="${requestScope.listYear}" var="list">
                    <option value="${list}"> ${list} </option>
                </c:forEach>
            </select>
            </li>

    </ul>

    <p> Prise in BYN <input type="text" name="prise" placeholder="Prise"></p>

    <p> Specification <input type="text" name="specificationAdvert"></p>

    <button>Submit</button>


</c:if>
</form>
<b>${requestScope.checkAdvert}</b>
</body>
</html>
