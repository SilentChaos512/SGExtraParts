package net.silentchaos512.sgextraparts.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.silentchaos512.gems.item.CraftingItems;
import net.silentchaos512.lib.registry.IAddRecipes;
import net.silentchaos512.lib.registry.ICustomModel;
import net.silentchaos512.lib.registry.RecipeMaker;
import net.silentchaos512.sgextraparts.SGExtraParts;

public class ItemGeneric extends Item implements IAddRecipes, ICustomModel {
    public static final String NAME_REINFORCED_OBSIDIAN = "reinforcedobsidian";
    public static final String NAME_POLISHED_WOOD = "polished_wood";
    public static final String NAME_POLISHED_OAK = "polished_oak";
    public static final String NAME_POLISHED_BIRCH = "polished_birch";
    public static final String NAME_POLISHED_SPRUCE = "polished_spruce";
    public static final String NAME_POLISHED_JUNGLE = "polished_jungle";
    public static final String NAME_POLISHED_DARK_OAK = "polished_dark_oak";
    public static final String NAME_POLISHED_ACACIA = "polished_acacia";
    public static final String NAME_POLISHED_STONE = "polished_stone";
    public static final String NAME_FELDSPAR = "feldspar";

    public static final String[] NAMES = {
            NAME_REINFORCED_OBSIDIAN, NAME_POLISHED_WOOD, NAME_POLISHED_OAK, NAME_POLISHED_SPRUCE,
            NAME_POLISHED_BIRCH, NAME_POLISHED_JUNGLE, NAME_POLISHED_ACACIA, NAME_POLISHED_DARK_OAK,
            NAME_POLISHED_STONE, NAME_FELDSPAR};

    public static final String[] SORTED_NAMES = {
            NAME_FELDSPAR, NAME_POLISHED_WOOD, NAME_POLISHED_OAK, NAME_POLISHED_SPRUCE,
            NAME_POLISHED_BIRCH, NAME_POLISHED_JUNGLE, NAME_POLISHED_ACACIA, NAME_POLISHED_DARK_OAK,
            NAME_POLISHED_STONE, NAME_REINFORCED_OBSIDIAN};

    public final ItemStack reinforcedObsidian = getStack(NAME_REINFORCED_OBSIDIAN);
    public final ItemStack polishedWood = getStack(NAME_POLISHED_WOOD);
    public final ItemStack polishedOak = getStack(NAME_POLISHED_OAK);
    public final ItemStack polishedBirch = getStack(NAME_POLISHED_BIRCH);
    public final ItemStack polishedSpruce = getStack(NAME_POLISHED_SPRUCE);
    public final ItemStack polishedJungle = getStack(NAME_POLISHED_JUNGLE);
    public final ItemStack polishedDarkOak = getStack(NAME_POLISHED_DARK_OAK);
    public final ItemStack polishedAcacia = getStack(NAME_POLISHED_ACACIA);
    public final ItemStack polishedStone = getStack(NAME_POLISHED_STONE);
    public final ItemStack feldspar = getStack(NAME_FELDSPAR);

    public ItemGeneric() {
        setHasSubtypes(true);
    }

    public ItemStack getStack(String name) {
        return getStack(name, 1);
    }

    public ItemStack getStack(String name, int amount) {
        for (int i = 0; i < NAMES.length; ++i) {
            if (NAMES[i].equalsIgnoreCase(name)) {
                return new ItemStack(this, amount, i);
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!this.isInCreativeTab(tab)) return;
        for (String name : SORTED_NAMES) {
            items.add(getStack(name));
        }
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta < NAMES.length)
            return SGExtraParts.i18n.getKey("item", NAMES[meta]);
        return super.getTranslationKey(stack);
    }

    @Override
    public void addRecipes(RecipeMaker recipes) {
        recipes.addShapedOre("reinforced_obsidian", reinforcedObsidian, "oco", "coc", "oco", 'o',
                "obsidian", 'c',
                CraftingItems.ENRICHED_CHAOS_ESSENCE.getStack());
    }

    @Override
    public void registerModels() {
        for (int i = 0; i < NAMES.length; ++i) {
            SGExtraParts.registry.setModel(this, i, NAMES[i]);
        }
    }
}
