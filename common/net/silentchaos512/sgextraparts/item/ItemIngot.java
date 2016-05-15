package net.silentchaos512.sgextraparts.item;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;
import net.silentchaos512.lib.item.ItemSL;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;

public class ItemIngot extends ItemSL {

  public ItemIngot() {

    super(EnumPartMetal.values().length, SGExtraParts.MOD_ID, "Ingot");
  }

  @Override
  public List<ModelResourceLocation> getVariants() {

    return Lists.newArrayList(
        new ModelResourceLocation(SGExtraParts.RESOURCE_PREFIX + "Ingot", "inventory"));
  }

  @Override
  public boolean registerModels() {

    ModelResourceLocation model = getVariants().get(0);
    ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
    for (int i = 0; i < subItemCount; ++i) {
      mesher.register(this, i, model);
    }

    // Register color handler here for convenience.
    Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {

      @Override
      public int getColorFromItemstack(ItemStack stack, int tintIndex) {

        int meta = stack.getItemDamage();
        meta = MathHelper.clamp_int(meta, 0, subItemCount - 1);
        return tintIndex == 0 ? EnumPartMetal.values()[meta].getColor() : 0xFFFFFF;
      }
    }, this);

    return true;
  }

  @Override
  public void addOreDict() {

    for (EnumPartMetal metal : EnumPartMetal.values())
      OreDictionary.registerOre(metal.getIngotOreName(), metal.getCraftingStack());
  }

  @Override
  public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {

    list.addAll(SGExtraParts.instance.localizationHelper.getItemDescriptionLines("Ingot"));
  }
}
