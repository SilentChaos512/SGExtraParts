package net.silentchaos512.sgextraparts;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.silentchaos512.lib.SilentLib;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.lib.util.LocalizationHelper;
import net.silentchaos512.lib.util.LogHelper;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.item.ModItems;
import net.silentchaos512.sgextraparts.lib.EnumPartBotania;
import net.silentchaos512.sgextraparts.lib.EnumPartCalculator;
import net.silentchaos512.sgextraparts.lib.EnumPartCavern;
import net.silentchaos512.sgextraparts.lib.EnumPartEbonArts;
import net.silentchaos512.sgextraparts.lib.EnumPartExtreme;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;
import net.silentchaos512.sgextraparts.lib.EnumPartNetherrocks;
import net.silentchaos512.sgextraparts.lib.EnumPartVanillaBasic;

//@formatter:off
@Mod(modid = SGExtraParts.MOD_ID,
    name = SGExtraParts.MOD_NAME,
    version = SGExtraParts.VERSION,
    dependencies = SGExtraParts.DEPENDENCIES)
//@formatter:on
public class SGExtraParts {

  public static final String MOD_ID = "sgextraparts";
  public static final String MOD_NAME = "Silent's Gems: Extra Parts";
  public static final String VERSION = "@VERSION@";
  public static final String DEPENDENCIES = "required-after:forge@[12.16.1.1904,);required-after:silentgems;"
      + "after:botania;after:calculator;after:ea";
  public static final String RESOURCE_PREFIX = MOD_ID+ ":";

  public static LogHelper logHelper = new LogHelper(MOD_NAME);
  public static LocalizationHelper localizationHelper;

  public static SRegistry registry = new SRegistry(MOD_ID);

  @Instance(MOD_ID)
  public static SGExtraParts instance;

  @SidedProxy(clientSide = "net.silentchaos512.lib.proxy.ClientProxy", serverSide = "net.silentchaos512.lib.proxy.CommonProxy")
  public static net.silentchaos512.lib.proxy.CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {

    localizationHelper = new LocalizationHelper(MOD_ID).setReplaceAmpersand(true);
    SilentLib.instance.registerLocalizationHelperForMod(MOD_ID, localizationHelper);

    ConfigExtraParts.init(event.getSuggestedConfigurationFile());
    ModItems.init(registry);

    EnumPartVanillaBasic.registerToolParts();
    EnumPartMetal.registerToolParts();
    EnumPartExtreme.registerToolParts();
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

    proxy.preInit(registry);
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {

    ConfigExtraParts.save();

    proxy.init(registry);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {

    proxy.postInit(registry);
  }
}
