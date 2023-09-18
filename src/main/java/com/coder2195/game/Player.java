package com.coder2195.game;

public class Player {
    private Inventory inventory = new Inventory();
    private Coordinates position;
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Coordinates getPosition() {
        return position;
    }
    public void setPosition(Coordinates position) {
        this.position = position;
    }

    
}
