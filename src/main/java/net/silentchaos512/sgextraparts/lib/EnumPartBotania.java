package net.silentchaos512.sgextraparts.lib;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;

public enum EnumPartBotania implements IPartProperties {

  //@formatter:off
  MANASTEEL("Manasteel", EnumMaterialTier.REGULAR, 0x49C0EB, 3, 300, 6.2f, 2.0f, 5.0f, 1.0f, 16, 20, 2.0f),
  ELEMENTIUM("Elementium", EnumMaterialTier.REGULAR, 0xFE8BFF, 3, 720, 6.2f, 2.0f, 5.0f, 1.1f, 16, 20, 4.0f),
  TERRASTEEL("Terrasteel", EnumMaterialTier.SUPER, 0xA6E74A, 4, 2300, 9.0f, 3.0f, 7.0f, 1.0f, 20, 26, 2.0f);

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

  private EnumPartBotania(String name, EnumMaterialTier tier, int color, int harvestLevel,
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

    return "";
  }

  @Override
  public ItemStack getCraftingStack() {

    Item item = Item.getByNameOrId("botania:manaResource");
    return new ItemStack(item, 1, this == MANASTEEL ? 0 : this == ELEMENTIUM ? 7 : 4);
  }

  @Override
  public String getCraftingOreName() {

    switch (this) { //@formatter:off
      case MANASTEEL: return "ingotManasteel";
      case ELEMENTIUM: return "ingotElvenElementium";
      case TERRASTEEL: return "ingotTerrasteel";
      default: return "";
    } //@formatter:on
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartBotania part : values())
      names.add(part.name.toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule("botania",
        names.toArray(new String[names.size()]), values());

    for (EnumPartBotania part : values())
      if (enabled[part.ordinal()])
        ToolPartRegistry.putPart(new ToolPartSGEP(part));
  }
}
