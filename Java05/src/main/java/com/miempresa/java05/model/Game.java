package com.miempresa.java05.model;
public class Game {

    private String name;
    private String category;
    private String console;
    private String protagonist;
    private int gameId;


    public Game(int gameId, String name, String category, String console, String protagonist) {
        this.gameId = gameId;
        this.name = name;
        this.category = category;
        this.console = console;
        this.protagonist = protagonist;
    }

    public Game(){

    }

    public int getgameId() {
        return gameId;
    }

    public void setgameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

}