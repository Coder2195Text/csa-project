package com.coder2195.game;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class Inventory {

  InventoryItem[] inventoryItems = new InventoryItem[42];
  int currentSelected = 0;

  public Inventory() {

  }

  public int addItem(Items item, int count) {
    int maxStackSize = Items.data.get(item).maxStackSize;
    ArrayList<Integer> emptyIndices = new ArrayList<Integer>();
    for (int i = 0; i < inventoryItems.length; i++) {
      if (inventoryItems[i] == null) {
        emptyIndices.add(i);
      } else if (inventoryItems[i].item == item) {
        if (inventoryItems[i].count + count > maxStackSize) {
          count -= (maxStackSize - inventoryItems[i].count);
          inventoryItems[i].count = maxStackSize;
          continue;
        }
        inventoryItems[i].count += count;
        return 0;
      }
    }

    for (int index : emptyIndices) {
      if (count > maxStackSize) {
        inventoryItems[index] = new InventoryItem(item, maxStackSize);
        count -= maxStackSize;
      } else {
        inventoryItems[index] = new InventoryItem(item, count);
        return 0;
      }
    }

    return count;
  }

  String topBar() {
    StringBuilder sb = new StringBuilder();
    sb.append('┏');
    for (int c = 0; c < 8; c++) {
      sb.append("━━━━━┯");
    }
    sb.append("━━━━━┓\n");
    return sb.toString();
  }

  String bottomBar() {
    StringBuilder sb = new StringBuilder();
    sb.append('┗');
    for (int c = 0; c < 8; c++) {
      sb.append("━━━━━┷");
    }
    sb.append("━━━━━┛\n");
    return sb.toString();
  }

  String row(InventoryItem[] row) {
    return row(row, currentSelected);
  }

  String row(InventoryItem[] row, int selected) {
    if (selected < 0) {
      selected = -2;
    }
    if (selected > 8) {
      selected = 8;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(selected == 0 ? '>' : '┃');
    for (int c = 0; c < 9; c++) {

      if (row[c] != null) {
        int count = row[c].count;
        sb.append(Items.data.get(row[c].item).emoji);
        sb.append(count == 1 ? "   " : StringUtils.leftPad(String.valueOf(row[c].count), 3));
      } else {
        sb.append("     ");
      }
      sb.append(c == selected ? "<" : c + 1 == selected ? ">" : c == 8 ? "┃" : "│");
    }
    sb.append("\n");
    sb.append(selected == 0 ? '>' : '┃');
    for (int c = 0; c < 9; c++) {
      sb.append("     ");
      sb.append(c == selected ? "<" : c + 1 == selected ? ">" : c == 8 ? "┃" : "│");
    }
    sb.append("\n");

    return sb.toString();
  }

  String rowGap() {
    return "┠─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┨\n";
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    sb.append(topBar());
    sb.append(row(new InventoryItem[] { inventoryItems[9], inventoryItems[10], inventoryItems[11],
        inventoryItems[12], inventoryItems[13], inventoryItems[14], inventoryItems[15], inventoryItems[16],
        inventoryItems[17] }, -1));
    sb.append(rowGap());
    sb.append(row(new InventoryItem[] { inventoryItems[18], inventoryItems[19], inventoryItems[20],
        inventoryItems[21], inventoryItems[22], inventoryItems[23], inventoryItems[24], inventoryItems[25],
        inventoryItems[26] }, -1));
    sb.append(rowGap());
    sb.append(row(new InventoryItem[] { inventoryItems[27], inventoryItems[28], inventoryItems[29],
        inventoryItems[30], inventoryItems[31], inventoryItems[32], inventoryItems[33], inventoryItems[34],
        inventoryItems[35] }, -1));

    sb.append(bottomBar());

    sb.append(topBar());
    sb.append(row(new InventoryItem[] { inventoryItems[0], inventoryItems[1],
        inventoryItems[2], inventoryItems[3],
        inventoryItems[4], inventoryItems[5], inventoryItems[6], inventoryItems[7], inventoryItems[8] },
        currentSelected));

    sb.append(bottomBar());

    return sb.toString();
  }
}
