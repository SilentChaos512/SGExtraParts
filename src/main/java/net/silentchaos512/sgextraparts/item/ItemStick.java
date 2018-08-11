package net.silentchaos512.sgextraparts.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.silentchaos512.lib.item.ItemSL;
import net.silentchaos512.lib.registry.RecipeMaker;
import net.silentchaos512.sgextraparts.SGExtraParts;

import java.util.Map;

public class ItemStick extends ItemSL {
    public enum Type {
        OAK(0xBC9862, new ItemStack(Blocks.PLANKS, 1, 0)),
        SPRUCE(0x664F2F, new ItemStack(Blocks.PLANKS, 1, 1)),
        BIRCH(0xD7CB8D, new ItemStack(Blocks.PLANKS, 1, 2)),
        JUNGLE(0xB88764, new ItemStack(Blocks.PLANKS, 1, 3)),
        ACACIA(0xBA6337, new ItemStack(Blocks.PLANKS, 1, 4)),
        DARK_OAK(0x462D15, new ItemStack(Blocks.PLANKS, 1, 5));

        public final int color;
        final ItemStack plank;

        Type(int color, ItemStack plank) {

            this.color = color;
            this.plank = plank;
        }
    }

    public ItemStick() {
        super(Type.values().length, SGExtraParts.MOD_ID, "stick");
    }

    @Override
    public void addRecipes(RecipeMaker recipes) {
        for (Type type : Type.values()) {
            recipes.addShaped("stick_" + type.name().toLowerCase(),
                    new ItemStack(this, 4, type.ordinal()), "p", "p", 'p', type.plank);
        }
        recipes.addShapeless("mod_stick_to_vanilla", new ItemStack(Items.STICK),
                new ItemStack(this, 1, OreDictionary.WILDCARD_VALUE));
    }

    @Override
    public void addOreDict() {
        for (Type type : Type.values()) {
            OreDictionary.registerOre("stickWood", new ItemStack(this, 1, type.ordinal()));
        }
    }

    @Override
    public void getModels(Map<Integer, ModelResourceLocation> models) {
        ModelResourceLocation modelLocation = new ModelResourceLocation(
                SGExtraParts.RESOURCE_PREFIX + "stick", "inventory");
        for (Type type : Type.values()) {
            models.put(type.ordinal(), modelLocation);
        }
    }

    @Override
    public String getNameForStack(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta >= 0 && meta < Type.values().length)
            return "stick_" + Type.values()[meta].name().toLowerCase();
        return super.getNameForStack(stack);
    }
}
