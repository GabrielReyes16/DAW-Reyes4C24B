package com.miempresa.java05.controller;

import com.miempresa.java05.dao.GameDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteGameServlet", value = "/DeleteGameServlet")
public class DeleteGameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gameId = Integer.parseInt(request.getParameter("gameId"));

        GameDao gdao = new GameDao();
        try {
            int rowsAffected = gdao.deleteGame(gameId);
            if (rowsAffected > 0) {
                response.sendRedirect("ListGameServlet");
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                request.setAttribute("message", "Can't find this game bro, sorry");
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
