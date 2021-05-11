<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 10.05.2021
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="scc/style.css">
    <link rel="stylesheet" href="scc/style2.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>

<form id="updateForm" method="post" action="${pageContext.request.contextPath}/Name">
    <label>Input name and surname of user you would like to change</label>
    <div class="form-group">
        <label>Name
            <input type="text" class="form-control" name="UserName" placeholder="Ivan" >
        </label>
    </div>
    <div class="form-group">
        <label>Surname
            <input type="text" class="form-control" name="UserSurname" value="" placeholder="Mingaleev">
        </label>
    </div>
    <label>Input new data of user</label>
    <div class="form-group">
        <label>Name
            <input type="text" class="form-control" id="name"  placeholder="Ivan" name="name">
        </label>
    </div>
    <div class="form-group">
        <label>Surname
            <input type="text" class="form-control" id="surname"  placeholder="Mingaleev" name="surname">
        </label>
    </div>
    <div class="form-group">
        <label>Date
            <input type="text" class="form-control" id="date" placeholder="12.12.2021" name="date">
        </label>
    </div>
    <div class="form-group">
        <label>Socials
            <input type="text" class="form-control" id="socials" placeholder="vk.com/exapmle" name="socials">
        </label>
    </div>
    <div class="form-group">
        <label>Email
            <input type="text" class="form-control" id="email"  placeholder="Your email" name="email">
        </label>
    </div>
    <input type="submit" class="btn btn-primary" value="Отправить" id=""/>
    <script src="JS/UpdadeUser.js"></script>
</form>

</body>
</html>
