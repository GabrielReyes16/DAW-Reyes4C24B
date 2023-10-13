package com.miempresa.java05.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.miempresa.java05.dao.GameDao;
import com.miempresa.java05.model.Game;

import java.io.IOException;
@WebServlet(name = "GameServlet", value = "/GameServlet")
public class AddGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addgame.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GameDao gdao = new GameDao();
        int rowsAffected = 0;

        Game game = new Game();
        game.setName(request.getParameter("name"));
        game.setCategory(request.getParameter("category"));
        game.setConsole(request.getParameter("console"));
        game.setProtagonist(request.getParameter("protagonist"));

        try{
            rowsAffected = gdao.addGame(game);
            if(rowsAffected>0) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
                request.setAttribute("rowsaffected", rowsAffected);
                requestDispatcher.forward(request, response);
            }
        }catch(Exception e){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("message", e );
            requestDispatcher.forward(request,response);
            e.printStackTrace();
        }
    }
}