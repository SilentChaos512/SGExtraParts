package net.silentchaos512.sgextraparts.init;

import net.minecraft.block.Block;
import net.silentchaos512.lib.registry.IRegistrationHandler;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.block.BlockRock;

public class ModBlocks implements IRegistrationHandler<Block> {

  public static BlockRock rock = new BlockRock();

  @Override
  public void registerAll(SRegistry reg) {

    reg.registerBlock(rock);
  }
}
