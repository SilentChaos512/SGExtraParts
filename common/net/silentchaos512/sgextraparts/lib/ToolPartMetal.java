package net.silentchaos512.sgextraparts.lib;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.SilentGems;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.lib.EnumPartPosition;
import net.silentchaos512.gems.api.tool.part.ToolPartMain;
import net.silentchaos512.lib.registry.IRegistryObject;
import net.silentchaos512.sgextraparts.SGExtraParts;

public class ToolPartMetal extends ToolPartMain {

  EnumMetalPart metal;
  Map<String, ModelResourceLocation> modelMap = Maps.newHashMap();

  public ToolPartMetal(EnumMetalPart metal) {

    super(SGExtraParts.MOD_ID + ":" + metal.name().toLowerCase(), metal.getCraftingStack());
    this.craftingOreDictName = metal.getIngotOreName();
    this.tier = metal.getTier();
    this.metal = metal;
  }

  @Override
  public int getColor() {

    return metal.getColor();
  }

  @Override
  public String getDisplayName(ItemStack stack) {

    if (stack.hasDisplayName())
      return stack.getDisplayName();

    return metal.getName();
  }

  @Override
  public ModelResourceLocation getModel(ItemStack tool, EnumPartPosition pos) {

    String name = ((IRegistryObject) tool.getItem()).getName();
    name = SilentGems.MOD_ID + ":" + name.toLowerCase() + "/" + name;

    switch (pos) {
      case HEAD_MIDDLE:
        name += "15";
        break;
      case HEAD_LEFT:
        name += "15L";
        break;
      case HEAD_RIGHT:
        name += "15R";
        break;
      case ROD_DECO:
        name += "Deco15";
        break;
      default:
        return null;
    }

    if (modelMap.containsKey(name)) {
      return modelMap.get(name);
    }

    ModelResourceLocation model = new ModelResourceLocation(name, "inventory");
    modelMap.put(name, model);
    return model;
  }

  @Override
  public int getDurability() {

    return metal.getDurability();
  }

  @Override
  public float getHarvestSpeed() {

    return metal.getMiningSpeed();
  }

  @Override
  public int getHarvestLevel() {

    switch (tier) {
      case MUNDANE:
        return 1;
      case REGULAR:
        return 2;
      case SUPER:
        return 4;
      default:
        return 0;
    }
  }

  @Override
  public float getMeleeDamage() {

    return metal.getMeleeDamage();
  }

  @Override
  public float getMagicDamage() {

    return metal.getMagicDamage();
  }

  @Override
  public int getEnchantability() {

    return metal.getEnchantability();
  }

  @Override
  public float getMeleeSpeed() {

    return metal.getMeleeSpeed();
  }

  @Override
  public float getChargeSpeed() {

    return metal.getChargeSpeed();
  }

  @Override
  public EnumMaterialTier getTier() {

    return tier;
  }
}
