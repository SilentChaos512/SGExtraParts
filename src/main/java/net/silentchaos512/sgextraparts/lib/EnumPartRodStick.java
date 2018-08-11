package net.silentchaos512.sgextraparts.lib;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.silentchaos512.gems.api.tool.part.ToolPartRegistry;
import net.silentchaos512.lib.util.StackHelper;
import net.silentchaos512.sgextraparts.config.ConfigExtraParts;
import net.silentchaos512.sgextraparts.init.ModItems;
import net.silentchaos512.sgextraparts.item.ItemStick;

public enum EnumPartRodStick {

  //@formatter:off
  //       DUR   HARV  MEL   MAG   ENCH  COLOR
  OAK     (1.0f, 1.0f, 1.0f, 1.0f, 0.8f, ItemStick.Type.OAK.color),
  SPRUCE  (1.1f, 1.0f, 1.0f, 1.0f, 0.9f, ItemStick.Type.SPRUCE.color),
  BIRCH   (0.9f, 1.0f, 1.0f, 1.0f, 1.1f, ItemStick.Type.BIRCH.color),
  JUNGLE  (0.9f, 1.1f, 1.0f, 1.0f, 0.9f, ItemStick.Type.JUNGLE.color),
  ACACIA  (1.0f, 1.1f, 1.0f, 1.0f, 0.8f, ItemStick.Type.ACACIA.color),
  DARK_OAK(1.1f, 1.0f, 1.0f, 1.0f, 1.0f, ItemStick.Type.DARK_OAK.color);
  //@formatter:on

  float durabilityMulti;
  float harvestSpeedMulti;
  float meleeDamageMulti;
  float magicDamageMulti;
  float enchantabilityMulti;
  int color;

  private EnumPartRodStick(float durabilityMulti, float harvestSpeedMutli, float meleeDamageMulti,
      float magicDamageMulti, float enchantabilityMulti, int color) {

    this.durabilityMulti = durabilityMulti;
    this.harvestSpeedMulti = harvestSpeedMutli;
    this.meleeDamageMulti = meleeDamageMulti;
    this.magicDamageMulti = magicDamageMulti;
    this.enchantabilityMulti = enchantabilityMulti;
    this.color = color;
  }

  public ItemStack getCraftingStack() {

    return StackHelper.empty();
    //return new ItemStack(ModItems.stick, 1, ordinal());
  }

  public static void registerToolParts() {

    List<String> names = new ArrayList<>();
    for (EnumPartRodStick part : values())
      names.add(part.name().toLowerCase());

    boolean[] enabled = ConfigExtraParts.loadPartModule("rods",
        names.toArray(new String[names.size()]), values());

    for (EnumPartRodStick part : values()) {
      if (enabled[part.ordinal()]) {
        String name = "rod_" + part.name().toLowerCase();
        ToolPartRegistry.putPart(new ToolPartRodSGEP(name,
            part.getCraftingStack(), part.durabilityMulti, part.harvestSpeedMulti,
            part.meleeDamageMulti, part.magicDamageMulti, part.enchantabilityMulti, part.color));
      }
    }
  }
}
