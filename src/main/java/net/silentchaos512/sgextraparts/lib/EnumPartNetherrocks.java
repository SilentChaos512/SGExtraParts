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

public enum EnumPartNetherrocks implements IPartProperties {

  //@formatter:off
  //                                                                           DUR   EFF   MEL   MAG  MSPD  PRT ENC  CHG
  FYRITE      ("Fyrite",      "ingot", EnumMaterialTier.REGULAR, 0xFF8716, 3,  150,  8.0f, 4.0f, 2.0f, 1.0f, 15,  7, 2.0f),
  MALACHITE   ("Malachite",   "ingot", EnumMaterialTier.REGULAR, 0x00E699, 3,  700,  9.0f, 3.0f, 4.0f, 1.1f, 12, 39, 3.0f),
  ASHSTONE    ("Ashstone",    "gem",   EnumMaterialTier.REGULAR, 0x505352, 3,  900, 16.0f, 2.0f, 2.0f, 0.9f,  8,  7, 1.0f),
  ILLUMENITE  ("Illumenite",  "ingot", EnumMaterialTier.REGULAR, 0xF5FA9E, 3,  700,  8.0f, 4.0f, 4.0f, 1.5f, 17,  7, 3.0f),
  DRAGONSTONE ("Dragonstone", "gem",   EnumMaterialTier.SUPER,   0x8C0900, 4, 4000, 10.0f, 8.0f, 6.0f, 1.2f, 22, 18, 1.0f),
  ARGONITE    ("Argonite",    "ingot", EnumMaterialTier.SUPER,   0x3F0087, 3, 1300,  8.0f, 3.0f, 9.0f, 0.8f, 13, 18, 2.0f);

  public static final String MOD_ID = "netherrocks";

  final String name;
  final String orePrefix;
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

  private EnumPartNetherrocks(String name, String orePrefix, EnumMaterialTier tier, int color,
      int harvestLevel, int durability, float miningSpeed, float meleeDamage, float magicDamage,
      float meleeSpeed, int protection, int enchantability, float chargeSpeed) {

    this.name = name;
    this.orePrefix = orePrefix;
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

    String itemName = String.format("%s:%s_%s", MOD_ID, name.toLowerCase(), orePrefix);
    return new ItemStack(Item.getByNameOrId(itemName));
  }

  @Override
  public String getCraftingOreName() {

    return orePrefix + name;
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartNetherrocks part : values())
      names.add(part.name.toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule(MOD_ID,
        names.toArray(new String[names.size()]), values());

    for (EnumPartNetherrocks part : values())
      if (enabled[part.ordinal()])
        ToolPartRegistry.putPart(new ToolPartSGEP(part));
  }
}
