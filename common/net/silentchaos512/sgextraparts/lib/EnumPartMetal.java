package net.silentchaos512.sgextraparts.lib;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.item.ModItems;

public enum EnumPartMetal implements IPartProperties {

  //@formatter:off
  COPPER      ("Copper",        EnumMaterialTier.MUNDANE, 0xFF8000,  175,  4.0f, 0.5f, 1.5f, 1.2f, 10, 12, 2.0f),
  TIN         ("Tin",           EnumMaterialTier.MUNDANE, 0xFFFFCC,  240,  5.0f, 1.0f, 1.0f, 1.0f, 12, 10, 1.0f),
  SILVER      ("Silver",        EnumMaterialTier.REGULAR, 0xD4D4D4,  200,  6.0f, 1.5f, 3.0f, 1.1f, 14, 16, 3.0f),
  LEAD        ("Lead",          EnumMaterialTier.REGULAR, 0xB494D4,  150,  5.0f, 1.0f, 0.5f, 0.8f, 12,  8, 1.0f),
  NICKEL      ("Nickel",        EnumMaterialTier.MUNDANE, 0xFFCC99,  300,  6.5f, 2.5f, 1.5f, 1.1f, 12, 13, 2.0f),
  PLATINUM    ("Platinum",      EnumMaterialTier.SUPER,   0xB3B3FF,  900, 12.0f, 4.0f, 4.0f, 1.0f, 18, 14, 2.0f),
  ALUMINIUM   ("Aluminium",     EnumMaterialTier.REGULAR, 0xFFFFFF,  300,  7.0f, 3.0f, 2.0f, 1.3f, 15, 10, 1.0f),
  ALUMINUM    ("Aluminum",      EnumMaterialTier.REGULAR, 0xFFFFFF,  300,  7.0f, 3.0f, 2.0f, 1.3f, 15, 10, 1.0f),
  ZINC        ("Zinc",          EnumMaterialTier.MUNDANE, 0xDDCCFF,  200,  3.0f, 1.5f, 2.5f, 1.1f, 12, 11, 2.0f),
  TITANIUM    ("Titanium",      EnumMaterialTier.SUPER,   0x2E4CE6, 1600,  8.0f, 6.0f, 2.0f, 1.0f, 24, 12, 1.0f),
  BRONZE      ("Bronze",        EnumMaterialTier.REGULAR, 0xFF5400,  500,  6.0f, 2.0f, 1.0f, 1.1f, 17, 14, 1.0f),
  BRASS       ("Brass",         EnumMaterialTier.REGULAR, 0xFFAA33,  200,  5.0f, 1.0f, 2.0f, 1.1f, 12, 14, 2.0f),
  STEEL       ("Steel",         EnumMaterialTier.REGULAR, 0x606060, 1000,  8.0f, 4.0f, 2.0f, 0.8f, 20,  9, 1.0f),
  INVAR       ("Invar",         EnumMaterialTier.REGULAR, 0xD5FFCC,  450,  7.0f, 3.0f, 3.0f, 1.0f, 18, 10, 2.0f),
  ELECTRUM    ("Electrum",      EnumMaterialTier.REGULAR, 0xFFFF80,  100, 14.0f, 1.0f, 4.0f, 1.2f, 15, 20, 3.0f),
  ENDERIUM    ("Enderium",      EnumMaterialTier.SUPER,   0x468C75, 1100, 18.0f, 6.0f, 4.0f, 1.0f, 22, 13, 2.0f),
  PRISMARINIUM("Prismarinium",  EnumMaterialTier.SUPER,   0xA6FFD2, 1400, 20.0f, 4.0f, 6.0f, 1.1f, 26, 17, 3.0f);

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

  private EnumPartMetal(String name, EnumMaterialTier tier, int color, int durability,
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

    return new ItemStack(ModItems.ingot, 1, ordinal());
  }

  @Override
  public String getCraftingOreName() {

    return "ingot" + name;
  }

  @Override
  public int getHarvestLevel() {

    //@formatter:off
    switch (tier) {
      case MUNDANE: return 1;
      case REGULAR: return 2;
      case SUPER: return 4;
      default: return 0;
    }
    //@formatter:on
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartMetal part : values())
      names.add(part.name.toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule("metals",
        names.toArray(new String[names.size()]), values());

    for (EnumPartMetal metal : values()) {
      if (enabled[metal.ordinal()])
        ToolPartRegistry.putPart(new ToolPartSGEP(metal));
    }
  }
}
