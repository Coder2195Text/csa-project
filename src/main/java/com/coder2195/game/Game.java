package com.coder2195.game;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

enum GameState {
    MainScreen,
    Game,
    DeathScreen
}

public class Game {
    public boolean isRunning = true;
    public GameState gameState = GameState.MainScreen;

    public HashMap<Coordinates, Character> blockData = new HashMap<Coordinates, Character>();

    Game() {

    }

    void renderList(String[] list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void clear() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void frame() {
        Game.clear();

        if (gameState == GameState.MainScreen) {
            renderList(Constants.MAIN_SCREEN_TEXT);
            System.out.println(Ansi.colorize("Press enter to continue...", Attribute.RAPID_BLINK(),
                    Attribute.YELLOW_TEXT(), Attribute.BOLD()));
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("");
            sc.next();
            sc.close();

            gameState = GameState.Game;
        } else {
            System.out.println(Ansi.colorize("Press enter to continue...", Attribute.GREEN_TEXT(), Attribute.BOLD()));
        }

    }

}
