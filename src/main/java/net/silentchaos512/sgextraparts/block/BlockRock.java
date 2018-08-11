package net.silentchaos512.sgextraparts.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.silentchaos512.lib.block.BlockSL;
import net.silentchaos512.lib.util.StackHelper;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.init.ModItems;

public class BlockRock extends BlockSL {

  static final AxisAlignedBB boundingBox = new AxisAlignedBB(0.2, 0, 0.2, 0.8, 0.3, 0.8);

  public BlockRock() {

    super(1, SGExtraParts.MOD_ID, "rock", Material.CIRCUITS);
    setHardness(0.2f);
  }

  @Override
  public boolean isOpaqueCube(IBlockState state) {

    return false;
  }

  @Override
  public boolean isFullCube(IBlockState state) {

    return false;
  }

  @Override
  public boolean causesSuffocation(IBlockState state) {

    return false;
  }

  @Override
  public List<ItemStack> clGetDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

    List<ItemStack> list = new ArrayList<>();
    list.add(StackHelper.safeCopy(ModItems.generic.feldspar));
    if (SGExtraParts.random.nextBoolean())
      list.add(StackHelper.safeCopy(ModItems.generic.feldspar));
    return list;
  }

  @Override
  protected void clAddCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
      Entity entity) {

  }

  @Override
  public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

    return boundingBox;
  }
}
