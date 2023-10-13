<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Game</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>

<body style="background-color: #cecece; padding: 20px;">
<div class="container mx-auto my-4 p-4 bg-light rounded-lg shadow d-grid gap-2">
    <a href="index.jsp" class="btn btn-success">Back to home</a>
</div>

<div class="container mx-auto my-4 p-4 bg-light rounded-lg shadow">
    <h2 class="font-weight-bold text-center">Add game</h2>

    <form action="<%=request.getContextPath()%>/GameServlet" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Category:</label>
            <select class="form-select" id="category" name="category" required>
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
        <div class="mb-3">
            <label for="console" class="form-label">Console:</label>
            <select class="form-select" id="console" name="console" required>
                <option value="ps1">ps1</option>
                <option value="ps2">ps2</option>
                <option value="ps3">ps3</option>
                <option value="ps4">ps4</option>
                <option value="ps5">ps5</option>
                <option value="Nintendo Switch">Nintendo Switch</option>
                <option value="Nintendo Wii">Nintendo Wii</option>
                <option value="Xbox 360">Xbox 360</option>
                <option value="Xbox One">Xbox One</option>
                <option value="Xbox Series S">Xbox Series S</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="protagonist" class="form-label">Protagonist:</label>
            <input type="text" class="form-control" id="protagonist" name="protagonist" required>
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary">Add Game</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
