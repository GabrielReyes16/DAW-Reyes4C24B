<%@ page import="com.miempresa.java05.model.Game" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Game</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body style="background-color: #cecece; padding: 20px;">
<div class="container mx-auto my-4 p-4 bg-light rounded-lg shadow d-grid gap-2">
    <a href="index.jsp" class="btn btn-success">Back to home</a>
</div>

<div class="container mx-auto my-4 p-4 bg-light rounded-lg shadow">
    <h2 class="font-weight-bold text-center">Edit <strong> <%= ((Game) request.getAttribute("game")).getName() %></strong></h2>
    <form action="EditGameServlet" method="post">
        <input type="hidden" name="gameId" value="<%= ((Game) request.getAttribute("game")).getgameId() %>">

        <div class="mb-4">
            <label for="name" class="block text-sm font-medium text-gray-600">Name:</label>
            <input type="text" id="name" name="name" value="<%= ((Game) request.getAttribute("game")).getName() %>"
                   class="form-control"/>
        </div>
        <div class="mb-4">
            <label for="category" class="block text-sm font-medium text-gray-600">Category:</label>
            <select class="form-control" id="category" name="category" required>
                <option value="<%= ((Game) request.getAttribute("game")).getCategory() %>"><%= ((Game) request.getAttribute("game")).getCategory() %> (Actual)</option>
                <option value="Action">Action</option>
                <option value="Adventure">Adventure</option>
                <option value="RPG">RPG</option>
                <option value="Shooter">Shooter</option>
                <option value="Sports">Sports</option>
                <option value="Puzzle">Puzzle</option>
                <option value="Strategy">Strategy</option>
                <option value="Simulation">Simulation</option>
                <option value="Fighting">Fighting</option>
            </select>
        </div>
        <div class="mb-4">
            <label for="console" class="block text-sm font-medium text-gray-600">Console:</label>
            <select class="form-control" id="console" name="console" required>
                <option value="<%= ((Game) request.getAttribute("game")).getConsole() %>"><%= ((Game) request.getAttribute("game")).getConsole() %> (Actual)</option>
                <option value="ps1">ps1</option>
                <option value="ps2">ps2</option>
                <option value="ps3">ps3</option>
                <option value="ps4">ps4</option>
                <option value="ps5">ps5</option>
                <option value="PC">PC</option>
                <option value="Nintendo Switch">Nintendo Switch</option>
                <option value="Nintendo Wii">Nintendo Wii</option>
                <option value="Xbox 360">Xbox 360</option>
                <option value="Xbox One">Xbox One</option>
                <option value="Xbox Series S">Xbox Series S</option>
            </select>
        </div>
        <div class="mb-4">
            <label for="protagonist" class="block text-sm font-medium text-gray-600">Protagonist:</label>
            <input type="text" id="protagonist" name="protagonist" value="<%= ((Game) request.getAttribute("game")).getProtagonist() %>"
                   class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">
            Save Changes
        </button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
