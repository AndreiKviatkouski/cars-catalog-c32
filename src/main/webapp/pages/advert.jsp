<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<html>
<head>
    <title>Advert</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <form class="form-inline nav-item active">
                <a class="nav-link" href="/"> Home <span class="sr-only">(current)</span></a>
<c:if test="${requestScope.checkIntrAdd}">
                <a href="/saveAdvert?id=${requestScope.id}" class="btn btn-outline-success" type="button">Save advert for you</a>
</c:if>
<c:if test="${requestScope.checkIntrRem}">
                <a href="/removeAdvert?id=${requestScope.id}" class="btn btn-outline-danger" type="button">Remove advert with you list</a>
</c:if>
            </form>
        </ul>
    </div>
</nav>

<dl class="row" >
    <dt class="col-sm-2 offset-sm-2"> Автомобиль ${requestScope.advert.modelCar}</dt>
</dl>
<dl class="row" >
    <dt class="col-sm-2 offset-sm-1"> Имя владельца </dt>
    <dd class="col-sm-8">${requestScope.user.name}</dd>
    <dt class="col-sm-2 offset-sm-1"> Фамилия владельца </dt>
    <dd class="col-sm-8">${requestScope.user.lastName}</dd>
    <dt class="col-sm-2 offset-sm-1"> Телефон владельца </dt>
    <dd class="col-sm-8">${requestScope.user.phone}</dd>
    <dt class="col-sm-2 offset-sm-1"> Цвет автомобиля </dt>
    <dd class="col-sm-8">${requestScope.advert.colorCar}</dd>
    <dt class="col-sm-2 offset-sm-1"> Год выпуска автомобиля </dt>
    <dd class="col-sm-8">${requestScope.advert.yearCar}</dd>
    <dt class="col-sm-2 offset-sm-1"> Цена автомобиля </dt>
    <dd class="col-sm-8">${requestScope.advert.priceCar}</dd>
    <dt class="col-sm-2 offset-sm-1"> Дата регистрации </dt>
    <dd class="col-sm-8">${requestScope.advert.dateAdvert}</dd>
</dl>

<h3>Имя владельца</h3>
${requestScope.user.name}
<h3>Фамилия владельца</h3>
${requestScope.user.lastName}
<h3>Телефон владельца</h3>
${requestScope.user.phone}
<h3>Марка автомобтля</h3>
${requestScope.advert.markCar}
<h3>Модель автомобиля</h3>
${requestScope.advert.modelCar}
<h3>Цвет автомобиля</h3>
${requestScope.advert.colorCar}
<h3>Год автомобиля</h3>
${requestScope.advert.yearCar}
<h3>Цена автомобиля</h3>
${requestScope.advert.priceCar}
<h3>Описание</h3>
${requestScope.advert.specificationAdvert}
<h3>Дата регистрации</h3>
${requestScope.advert.dateAdvert}

<c:if test="${sessionScope.checkAuth}">

    <dl class="row offset-sm-1" >
        <div class="card w-50">
            <div class="card-header">
                Сообщения
            </div>
            <div class="card-body">
                <p class="card-text">
                <ul>
                    <c:forEach items="${requestScope.advert.message}" var="item">
                        <li>${item.nameUser} ${item.date} ${item.body}</li>
                    </c:forEach>
                </ul>
                </p>
            </div>
        </div>
    </dl>

<dl class="row offset-sm-1" >
    <div class="form-group  w-50">
        Коментировать
        <form name="addMessage" action="/MessageServlet?id=${requestScope.id}" method="post">
        <textarea class="form-control" name="addMessage" id="exampleFormControlTextarea1" rows="3"></textarea>
        <button>Submit</button>
        </form>
    </div>
</dl>

</c:if>


</body>
</html>

