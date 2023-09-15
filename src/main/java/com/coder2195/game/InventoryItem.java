package com.coder2195.game;

public class InventoryItem {

  public byte count;
  public Inventory.Items item;

  InventoryItem(Inventory.Items item, byte count) {
    this.item = item;
    this.count = count;
  }

}
