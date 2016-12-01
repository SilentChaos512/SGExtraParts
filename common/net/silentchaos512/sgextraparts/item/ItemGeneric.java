package net.silentchaos512.sgextraparts.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.silentchaos512.lib.item.ItemNamedSubtypesSorted;
import net.silentchaos512.sgextraparts.SGExtraParts;

public class ItemGeneric extends ItemNamedSubtypesSorted {

  public static final String NAME_REINFORCED_OBSIDIAN = "ReinforcedObsidian";
  public static final String NAME_POLISHED_WOOD = "polished_wood";
  public static final String NAME_POLISHED_OAK = "polished_oak";
  public static final String NAME_POLISHED_BIRCH = "polished_birch";
  public static final String NAME_POLISHED_SPRUCE = "polished_spruce";
  public static final String NAME_POLISHED_JUNGLE = "polished_jungle";
  public static final String NAME_POLISHED_DARK_OAK = "polished_dark_oak";
  public static final String NAME_POLISHED_ACACIA = "polished_acacia";
  public static final String NAME_POLISHED_STONE = "polished_stone";

  public static final String[] NAMES = {//
      NAME_REINFORCED_OBSIDIAN, NAME_POLISHED_WOOD, NAME_POLISHED_OAK, NAME_POLISHED_BIRCH,
      NAME_POLISHED_SPRUCE, NAME_POLISHED_JUNGLE, NAME_POLISHED_DARK_OAK, NAME_POLISHED_ACACIA,
      NAME_POLISHED_STONE };

  public static final String[] SORTED_NAMES = {//
      NAME_REINFORCED_OBSIDIAN, NAME_POLISHED_WOOD, NAME_POLISHED_OAK, NAME_POLISHED_BIRCH,
      NAME_POLISHED_SPRUCE, NAME_POLISHED_JUNGLE, NAME_POLISHED_DARK_OAK, NAME_POLISHED_ACACIA,
      NAME_POLISHED_STONE };

  public final ItemStack reinforcedObsidian = getStack(NAME_REINFORCED_OBSIDIAN);
  public final ItemStack polishedWood = getStack(NAME_POLISHED_WOOD);
  public final ItemStack polishedOak = getStack(NAME_POLISHED_OAK);
  public final ItemStack polishedBirch = getStack(NAME_POLISHED_BIRCH);
  public final ItemStack polishedSpruce = getStack(NAME_POLISHED_SPRUCE);
  public final ItemStack polishedJungle = getStack(NAME_POLISHED_JUNGLE);
  public final ItemStack polishedDarkOak = getStack(NAME_POLISHED_DARK_OAK);
  public final ItemStack polishedAcacia = getStack(NAME_POLISHED_ACACIA);
  public final ItemStack polishedStone = getStack(NAME_POLISHED_STONE);

  public ItemGeneric() {

    super(NAMES, SORTED_NAMES, SGExtraParts.MOD_ID, "GenericItem");
  }

  @Override
  public void addRecipes() {

    GameRegistry
        .addRecipe(new ShapedOreRecipe(reinforcedObsidian, "oco", "coc", "oco", 'o', "obsidian",
            'c', net.silentchaos512.gems.item.ModItems.craftingMaterial.chaosEssenceEnriched));

    GameRegistry.addRecipe(new ShapedOreRecipe(polishedOak, "www", 'w', "slabWoodOak"));
    GameRegistry.addRecipe(new ShapedOreRecipe(polishedBirch, "www", 'w', "slabWoodBirch"));
    GameRegistry.addRecipe(new ShapedOreRecipe(polishedSpruce, "www", 'w', "slabWoodSpruce"));
    GameRegistry.addRecipe(new ShapedOreRecipe(polishedJungle, "www", 'w', "slabWoodJungle"));
    GameRegistry.addRecipe(new ShapedOreRecipe(polishedDarkOak, "www", 'w', "slabWoodDarkOak"));
    GameRegistry.addRecipe(new ShapedOreRecipe(polishedAcacia, "www", 'w', "slabWoodAcacia"));

    GameRegistry.addRecipe(new ShapedOreRecipe(polishedWood, "www", 'w', "slabWood"));

    GameRegistry.addRecipe(new ShapedOreRecipe(polishedStone, "sss", 's', "slabCobblestone"));
  }
}
