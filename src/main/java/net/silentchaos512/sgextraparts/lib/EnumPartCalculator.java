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


public enum EnumPartCalculator implements IPartProperties {

  //@formatter:off
  //                                                                                   DUR   EFF    MEL    MAG  MSPD  PRT ENC  CHG
  REINFORCED_STONE  ("calc_reinforced_stone", EnumMaterialTier.MUNDANE, 0x404040, 1,   250,  5.0f,  1.5f,  0.5f, 1.0f, 10,  5, 1.0f),
  ENRICHED_GOLD     ("calc_enriched_gold",    EnumMaterialTier.REGULAR, 0xBCBC9A, 3,  1000,  8.0f,  0.0f,  7.0f, 1.3f, 14, 20, 3.0f),
  REINFORCED_IRON   ("calc_reinforced_iron",  EnumMaterialTier.REGULAR, 0x7F7F7F, 2,   400,  7.0f,  2.0f,  1.0f, 1.1f, 17, 10, 1.0f),
  REDSTONE          ("calc_redstone",         EnumMaterialTier.REGULAR, 0xBB3048, 2,   800,  7.5f,  2.5f,  1.5f, 1.4f, 12, 18, 1.0f),
  WEAKENED_DIAMOND  ("calc_weakened_diamond", EnumMaterialTier.SUPER,   0x367268, 3,  1400,  8.0f,  3.0f,  3.0f, 1.2f, 19, 10, 2.0f),
  FLAWLESS_DIAMOND  ("calc_flawless_diamond", EnumMaterialTier.SUPER,   0xA9CCC6, 3,  1800, 14.0f,  5.0f,  5.0f, 1.2f, 23, 30, 2.0f),
  FIRE_DIAMOND      ("calc_fire_diamond",     EnumMaterialTier.SUPER,   0xBB3048, 3,  2600, 16.0f,  7.0f,  5.0f, 1.1f, 21, 30, 2.0f),
  ELECTRIC_DIAMOND  ("calc_electric_diamond", EnumMaterialTier.SUPER,   0xD2D2BB, 4, 10000, 18.0f, 10.0f, 12.0f, 1.1f, 23, 30, 2.0f),
  END_FORGED        ("calc_end_diamond",      EnumMaterialTier.SUPER,   0x115348, 6, 32766, 50.0f, 16.0f, 16.0f, 1.5f, 26, 30, 3.0f),
  ;

  public static final String MOD_ID = "calculator";

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

  private EnumPartCalculator(String name, EnumMaterialTier tier, int color,
      int harvestLevel, int durability, float miningSpeed, float meleeDamage, float magicDamage,
      float meleeSpeed, int protection, int enchantability, float chargeSpeed) {

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

    String itemName = MOD_ID + ":";

    switch (this) {
      case ELECTRIC_DIAMOND:
        itemName += "ElectricDiamond";
        break;
      case END_FORGED:
        itemName += "EndDiamond";
        break;
      case ENRICHED_GOLD:
        itemName += "EnrichedGoldIngot";
        break;
      case FIRE_DIAMOND:
        itemName += "FireDiamond";
        break;
      case FLAWLESS_DIAMOND:
        itemName += "FlawlessDiamond";
        break;
      case REDSTONE:
        itemName += "RedstoneIngot";
        break;
      case REINFORCED_IRON:
        itemName += "ReinforcedIronIngot";
        break;
      case REINFORCED_STONE:
        itemName = "sonarcore:ReinforcedStoneBlock";
        break;
      case WEAKENED_DIAMOND:
        itemName += "WeakenedDiamond";
        break;
    }

    return new ItemStack(Item.getByNameOrId(itemName));
  }

  @Override
  public String getCraftingOreName() {

    switch (this) {
      case ENRICHED_GOLD: return "ingotEnrichedGold";
      case REINFORCED_STONE: return "reinforcedStone";
      case WEAKENED_DIAMOND: return "gemDiamondFake";
      default: return "";
    }
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartCalculator part : values())
      names.add(part.name.toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule(MOD_ID,
        names.toArray(new String[names.size()]), values());

    for (EnumPartCalculator part : values())
      if (enabled[part.ordinal()])
        ToolPartRegistry.putPart(new ToolPartSGEP(part));
  }
}
