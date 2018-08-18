package net.silentchaos512.sgextraparts.lib;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.SilentGems;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.lib.IPartPosition;
import net.silentchaos512.gems.api.lib.ToolPartPosition;
import net.silentchaos512.gems.api.tool.part.ToolPartRod;
import net.silentchaos512.sgextraparts.SGExtraParts;

public class ToolPartRodSGEP extends ToolPartRod {

  int color;

  public ToolPartRodSGEP(String name, ItemStack craftingStack, float durabilityMulti,
      float harvestSpeedMutli, float meleeDamageMulti, float magicDamageMulti,
      float enchantabilityMulti, int color) {

    super(SGExtraParts.RESOURCE_PREFIX + name.toLowerCase(), craftingStack, durabilityMulti,
        harvestSpeedMutli, meleeDamageMulti, magicDamageMulti, enchantabilityMulti);
    this.color = color;
    this.tier = EnumMaterialTier.MUNDANE;
  }

  @Override
  public int getColor(ItemStack toolOrArmor, IPartPosition position, int animationFrame) {

    return color;
  }

  @Override
  public ModelResourceLocation getModel(ItemStack toolOrArmor, ToolPartPosition pos, int frame) {

    Item item = toolOrArmor.getItem();
    String name = item.getRegistryName().getPath();
    name = SilentGems.MODID + ":" + name.toLowerCase() + "/" + name + "_rod_generic";
    return new ModelResourceLocation(name.toLowerCase(), "inventory");
  }
}
