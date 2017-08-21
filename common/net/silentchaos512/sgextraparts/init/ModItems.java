package net.silentchaos512.sgextraparts.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.silentchaos512.gems.lib.GemsCreativeTabs;
import net.silentchaos512.lib.registry.IRegistrationHandler;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.item.ItemGeneric;
import net.silentchaos512.sgextraparts.item.ItemIngot;
import net.silentchaos512.sgextraparts.item.ItemPolisher;
import net.silentchaos512.sgextraparts.lib.EnumPartBotania;
import net.silentchaos512.sgextraparts.lib.EnumPartCalculator;
import net.silentchaos512.sgextraparts.lib.EnumPartCavern;
import net.silentchaos512.sgextraparts.lib.EnumPartEbonArts;
import net.silentchaos512.sgextraparts.lib.EnumPartExtreme;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;
import net.silentchaos512.sgextraparts.lib.EnumPartMisc;
import net.silentchaos512.sgextraparts.lib.EnumPartNetherrocks;
import net.silentchaos512.sgextraparts.lib.EnumPartVanillaBasic;

public class ModItems implements IRegistrationHandler<Item> {

  public static ItemPolisher polisher = new ItemPolisher();
  public static ItemIngot ingot = new ItemIngot();
  public static ItemGeneric generic = new ItemGeneric();

  @Override
  public void registerAll(SRegistry reg) {

    reg.registerItem(polisher).setCreativeTab(GemsCreativeTabs.materials);
    reg.registerItem(ingot).setCreativeTab(GemsCreativeTabs.materials);
    reg.registerItem(generic).setCreativeTab(GemsCreativeTabs.materials);

    EnumPartVanillaBasic.registerToolParts();
    EnumPartMetal.registerToolParts();
    EnumPartExtreme.registerToolParts();
    EnumPartMisc.registerToolParts();
    if (Loader.isModLoaded("ea"))
      EnumPartEbonArts.registerToolParts();
    if (Loader.isModLoaded("botania"))
      EnumPartBotania.registerToolParts();
    if (Loader.isModLoaded(EnumPartNetherrocks.MOD_ID))
      EnumPartNetherrocks.registerToolParts();
    if (Loader.isModLoaded(EnumPartCalculator.MOD_ID))
      EnumPartCalculator.registerToolParts();
    if (Loader.isModLoaded(EnumPartCavern.MOD_ID))
      EnumPartCavern.registerToolParts();
  }
}
