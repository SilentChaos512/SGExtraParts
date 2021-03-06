package net.silentchaos512.sgextraparts.init;

import net.minecraftforge.fml.common.Loader;
import net.silentchaos512.gems.lib.GemsCreativeTabs;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.item.ItemGeneric;
import net.silentchaos512.sgextraparts.item.ItemIngot;
import net.silentchaos512.sgextraparts.item.ItemPolisher;
import net.silentchaos512.sgextraparts.lib.*;

public class ModItems {
    public static ItemPolisher polisher = new ItemPolisher();
    public static ItemIngot ingot = new ItemIngot();
    public static ItemGeneric generic = new ItemGeneric();

    public static void registerAll(SRegistry reg) {
        reg.registerItem(polisher, "polisher").setCreativeTab(GemsCreativeTabs.MATERIALS);
        reg.registerItem(ingot, "ingot").setCreativeTab(GemsCreativeTabs.MATERIALS);
        reg.registerItem(generic, "genericitem").setCreativeTab(GemsCreativeTabs.MATERIALS);

        // Register tool parts
        EnumPartVanillaBasic.registerToolParts();
        EnumPartMetal.registerToolParts();
        EnumPartExtreme.registerToolParts();
        EnumPartMisc.registerToolParts();
        // Confict: Expanded Arcanum uses the same mod ID... Just disable since Ebon Arts is no more
//        if (Loader.isModLoaded("ea"))
//            EnumPartEbonArts.registerToolParts();
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
