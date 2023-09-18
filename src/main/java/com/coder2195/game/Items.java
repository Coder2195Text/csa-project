package com.coder2195.game;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

class ItemData {
  String emoji;
  int maxStackSize = Constants.STACK_SIZE;
  int maxDurability = 0;
}

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
  APPLES,
  WOODEN_SWORD,
  WOODEN_SHOVEL,
  WOODEN_HOE,
  WOODEN_AXE,
  WOODEN_PICKAXE,
  STONE_SWORD,
  STONE_SHOVEL,
  STONE_HOE,
  STONE_AXE,
  STONE_PICKAXE,
  IRON,
  DIAMONDS,
  IRON_HELMET,
  IRON_CHESTPLATE,
  IRON_LEGGINGS,
  IRON_BOOTS,
  GOLD,
  ;

  public static HashMap<Items, ItemData> data = new HashMap<Items, ItemData>();

  static {
    // data.put(Items.GRASS, new ItemData() {
    // {
    // emoji = "🌿";
    // }
    // });
    // data.put(Items.DIRT, new ItemData() {
    // {
    // emoji = "🟫";
    // }
    // });
    // data.put(Items.STONE, new ItemData() {
    // {
    // emoji = "⬜";
    // }
    // });
    // data.put(Items.WOOD, new ItemData() {
    // {
    // emoji = "🟧";
    // }
    // });
    // data.put(Items.LEAVES, new ItemData() {
    // {
    // emoji = "🍃";
    // }
    // });
    // data.put(Items.APPLES, new ItemData() {
    // {
    // emoji = "🍎";
    // }
    // });
    // data.put(Items.WOODEN_SWORD, new ItemData() {
    // {
    // emoji = Ansi.colorize("🗡️", ToolArmorVariants.WOOD);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.WOODEN_HOE, new ItemData() {
    // {
    // emoji = Ansi.colorize("🔨", ToolArmorVariants.WOOD);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.WOODEN_AXE, new ItemData() {
    // {
    // emoji = Ansi.colorize("🪓", ToolArmorVariants.WOOD);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.WOODEN_PICKAXE, new ItemData() {
    // {
    // emoji = Ansi.colorize("⛏️", ToolArmorVariants.WOOD);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.WOODEN_SHOVEL, new ItemData() {
    // {
    // emoji = Ansi.colorize("🥄", ToolArmorVariants.WOOD);
    // maxStackSize = 1;
    // }
    // });

    // data.put(Items.STONE_SWORD, new ItemData() {
    // {
    // emoji = Ansi.colorize("🗡️", ToolArmorVariants.STONE);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.STONE_HOE, new ItemData() {
    // {
    // emoji = Ansi.colorize("🔨", ToolArmorVariants.STONE);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.STONE_AXE, new ItemData() {
    // {
    // emoji = Ansi.colorize("🪓", ToolArmorVariants.STONE);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.STONE_PICKAXE, new ItemData() {
    // {
    // emoji = Ansi.colorize("⛏️", ToolArmorVariants.STONE);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.STONE_SHOVEL, new ItemData() {
    // {
    // emoji = Ansi.colorize("🥄", ToolArmorVariants.STONE);
    // maxStackSize = 1;
    // }
    // });

    // data.put(Items.IRON, new ItemData() {
    // {
    // emoji = "🔘";
    // }
    // });
    // data.put(Items.DIAMONDS, new ItemData() {
    // {
    // emoji = "💎";
    // }
    // });
    // data.put(Items.IRON_HELMET, new ItemData() {
    // {
    // emoji = Ansi.colorize("🧢", ToolArmorVariants.IRON);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.IRON_CHESTPLATE, new ItemData() {
    // {
    // emoji = Ansi.colorize("👕", ToolArmorVariants.IRON);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.IRON_LEGGINGS, new ItemData() {
    // {
    // emoji = Ansi.colorize("👖", ToolArmorVariants.IRON);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.IRON_BOOTS, new ItemData() {
    // {
    // emoji = Ansi.colorize("👟", ToolArmorVariants.IRON);
    // maxStackSize = 1;
    // }
    // });
    // data.put(Items.GOLD, new ItemData() {
    // {
    // emoji = "🪙";
    // }
    // });
    try (InputStreamReader in = new InputStreamReader(
        Thread.currentThread().getContextClassLoader().getResourceAsStream("/items.json"))) {

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
