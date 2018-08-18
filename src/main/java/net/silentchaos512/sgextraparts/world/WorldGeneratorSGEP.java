package net.silentchaos512.sgextraparts.world;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.silentchaos512.lib.world.WorldGeneratorSL;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.init.ModBlocks;

import java.util.Random;

public class WorldGeneratorSGEP extends WorldGeneratorSL {

  public WorldGeneratorSGEP() {

    super(false, "sgextraparts_retrogen");
  }

  @Override
  protected void generateSurface(World world, Random random, int posX, int posZ) {

    int i, x, y, z;
    IBlockState state;
    BlockPos pos;

    int rockCount = (int) ConfigExtraParts.ROCK_FELDSPAR_PER_CHUNK;
    float extraChance = ConfigExtraParts.ROCK_FELDSPAR_PER_CHUNK - rockCount;
    if (SGExtraParts.random.nextFloat() < extraChance)
      ++rockCount;

    for (i = 0; i < rockCount; ++i) {
      x = posX + 8 + random.nextInt(16);
      y = random.nextInt(100) + 80;
      z = posZ + 8 + random.nextInt(16);
      pos = new BlockPos(x, y, z);

      state = ModBlocks.rock.getDefaultState();

      // Find top-most valid block
      for (; y > 40; --y) {
        IBlockState stateDown = world.getBlockState(pos.down());
        Material material = stateDown.getMaterial();
        if (world.isAirBlock(pos) && pos.getY() < 255 && world.isBlockFullCube(pos.down())
            && (material == Material.ROCK || material == Material.GROUND || material == Material.GRASS)) {
          world.setBlockState(pos, state, 2);
          break;
        }
        pos = pos.down();
      }
    }
  }
}
