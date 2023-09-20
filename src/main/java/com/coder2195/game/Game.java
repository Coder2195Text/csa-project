package com.coder2195.game;

import java.util.HashMap;
import java.util.Scanner;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

enum GameState {
    MainScreen,
    Game,
    DeathScreen
}

public class Game {
    private boolean isRunning = true;
    private GameState gameState = GameState.MainScreen;
    private Player player = new Player();

    private HashMap<Coordinates, Character> blockData = new HashMap<Coordinates, Character>();

    Game() {
        for (Items item : Items.values()) {

            player.getInventory().addItem(item, 1);

        }

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public GameState getGameState() {
        return gameState;
    }

    public HashMap<Coordinates, Character> getBlockData() {
        return blockData;
    }

    private void renderList(String[] list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void clear() {
        try {
            Thread.sleep(30);
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
            System.out.println(player.getInventory());
        }

    }

}
