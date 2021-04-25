<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data list</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="scc/style2.css">
</head>
    <body>
        <div class="container">

            <table class="table" id="#infoTable">
                <thead>
                    <tr id="header"></tr>
                </thead>
                <tbody id="tbody"> </tbody>
                <script src="JS/OutputInfo.js"></script>
                <script src="JS/GetInfo.js"></script>
            </table>

            <div class="button_cantainer">
                <input type="button" class="btn btn-primary" id="GetInfoButton"  value="Получить"/>
            </div>

        </div>
    </body>
</html>