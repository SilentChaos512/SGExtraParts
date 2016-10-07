package net.silentchaos512.sgextraparts.lib;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.SilentGems;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.lib.EnumPartPosition;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartMain;
import net.silentchaos512.gems.item.tool.ItemGemBow;
import net.silentchaos512.lib.registry.IRegistryObject;
import net.silentchaos512.sgextraparts.SGExtraParts;

public class ToolPartSGEP extends ToolPartMain {

  IPartProperties properties;
  Map<String, ModelResourceLocation> modelMap = Maps.newHashMap();

  public ToolPartSGEP(IPartProperties prop) {

    super(SGExtraParts.MOD_ID + ":" + prop.getName().toLowerCase(), prop.getCraftingStack());
    this.craftingOreDictName = prop.getCraftingOreName();
    this.tier = prop.getTier();
    this.properties = prop;
  }

  @Override
  public int getColor(ItemStack toolOrArmor) {

    return properties.getColor();
  }

  @Override
  public String getDisplayName(ItemStack stack) {

    if (stack.hasDisplayName())
      return stack.getDisplayName();

    return properties.getName();
  }

  @Override
  public String getDisplayNamePrefix(ItemStack partRep) {

    return properties.getNamePrefix();
  }

  @Override
  public ModelResourceLocation getModel(ItemStack tool, EnumPartPosition pos, int frame) {

    Item item = tool.getItem();
    String name = ((IRegistryObject) item).getName();
    name = SilentGems.MOD_ID + ":" + name.toLowerCase() + "/" + name;
    String num = item instanceof ItemGemBow ? "" : "15";

    switch (pos) {
      case HEAD_MIDDLE:
        name += num;
        break;
      case HEAD_LEFT:
        name += num + "L";
        break;
      case HEAD_RIGHT:
        name += num + "R";
        break;
      case ROD_DECO:
        name += "Deco" + num;
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

    return properties.getDurability();
  }

  @Override
  public float getHarvestSpeed() {

    return properties.getMiningSpeed();
  }

  @Override
  public int getHarvestLevel() {

    return properties.getHarvestLevel();
  }

  @Override
  public float getMeleeDamage() {

    return properties.getMeleeDamage();
  }

  @Override
  public float getMagicDamage() {

    return properties.getMagicDamage();
  }

  @Override
  public int getEnchantability() {

    return properties.getEnchantability();
  }

  @Override
  public float getMeleeSpeed() {

    return properties.getMeleeSpeed();
  }

  @Override
  public float getChargeSpeed() {

    return properties.getChargeSpeed();
  }

  @Override
  public float getProtection() {

    return properties.getProtection();
  }

  @Override
  public EnumMaterialTier getTier() {

    return tier;
  }
}
