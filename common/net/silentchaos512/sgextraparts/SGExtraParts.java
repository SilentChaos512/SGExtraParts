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
import net.silentchaos512.sgextraparts.lib.EnumPartEbonArts;
import net.silentchaos512.sgextraparts.lib.EnumPartExtreme;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;

//@formatter:off
@Mod(modid = SGExtraParts.MOD_ID_LOWER,
    name = SGExtraParts.MOD_NAME,
    version = SGExtraParts.VERSION,
    dependencies = SGExtraParts.DEPENDENCIES)
//@formatter:on
public class SGExtraParts {

  public static final String MOD_ID = "SGExtraParts";
  public static final String MOD_ID_LOWER = "sgextraparts";
  public static final String MOD_NAME = "Silent's Gems: Extra Parts";
  public static final String VERSION = "@VERSION@";
  public static final String DEPENDENCIES = "required-after:Forge@[12.16.1.1904,);required-after:SilentGems;";
  public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":";

  public static LogHelper logHelper = new LogHelper(MOD_NAME);
  public static LocalizationHelper localizationHelper;

  public static SRegistry registry = new SRegistry(MOD_ID);

  @Instance(MOD_ID_LOWER)
  public static SGExtraParts instance;

  @SidedProxy(clientSide = "net.silentchaos512.lib.proxy.ClientProxy", serverSide = "net.silentchaos512.lib.proxy.CommonProxy")
  public static net.silentchaos512.lib.proxy.CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {

    localizationHelper = new LocalizationHelper(MOD_ID).setReplaceAmpersand(true);
    SilentLib.instance.registerLocalizationHelperForMod(MOD_ID, localizationHelper);

    ConfigExtraParts.init(event.getSuggestedConfigurationFile());
    ModItems.init(registry);

    proxy.preInit(registry);
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {

    EnumPartMetal.registerToolParts();
    EnumPartExtreme.registerToolParts();
    if (Loader.isModLoaded("ea"))
      EnumPartEbonArts.registerToolParts();
    if (Loader.isModLoaded("Botania"))
      EnumPartBotania.registerToolParts();

    ConfigExtraParts.save();

    proxy.init(registry);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {

    proxy.postInit(registry);
  }
}
