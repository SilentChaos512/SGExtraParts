package net.silentchaos512.sgextraparts;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.silentchaos512.lib.SilentLib;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.lib.util.LocalizationHelper;
import net.silentchaos512.lib.util.LogHelper;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.world.WorldGeneratorSGEP;

//@formatter:off
@Mod(modid = SGExtraParts.MOD_ID,
    name = SGExtraParts.MOD_NAME,
    version = SGExtraParts.VERSION,
    dependencies = SGExtraParts.DEPENDENCIES,
    acceptedMinecraftVersions = SGExtraParts.ACCEPTED_MC_VERSIONS)
//@formatter:on
public class SGExtraParts {

  public static final String MOD_ID = "sgextraparts";
  public static final String MOD_NAME = "Silent's Gems: Extra Parts";
  public static final String VERSION = "@VERSION@";
  public static final String DEPENDENCIES = "required-after:silentgems;after:botania;after:calculator;after:cavern;after:ea;after:netherrocks";
  public static final String ACCEPTED_MC_VERSIONS = "[1.10.2,1.12.1]";
  public static final String RESOURCE_PREFIX = MOD_ID + ":";

  public static LogHelper logHelper = new LogHelper(MOD_NAME);
  public static LocalizationHelper localizationHelper;

  public static SRegistry registry = new SRegistry(MOD_ID);

  public static Random random = new Random();

  @Instance(MOD_ID)
  public static SGExtraParts instance;

  @SidedProxy(clientSide = "net.silentchaos512.sgextraparts.proxy.ClientProxy", serverSide = "net.silentchaos512.sgextraparts.proxy.CommonProxy")
  public static net.silentchaos512.lib.proxy.CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {

    localizationHelper = new LocalizationHelper(MOD_ID).setReplaceAmpersand(true);
    SilentLib.instance.registerLocalizationHelperForMod(MOD_ID, localizationHelper);

    ConfigExtraParts.init(event.getSuggestedConfigurationFile());

    registry.addRegistrationHandler(new net.silentchaos512.sgextraparts.init.ModBlocks(), Block.class);
    registry.addRegistrationHandler(new net.silentchaos512.sgextraparts.init.ModItems(), Item.class);

    GameRegistry.registerWorldGenerator(new WorldGeneratorSGEP(), 0);

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
