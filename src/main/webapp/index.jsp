<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="scc/style.css">
    <script src="JS/SendInfo.js"> </script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form id="photoForm" method="post">
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

    <div class="btn-group">
        <input type="submit" class="btn btn-primary" value="Отправить"/>
        <input type="button" class="btn btn-primary" onclick="document.location.href = 'List.jsp'" value="Получить"/>
    </div>
</form>
    <div class="btn-group">
        <input type="submit" class="btn btn-primary" onclick="document.location.href = 'Update.jsp'" value="Изменить"/>
        <input type="button" class="btn btn-primary" onclick="document.location.href = 'Delete.jsp'" value="Удалить"/>
    </div>
</div>

</body>
</html>
