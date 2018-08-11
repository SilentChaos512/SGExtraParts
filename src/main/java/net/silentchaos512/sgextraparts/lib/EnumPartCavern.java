package net.silentchaos512.sgextraparts.lib;

import com.google.common.collect.Lists;
import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;

import java.util.List;

public enum EnumPartCavern implements IPartProperties {

  //@formatter:off
  //                                                       DUR     EFF    MEL    MAG  MSPD PRT ENC   CHG
  MAGNITE("Magnite", EnumMaterialTier.SUPER, 0xDF3930, 3,   10, 100.0f, 11.0f,  5.0f, 0.7f, 10, 50, 3.0f),
  HEXCITE("Hexcite", EnumMaterialTier.SUPER, 0xFFFFFF, 3, 1041,  10.0f,  5.0f, 11.0f, 1.4f, 24, 15, 1.0f),
  ;

  public static final String MOD_ID = "cavern";

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

  private EnumPartCavern(String name, EnumMaterialTier tier, int color, int harvestLevel,
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

    return SGExtraParts.i18n.translate("part", name + ".name");
  }

  @Override
  public String getNamePrefix() {

    return "";
  }

  @Override
  public ItemStack getCraftingStack() {

    Item item = Item.getByNameOrId("cavern:cave_item");
    return new ItemStack(item, 1, this == MAGNITE ? 1 : this == HEXCITE ? 2 : 4);
  }

  @Override
  public String getCraftingOreName() {

    switch (this) { //@formatter:off
      case MAGNITE: return "ingotMagnite";
      case HEXCITE: return "gemHexcite";
      default: return "";
    } //@formatter:on
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartCavern part : values())
      names.add(part.name.toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule(MOD_ID,
        names.toArray(new String[names.size()]), values());

    for (EnumPartCavern part : values())
      if (enabled[part.ordinal()])
        ToolPartRegistry.putPart(new ToolPartSGEP(part));
  }
}
