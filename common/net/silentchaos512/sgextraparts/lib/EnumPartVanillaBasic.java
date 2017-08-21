package net.silentchaos512.sgextraparts.lib;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.lib.util.StackHelper;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.init.ModItems;

public enum EnumPartVanillaBasic implements IPartProperties {

  //@formatter:off
  WOOD  ("wood",   EnumMaterialTier.MUNDANE, 0x866526, 0,  69, 2.0f, 0.0f, 0.0f, 1.1f, 10, 15, 1.5f),
  OAK(WOOD, "oak", 0xBC9862),
  BIRCH(WOOD, "birch", 0xD7CB8D),
  SPRUCE(WOOD, "spruce", 0x866526),
  JUNGLE(WOOD, "jungle", 0xB88764),
  DARK_OAK(WOOD, "dark_oak", 0x462D15),
  ACACIA(WOOD, "acacia", 0xBA683B),
  STONE ("stone", EnumMaterialTier.MUNDANE, 0x9A9A9A, 1, 144, 4.0f, 1.0f, 0.0f, 0.9f, 7, 5, 1.0f);

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

  private EnumPartVanillaBasic(EnumPartVanillaBasic mirror, String name, int color) {

    this.name = name;
    this.color = color;
    this.tier = mirror.tier;
    this.durability = mirror.durability;
    this.miningSpeed = mirror.miningSpeed;
    this.meleeDamage = mirror.meleeDamage;
    this.magicDamage = mirror.magicDamage;
    this.meleeSpeed = mirror.meleeSpeed;
    this.enchantability = mirror.enchantability;
    this.chargeSpeed = mirror.chargeSpeed;
    this.protection = mirror.protection;
    this.harvestLevel = mirror.harvestLevel;
  }

  private EnumPartVanillaBasic(String name, EnumMaterialTier tier, int color, int harvestLevel,
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

    return SGExtraParts.localizationHelper.getLocalizedString("part", "polished.prefix");
  }

  @Override
  public ItemStack getCraftingStack() {

    switch (this) { //@formatter:off
      case STONE: return ModItems.generic.polishedStone;
      case WOOD: return ModItems.generic.polishedWood;
      case ACACIA: return ModItems.generic.polishedAcacia;
      case BIRCH: return ModItems.generic.polishedBirch;
      case DARK_OAK: return ModItems.generic.polishedDarkOak;
      case JUNGLE: return ModItems.generic.polishedJungle;
      case OAK: return ModItems.generic.polishedOak;
      case SPRUCE: return ModItems.generic.polishedSpruce;
    } //@formatter:on
    return StackHelper.empty();
  }

  @Override
  public String getCraftingOreName() {

    return "";
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartVanillaBasic part : values())
      names.add(part.name.toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule("vanilla_basic",
        names.toArray(new String[names.size()]), values());

    for (EnumPartVanillaBasic part : values())
      if (enabled[part.ordinal()])
        ToolPartRegistry.putPart(new ToolPartSGEP(part));
  }
}
