package com.coder2195.game;

public class InventoryItem {

  private int count;
  private Items item;

  InventoryItem(Items item, int count) {
    this.item = item;
    this.count = count;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public Items getItem() {
    return item;
  }

  public void setItem(Items item) {
    this.item = item;
  }

  

}
