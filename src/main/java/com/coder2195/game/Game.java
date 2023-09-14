package com.coder2195.game;

import java.util.HashMap;
import java.util.Scanner;

enum GameState {
    MainScreen,
    Game,
    DeathScreen
}

public class Game {
    public boolean isRunning = true;
    public GameState gameState = GameState.MainScreen;

    char c;

    public HashMap<Coordinates, Character> blockData = new HashMap();

    Game() {

    }

    public void frame() {
        Scanner sc = new Scanner(System.in);
        if (gameState == GameState.MainScreen) {

        }

        char c = sc.nextLine().charAt(0);
        System.out.println(c);

        
    }
    
}
