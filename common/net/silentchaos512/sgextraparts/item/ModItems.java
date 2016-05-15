package net.silentchaos512.sgextraparts.item;

import net.silentchaos512.lib.item.ItemSL;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;

public class ModItems {

  public static ItemIngot ingot = new ItemIngot();

  public static void init(SRegistry reg) {

    reg.registerItem(ingot);
  }
}
