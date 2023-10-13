<%@ page import="com.miempresa.java05.model.Game" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Games List</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body style="background-color: #cecece; padding: 20px;">
<div class="container mx-auto my-4 p-4 bg-light rounded-lg shadow d-grid gap-2">
  <a href="index.jsp" class="btn btn-success">Back to home</a>
</div>

<div class="container mx-auto my-4 p-4 bg-light rounded-lg shadow">
  <h2 class="font-weight-bold text-center">Games List</h2>
  <table class="table table-bordered table-hover table-responsive">
    <thead class="bg-secondary text-white">
    <tr>
      <th class="px-4 py-2">Id</th>
      <th class="px-4 py-2">Name</th>
      <th class="px-4 py-2">Category</th>
      <th class="px-4 py-2">Console</th>
      <th class="px-4 py-2">Protagonist</th>
      <th class="px-4 py-2">Actions</th>
    </tr>
    </thead>
    <tbody>
    <% List<Game> listGames = (List<Game>) request.getAttribute("list"); %>
    <% for (Game game : listGames) { %>
    <tr>
      <td class="px-4 py-2"><%= game.getgameId() %></td>
      <td class="px-4 py-2"><%= game.getName() %></td>
      <td class="px-4 py-2"><%= game.getCategory() %></td>
      <td class="px-4 py-2"><%= game.getConsole() %></td>
      <td class="px-4 py-2"><%= game.getProtagonist() %></td>
      <td class="px-4 py-2">
        <form action="EditGameServlet" method="get" class="d-inline">
          <input type="hidden" name="gameId" value="<%= game.getgameId() %>">
          <button type="submit" class="btn btn-primary">Edit</button>
        </form>
        <span class="mx-2 text-secondary">|</span>
        <form action="DeleteGameServlet" method="post" class="d-inline">
          <input type="hidden" name="gameId" value="<%= game.getgameId() %>">
          <button type="submit" class="btn btn-danger">Delete</button>
        </form>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
