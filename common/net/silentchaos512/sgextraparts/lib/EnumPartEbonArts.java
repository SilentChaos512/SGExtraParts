package net.silentchaos512.sgextraparts.lib;

import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;

public enum EnumPartEbonArts implements IPartProperties {

  // @formatter:off
  ARCANITE("Arcanite", EnumMaterialTier.REGULAR, 0x4DC6C3,  315, 6.5f, 2.5f, 2.5f, 1.0f,  6, 15, 2.0f),
  KATCHEEN("Katcheen", EnumMaterialTier.SUPER,   0xDC4242, 1600, 8.5f, 4.0f, 4.0f, 1.0f, 10, 20, 2.0f);

  @Getter final String name;
  @Getter final int color;
  @Getter final EnumMaterialTier tier;
  @Getter final int durability;
  @Getter final float miningSpeed;
  @Getter final float meleeDamage;
  @Getter final float magicDamage;
  @Getter final float meleeSpeed;
  @Getter final int enchantability;
  @Getter final float chargeSpeed;
  @Getter final int protection;
  //@formatter:on

  private EnumPartEbonArts(String name, EnumMaterialTier tier, int color, int durability,
      float miningSpeed, float meleeDamage, float magicDamage, float meleeSpeed, int protection,
      int enchantability, float chargeSpeed) {

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
  }

  @Override
  public ItemStack getCraftingStack() {

    return new ItemStack(Item.getByNameOrId("ea:gem/" + name().toLowerCase()));
  }

  @Override
  public String getCraftingOreName() {

    return "";
  }

  public static void registerToolParts() {

    for (EnumPartEbonArts prop : values())
      ToolPartRegistry.putPart(new ToolPartSGEP(prop));
  }
}
