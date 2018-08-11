package net.silentchaos512.sgextraparts.init;

import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.block.BlockRock;

public class ModBlocks {
    public static BlockRock rock = new BlockRock();

    public static void registerAll(SRegistry reg) {
        reg.registerBlock(rock, "rock");
    }
}
