package net.silentchaos512.sgextraparts.item;

import net.silentchaos512.lib.item.ItemSL;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.lib.EnumMetalPart;

public class ModItems {

  public static ItemSL ingot = new ItemSL(EnumMetalPart.values().length, SGExtraParts.MOD_ID,
      "Ingot");

  public static void init(SRegistry reg) {

    reg.registerItem(ingot);
  }
}
