package net.silentchaos512.sgextraparts.item;

import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.silentchaos512.gems.SilentGems;
import net.silentchaos512.lib.item.ItemSL;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;

public class ItemIngot extends ItemSL {

  public ItemIngot() {

    super(EnumPartMetal.values().length, SGExtraParts.MOD_ID, "Ingot");
  }

  @Override
  public void getModels(Map<Integer, ModelResourceLocation> models) {

    models.put(0, new ModelResourceLocation(SGExtraParts.RESOURCE_PREFIX + "ingot", "inventory"));
  }

  @SideOnly(Side.CLIENT)
  @Override
  public boolean registerModels() {

    ModelResourceLocation model = new ModelResourceLocation(SGExtraParts.RESOURCE_PREFIX + "ingot", "inventory");
    for (int i = 0; i < subItemCount; ++i) {
      ModelLoader.setCustomModelResourceLocation(this, i, model);
    }

    return true;
  }

  @Override
  public void addOreDict() {

    for (EnumPartMetal metal : EnumPartMetal.values())
      OreDictionary.registerOre(metal.getCraftingOreName(), metal.getCraftingStack());
  }

  @Override
  public void clAddInformation(ItemStack stack, World world, List list, boolean advanced) {

    list.addAll(SGExtraParts.instance.localizationHelper.getItemDescriptionLines("ingot"));
  }

  @Override
  public String getNameForStack(ItemStack stack) {

    int meta = stack.getItemDamage();
    if (meta >= 0 && meta < EnumPartMetal.values().length)
      return "ingot_" + EnumPartMetal.values()[meta].getName().toLowerCase();
    else
      return "ingot_unknown";
  }
}
