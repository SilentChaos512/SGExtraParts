package net.silentchaos512.sgextraparts.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.silentchaos512.lib.item.ItemNamedSubtypesSorted;
import net.silentchaos512.sgextraparts.SGExtraParts;

public class ItemGeneric extends ItemNamedSubtypesSorted {

  public static final String NAME_REINFORCED_OBSIDIAN = "ReinforcedObsidian";

  public static final String[] NAMES = {//
      NAME_REINFORCED_OBSIDIAN };

  public static final String[] SORTED_NAMES = {//
      NAME_REINFORCED_OBSIDIAN };

  public final ItemStack reinforcedObsidian = getStack(NAME_REINFORCED_OBSIDIAN);

  public ItemGeneric() {

    super(NAMES, SORTED_NAMES, SGExtraParts.MOD_ID, "GenericItem");
  }

  @Override
  public void addRecipes() {

    GameRegistry
        .addRecipe(new ShapedOreRecipe(reinforcedObsidian, "oco", "coc", "oco", 'o', "obsidian",
            'c', net.silentchaos512.gems.item.ModItems.craftingMaterial.chaosEssenceEnriched));
  }
}
