package com.coder2195.game;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// class ItemData {
// public final String emoji;
// ...
// }

public enum Items {
  GRASS,
  DIRT,
  STONE,
  WOOD,
  LEAVES,
  APPLES,
  SAPLINGS,
  WOODEN_PICKAXE,
  WOODEN_AXE,
  WOODEN_SWORD,
  WOODEN_SHOVEL,
  WOODEN_HOE,
  STONE_PICKAXE,
  STONE_AXE,
  STONE_SWORD,
  STONE_SHOVEL,
  STONE_HOE,

  ;

  private class RawItemData {
    private String emoji;
    private int maxStackSize;
    private int maxDurability;
    private String variant;
    private String type;
  }

  public static final HashMap<Items, ItemData> data = new HashMap<Items, ItemData>();

  static {
    try (InputStreamReader in = new InputStreamReader(
        Thread.currentThread().getContextClassLoader().getResourceAsStream("items.json"))) {
      JsonObject items = new Gson().fromJson(in, JsonElement.class).getAsJsonObject();
      items.remove("$schema");
      for (Map.Entry<String, JsonElement> entry : items.entrySet()) {
        String name = entry.getKey();
        RawItemData item = new Gson().fromJson(entry.getValue().toString(), RawItemData.class);

        item.maxStackSize = item.maxStackSize == 0 ? Constants.STACK_SIZE : item.maxStackSize;

        ArrayList<Attribute> attributes = new ArrayList<>();

        if (item.variant != null) {
          attributes.add((Attribute) ToolArmorVariant.class.getField(item.variant.toUpperCase()).get(null));
        }

        if (item.type == null) {
          item.type = "BLOCK";
        }

        data.put(Items.valueOf(name), new ItemData(Ansi.colorize(item.emoji, attributes.toArray(new Attribute[] {})),
            item.maxStackSize, item.maxDurability, ItemType.valueOf(item.type)));

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
