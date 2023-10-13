package com.miempresa.java05.controller;

import com.miempresa.java05.model.Game;
import jakarta.servlet.RequestDispatcher;
import com.miempresa.java05.dao.GameDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "EditGameServlet", value = "/EditGameServlet")
public class EditGameServlet extends HttpServlet {

    private GameDao gdao;

    @Override
    public void init() throws ServletException {
        super.init();
        gdao = new GameDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int gameId = Integer.parseInt(request.getParameter("gameId"));

            Game game = gdao.getGameById(gameId);

            request.setAttribute("game", game);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/editgame.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e.getMessage());
            requestDispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int gameId = Integer.parseInt(request.getParameter("gameId"));
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            String console = request.getParameter("console");
            String protagonist = request.getParameter("protagonist");
            Game modifiedGame = new Game(gameId, name, category, console, protagonist);

            int rowsAffected = gdao.editGame(modifiedGame);

            if (rowsAffected > 0) {
                List<Game> listGames = gdao.getGames();
                request.setAttribute("list", listGames);
                request.setAttribute("message", "Game modified, bro!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/listGame.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                request.setAttribute("message", "Can't modify this game, bro... Sorry.");
                requestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e.getMessage());
            requestDispatcher.forward(request, response);
        }
    }

}




