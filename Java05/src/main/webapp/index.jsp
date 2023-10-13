<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome!</title>
    <!-- Agregar Bootstrap (opcional) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #cecece;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            color: #007bff;
            text-align: center;
        }
        .menu-box {
            background-color: #cecece;
            border: 4px solid black;
            border-radius: 10px;
            max-width: 20rem;
            padding: 20px;
            text-align: center;
        }
        .menu-link {
            display: block;
            margin: 0 auto;
            max-width: 10rem;
            background-color: #cecece;
            border: 1px solid black;
            border-radius: 10px;
            padding: 10px;
            margin-bottom: 10px;
            font-weight: bold;
            text-align: center;
        }
        .menu-link:hover {
            background-color: #cecece;
        }
        select {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border: 1px solid black;
            border-radius: 4px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div class="menu-box">
    <h1 style="color: green;"><strong>Only Games bro</strong></h1>
    <br/>

        <a class="btn btn-primary" href="GameServlet">Add Game</a>


        <a class="btn btn-warning" href="ListGameServlet">List Games</a>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

