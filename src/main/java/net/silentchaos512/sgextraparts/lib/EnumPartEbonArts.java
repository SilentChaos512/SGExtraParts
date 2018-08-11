package net.silentchaos512.sgextraparts.lib;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;

public enum EnumPartEbonArts implements IPartProperties {

  // @formatter:off
  ARCANITE("Arcanite", EnumMaterialTier.REGULAR, 0x4DC6C3,  315, 6.5f, 2.5f, 2.5f, 1.0f, 16, 15, 2.0f),
  KATCHEEN("Katcheen", EnumMaterialTier.SUPER,   0xDC4242, 1600, 8.5f, 4.0f, 4.0f, 1.0f, 22, 20, 2.0f);

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
  @Getter final float protection;
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
  public String getNamePrefix() {

    return "";
  }

  @Override
  public ItemStack getCraftingStack() {

    return new ItemStack(Item.getByNameOrId("ea:gem/" + name().toLowerCase()));
  }

  @Override
  public String getCraftingOreName() {

    return "";
  }

  @Override
  public int getHarvestLevel() {

    //@formatter:off
    switch (tier) {
      case MUNDANE: return 1;
      case REGULAR: return 2;
      case SUPER: return 3;
      default: return 0;
    }
    //@formatter:on
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartEbonArts part : values())
      names.add(part.name.toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule("ebon_arts",
        names.toArray(new String[names.size()]), values());

    for (EnumPartEbonArts prop : values())
      if (enabled[prop.ordinal()])
        ToolPartRegistry.putPart(new ToolPartSGEP(prop));
  }
}
