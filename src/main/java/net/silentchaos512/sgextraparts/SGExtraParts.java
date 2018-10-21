package net.silentchaos512.sgextraparts;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.silentchaos512.lib.base.IModBase;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.lib.util.I18nHelper;
import net.silentchaos512.lib.util.LogHelper;

import java.util.Random;

@Mod(modid = SGExtraParts.MOD_ID,
        name = SGExtraParts.MOD_NAME,
        version = SGExtraParts.VERSION,
        dependencies = SGExtraParts.DEPENDENCIES,
        acceptedMinecraftVersions = SGExtraParts.ACCEPTED_MC_VERSIONS)
@MethodsReturnNonnullByDefault
@SuppressWarnings({"unused", "WeakerAccess"})
public class SGExtraParts implements IModBase {
    public static final String MOD_ID = "sgextraparts";
    public static final String MOD_NAME = "Silent's Gems: Extra Parts";
    public static final String VERSION = "1.4.6";
    public static final String VERSION_GEMS = "2.8.3";
    public static final int BUILD_NUM = 0;
    public static final String DEPENDENCIES = "required-after:silentgems@[" + VERSION_GEMS + ",);" +
            "after:betterwithmods;after:botania;after:calculator;after:cavern;after:netherrocks";
    public static final String ACCEPTED_MC_VERSIONS = "[1.12,1.12.2]";
    public static final String RESOURCE_PREFIX = MOD_ID + ":";

    public static LogHelper log = new LogHelper(MOD_NAME, BUILD_NUM);
    public static I18nHelper i18n = new I18nHelper(MOD_ID, log, true);
    public static SRegistry registry = new SRegistry();

    public static Random random = new Random();

    @Instance(MOD_ID)
    public static SGExtraParts instance;

    @SidedProxy(clientSide = "net.silentchaos512.sgextraparts.proxy.ClientProxy", serverSide = "net.silentchaos512.sgextraparts.proxy.CommonProxy")
    public static net.silentchaos512.sgextraparts.proxy.CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        registry.setMod(this);
//        registry.getRecipeMaker().setJsonHellMode(0 == getBuildNum());
        proxy.preInit(registry, event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(registry, event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(registry, event);
    }

    @Override
    public String getModId() {
        return MOD_ID;
    }

    @Override
    public String getModName() {
        return MOD_NAME;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public int getBuildNum() {
        return BUILD_NUM;
    }
}
