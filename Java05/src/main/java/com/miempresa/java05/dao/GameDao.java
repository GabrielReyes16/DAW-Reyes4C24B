package com.miempresa.java05.dao;

import com.miempresa.java05.dao.mysql.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.miempresa.java05.model.Game;
import java.util.List;

public class GameDao {

    public int addGame(Game game) throws Exception {

        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected = 0;

        String queryInsert = "INSERT INTO GAMES (name, category, console, protagonist) " +  "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, game.getName());
            ps.setString(2, game.getCategory());
            ps.setString(3, game.getConsole());
            ps.setString(4, game.getProtagonist());
            rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        System.out.println("El ID generado es: " + generatedId);
                    } else {
                        System.out.println("Error al obtener el ID generado.");
                    }
                }
            }
        }
        return rowsAffected;
    }
    public List<Game> getGames() throws Exception {

        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();

        String querySelect = "SELECT gameId, name, category, console, protagonist  FROM GAMES";
        try (Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery(querySelect)) {

            List<Game> listGames = new ArrayList<>();

            while (resultSet.next()) {
                Game game = new Game();
                game.setgameId(resultSet.getInt("gameId"));
                game.setName(resultSet.getString("name"));
                game.setCategory(resultSet.getString("category"));
                game.setConsole(resultSet.getString("console"));
                game.setProtagonist(resultSet.getString("protagonist"));
                listGames.add(game);
            }
            return listGames;
        }
    }


    public int editGame(Game game) throws Exception {
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected = 0;

        String queryUpdate = "UPDATE GAMES SET name=?, category=?, console=?, protagonist=?  WHERE gameId=?";

        try (PreparedStatement ps = con.prepareStatement(queryUpdate)) {
            ps.setString(1, game.getName());
            ps.setString(2, game.getCategory());
            ps.setString(3, game.getConsole());
            ps.setString(4, game.getProtagonist());
            ps.setInt(5, game.getgameId());

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }
    public Game getGameById(int gameId) throws Exception {
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();

        String querySelectById = "SELECT * FROM GAMES WHERE gameId=?";
        try (PreparedStatement ps = con.prepareStatement(querySelectById)) {
            ps.setInt(1, gameId);

            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    Game game = new Game();
                    game.setgameId(resultSet.getInt("gameId"));
                    game.setName(resultSet.getString("name"));
                    game.setCategory(resultSet.getString("category"));
                    game.setConsole(resultSet.getString("console"));
                    game.setProtagonist(resultSet.getString("protagonist"));
                    return game;
                }
            }
        }
        return null;
    }
    public int deleteGame(int gameId) throws Exception {
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected = 0;

        String queryDelete = "DELETE FROM GAMES WHERE gameId=?";

        try (PreparedStatement ps = con.prepareStatement(queryDelete)) {
            ps.setInt(1, gameId);

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }
}
