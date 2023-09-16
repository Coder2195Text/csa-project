package com.coder2195.game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        while (game.isRunning) {
            game.frame();
        }

    }
}