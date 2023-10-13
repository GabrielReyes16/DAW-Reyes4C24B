package com.miempresa.java05.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.miempresa.java05.model.Game;
import com.miempresa.java05.dao.GameDao;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListGameServlet", value = "/ListGameServlet")
public class ListGameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameDao gdao = new GameDao();
        try {
            List<Game> listGames = gdao.getGames();
            request.setAttribute("list", listGames);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listGame.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e.getMessage());
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
