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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    return "Inventory";
  }
}
