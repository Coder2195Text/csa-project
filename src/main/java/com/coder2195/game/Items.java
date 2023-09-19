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

record ItemData(String emoji, int maxStackSize, int maxDurability) {}


class ToolArmorVariants {
  public static final Attribute WOOD = Attribute.BACK_COLOR(120, 96, 53);
  public static final Attribute STONE = Attribute.BACK_COLOR(128, 128, 128);
  public static final Attribute IRON = Attribute.BACK_COLOR(192, 192, 192);
  public static final Attribute DIAMOND = Attribute.BACK_COLOR(34, 200, 255);
  public static final Attribute GOLD = Attribute.BACK_COLOR(255, 215, 0);
}

public enum Items {
  GRASS,
  DIRT,
  STONE,
  WOOD,
  LEAVES,
  APPLES;

  class RawItemData {
    private String emoji;
    private int maxStackSize;
    private int maxDurability;
    private String variant;
    private HashMap<String, Integer[]> attributes = new HashMap<String, Integer[]>();
  }

  class RawData extends HashMap<String, RawItemData> {
  }

  public static HashMap<Items, ItemData> data = new HashMap<Items, ItemData>();

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
          attributes.add((Attribute) ToolArmorVariants.class.getField(item.variant.toUpperCase()).get(null));
        }

        data.put(Items.valueOf(name), new ItemData(Ansi.colorize(item.emoji, attributes.toArray(new Attribute[] {})),
            item.maxStackSize, item.maxDurability));

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
