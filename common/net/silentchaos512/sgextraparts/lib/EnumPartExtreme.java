package net.silentchaos512.sgextraparts.lib;

import lombok.Getter;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.item.ModItems;

public enum EnumPartExtreme implements IPartProperties {

  //@formatter:off
  REINFORCED_OBSIDIAN ("ReinforcedObsidian", EnumMaterialTier.SUPER, 0x2C013B, 3, 20480,  6.0f, 3.0f, 3.0f, 0.8f, 17, 14, 1.5f),
  CRYSTALLIZED_CHAOS  ("CrystallizedChaos",  EnumMaterialTier.SUPER, 0xE9B6FA, 6,  1024, 25.0f, 7.0f, 7.0f, 1.2f, 22, 30, 3.0f);

  final String name;
  @Getter final int color;
  @Getter final EnumMaterialTier tier;
  @Getter final int durability;
  @Getter final float miningSpeed;
  @Getter final float meleeDamage;
  @Getter final float magicDamage;
  @Getter final float meleeSpeed;
  @Getter final int enchantability;
  @Getter final float chargeSpeed;
  @Getter final float protection;
  @Getter final int harvestLevel;
  //@formatter:on

  private EnumPartExtreme(String name, EnumMaterialTier tier, int color, int harvestLevel,
      int durability, float miningSpeed, float meleeDamage, float magicDamage, float meleeSpeed,
      int protection, int enchantability, float chargeSpeed) {

    this.name = name;
    this.color = color;
    this.tier = tier;
    this.durability = durability;
    this.miningSpeed = miningSpeed;
    this.meleeDamage = meleeDamage;
    this.magicDamage = magicDamage;
    this.meleeSpeed = meleeSpeed;
    this.enchantability = enchantability;
    this.chargeSpeed = chargeSpeed;
    this.protection = protection;
    this.harvestLevel = harvestLevel;
  }

  @Override
  public String getName() {

    return SGExtraParts.localizationHelper.getLocalizedString("part", name + ".name");
  }

  @Override
  public String getNamePrefix() {

    return SGExtraParts.localizationHelper.getLocalizedString("part", name + ".prefix");
  }

  @Override
  public ItemStack getCraftingStack() {

    switch (this) {
      case CRYSTALLIZED_CHAOS:
        return net.silentchaos512.gems.item.ModItems.craftingMaterial.chaosEssenceCrystallized;
      case REINFORCED_OBSIDIAN:
        return ModItems.generic.reinforcedObsidian;
    }

    SGExtraParts.logHelper.severe("EnumPartExtreme.getCraftingStack: unknown enum value " + this);
    return null;
  }

  @Override
  public String getCraftingOreName() {

    return "";
  }

  public static void registerToolParts() {

    for (EnumPartExtreme part : values())
      ToolPartRegistry.putPart(new ToolPartSGEP(part));
  }
}
