package net.silentchaos512.sgextraparts.lib;

import com.google.common.collect.Lists;
import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.silentchaos512.gems.api.lib.EnumMaterialTier;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.lib.util.StackHelper;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.init.ModItems;

import java.util.List;

public enum EnumPartMisc implements IPartProperties {

  //@formatter:off
  SOULFORGED_STEEL("betterwithmods", "SoulforgedSteel", "ingot", EnumMaterialTier.SUPER,   0x646464, 3, 1564, 12.0f, 4.0f, 4.0f, 1.0f, 20, 16, 2.0f),
  FELDSPAR        ("sgextraparts",   "feldspar",        "",      EnumMaterialTier.MUNDANE, 0xB06F4B, 1,  108,  5.0f, 2.0f, 0.0f, 1.0f, 10, 10, 1.0f);

  final String modId;
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

  private EnumPartMisc(String modId, String name, String orePrefix, EnumMaterialTier tier,
      int color, int harvestLevel, int durability, float miningSpeed, float meleeDamage,
      float magicDamage, float meleeSpeed, int protection, int enchantability, float chargeSpeed) {

    this.modId = modId;
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

    switch (this) {
      case SOULFORGED_STEEL:
        return new ItemStack(Item.getByNameOrId("betterwithmods:material"), 1, 14);
      case FELDSPAR:
        return ModItems.generic.feldspar;
      default:
        return StackHelper.empty();
    }
  }

  @Override
  public String getCraftingOreName() {

    if (orePrefix.isEmpty())
      return "";
    return orePrefix + name;
  }

  public static void registerToolParts() {

    List<String> names = Lists.newArrayList();
    for (EnumPartMisc part : values()) {
      names.add(part.modId + "." + part.name.toLowerCase());
    }

    boolean[] enabled = ConfigExtraParts.loadPartModule("misc",
        names.toArray(new String[names.size()]), values());

    for (EnumPartMisc part : values()) {
      if (enabled[part.ordinal()] && Loader.isModLoaded(part.modId)) {
        ToolPartRegistry.putPart(new ToolPartSGEP(part));
      }
    }
  }
}
