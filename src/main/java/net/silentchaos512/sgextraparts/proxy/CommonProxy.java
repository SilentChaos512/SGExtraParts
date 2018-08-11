package net.silentchaos512.sgextraparts.proxy;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.silentchaos512.lib.proxy.IProxy;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.init.ModBlocks;
import net.silentchaos512.sgextraparts.init.ModItems;
import net.silentchaos512.sgextraparts.world.WorldGeneratorSGEP;

import java.util.function.Consumer;

public class CommonProxy implements IProxy {
    @Override
    public void preInit(SRegistry registry, FMLPreInitializationEvent event) {
        ConfigExtraParts.init(event.getSuggestedConfigurationFile());

        // The casts stop a deprecation warning, but it works either way
        registry.addRegistrationHandler((Consumer<SRegistry>) ModBlocks::registerAll, Block.class);
        registry.addRegistrationHandler((Consumer<SRegistry>) ModItems::registerAll, Item.class);

        GameRegistry.registerWorldGenerator(new WorldGeneratorSGEP(), 0);

        registry.preInit(event);
    }

    @Override
    public void init(SRegistry registry, FMLInitializationEvent event) {
        ConfigExtraParts.save();
        registry.init(event);
    }

    @Override
    public void postInit(SRegistry registry, FMLPostInitializationEvent event) {
        registry.postInit(event);
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }

    @Override
    public int getParticleSettings() {
        return 0;
    }
}
