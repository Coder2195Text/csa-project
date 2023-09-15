package com.coder2195.game;

import java.util.HashMap;

public class Inventory {
  public static enum Items {
    GRASS,
    DIRT,
    STONE,
    WOOD,
    LEAVES,
    APPLES,
    SWORD,
    PICKAXE,
    IRON,
    DIAMONDS,
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS
  }

  public static HashMap<Items, String> itemData = new HashMap<Items, String>();

  InventoryItem[] inventoryItems = new InventoryItem[32];

  static {
    itemData.put(Items.GRASS, "🌿");
    itemData.put(Items.DIRT, "🟫");
    itemData.put(Items.STONE, "🪨");
    itemData.put(Items.WOOD, "🪵");
    itemData.put(Items.LEAVES, "🍃");
    itemData.put(Items.APPLES, "🍎");
    itemData.put(Items.SWORD, "🗡️");
    itemData.put(Items.PICKAXE, "⛏️");
    itemData.put(Items.IRON, "🪙");
    itemData.put(Items.DIAMONDS, "💎");
    itemData.put(Items.HELMET, "🧢");
    itemData.put(Items.CHESTPLATE, "🎽");
    itemData.put(Items.LEGGINGS, "👖");
    itemData.put(Items.BOOTS, "🥿");

  }

  public Inventory() {

  }

  public boolean addItem(Items item, byte count) {
    int firstIndex = -1;
    for (int i = 0; i < inventoryItems.length; i++) {
      if (inventoryItems[i] == null) {
        firstIndex = i;
      }
      if (inventoryItems[i] != null && inventoryItems[i].item == item) {
        inventoryItems[i].count += count;
        return true;
      }
    }

    if (firstIndex != -1) {
      inventoryItems[firstIndex] = new InventoryItem(item, count);
      return true;
    }

    return false;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int r = 4; r > 0; r--) {
      sb.append('┏');
      for (int c = 0; c < 8; c++) {
        sb.append("━━┯");
      }
      sb.append("━━┓\n");
      sb.append('┃');
      
      sb.append('\n');
    }

    return sb.toString();
  }
}
