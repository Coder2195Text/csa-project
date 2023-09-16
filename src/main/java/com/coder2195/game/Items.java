package com.coder2195.game;

import java.util.HashMap;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

class ItemData {
  String emoji;
  int maxStackSize = Constants.STACK_SIZE;
}

public enum Items {
  GRASS,
  DIRT,
  STONE,
  WOOD,
  LEAVES,
  APPLES,
  WOODEN_SWORD,
  WOODEN_PICKAXE,
  IRON,
  DIAMONDS,
  HELMET,
  CHESTPLATE,
  LEGGINGS,
  BOOTS;

  public static HashMap<Items, ItemData> data = new HashMap<Items, ItemData>();
  static {
    data.put(Items.GRASS, new ItemData() {
      {
        emoji = "🟩";
      }
    });
    data.put(Items.DIRT, new ItemData() {
      {
        emoji = "🟫";
      }
    });
    data.put(Items.STONE, new ItemData() {
      {
        emoji = "⬜";
      }
    });
    data.put(Items.WOOD, new ItemData() {
      {
        emoji = "🟧";
      }
    });
    data.put(Items.LEAVES, new ItemData() {
      {
        emoji = "🍃";
      }
    });
    data.put(Items.APPLES, new ItemData() {
      {
        emoji = "🍎";
      }
    });
    data.put(Items.WOODEN_SWORD, new ItemData() {
      {
        emoji = Ansi.colorize("⚔️ ", Attribute.BACK_COLOR(120, 96, 53));
        maxStackSize = 1;
      }
    });
    data.put(Items.WOODEN_PICKAXE, new ItemData() {
      {
        emoji = "⛏️";
        maxStackSize = 1;
      }
    });
    data.put(Items.IRON, new ItemData() {
      {
        emoji = "🔘";
      }
    });
    data.put(Items.DIAMONDS, new ItemData() {
      {
        emoji = "💎";
      }
    });
    data.put(Items.HELMET, new ItemData() {
      {
        emoji = "🪖";
        maxStackSize = 1;
      }
    });
    data.put(Items.CHESTPLATE, new ItemData() {
      {
        emoji = "🥋";
        maxStackSize = 1;
      }
    });
    data.put(Items.LEGGINGS, new ItemData() {
      {
        emoji = "🩳";
        maxStackSize = 1;
      }
    });
    data.put(Items.BOOTS, new ItemData() {
      {
        emoji = "🥾";
        maxStackSize = 1;
      }
    });

  }

}
