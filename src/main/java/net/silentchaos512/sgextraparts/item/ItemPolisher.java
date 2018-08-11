package net.silentchaos512.sgextraparts.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.silentchaos512.lib.item.ItemSL;
import net.silentchaos512.lib.registry.RecipeMaker;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.init.ModItems;

public class ItemPolisher extends ItemSL {

  public ItemPolisher() {

    super(1, SGExtraParts.MOD_ID, "polisher");
  }

  @Override
  public void addRecipes(RecipeMaker recipes) {

    ItemStack polisher = new ItemStack(this);
    ItemStack feldspar = ModItems.generic.feldspar;
    String stick = "stickWood";

    recipes.addShapelessOre("polisher", polisher, feldspar, feldspar, stick, stick);

    setContainerItem(this);

    // Polished items
    recipes.addShapeless("polished_oak", ModItems.generic.polishedOak, polisher, new ItemStack(Blocks.PLANKS, 1, 0));
    recipes.addShapeless("polished_spruce", ModItems.generic.polishedSpruce, polisher, new ItemStack(Blocks.PLANKS, 1, 1));
    recipes.addShapeless("polished_birch", ModItems.generic.polishedBirch, polisher, new ItemStack(Blocks.PLANKS, 1, 2));
    recipes.addShapeless("polished_jungle", ModItems.generic.polishedJungle, polisher, new ItemStack(Blocks.PLANKS, 1, 3));
    recipes.addShapeless("polished_acacia", ModItems.generic.polishedAcacia, polisher, new ItemStack(Blocks.PLANKS, 1, 4));
    recipes.addShapeless("polished_dark_oak", ModItems.generic.polishedDarkOak, polisher, new ItemStack(Blocks.PLANKS, 1, 5));
    recipes.addShapelessOre("polished_wood", ModItems.generic.polishedWood, polisher, "plankWood");
    recipes.addShapelessOre("polished_stone", ModItems.generic.polishedStone, polisher, "cobblestone");
  }
}
