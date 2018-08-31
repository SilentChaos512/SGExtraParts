package net.silentchaos512.sgextraparts.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.oredict.OreDictionary;
import net.silentchaos512.lib.item.IColoredItem;
import net.silentchaos512.lib.registry.IAddRecipes;
import net.silentchaos512.lib.registry.ICustomModel;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;

import java.util.List;
import java.util.Locale;

public class ItemIngot extends Item implements IAddRecipes, ICustomModel, IColoredItem {
    public ItemIngot() {
        setHasSubtypes(true);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) return;
        for (int i = 0; i < EnumPartMetal.values().length; ++i)
            items.add(new ItemStack(this, 1, i));
    }

    @Override
    public void registerModels() {
        ModelResourceLocation model = new ModelResourceLocation(SGExtraParts.RESOURCE_PREFIX + "ingot", "inventory");
        for (int i = 0; i < EnumPartMetal.values().length; ++i)
            ModelLoader.setCustomModelResourceLocation(this, i, model);
    }

    @Override
    public void addOreDict() {
        for (EnumPartMetal metal : EnumPartMetal.values())
            OreDictionary.registerOre(metal.getCraftingOreName(), metal.getCraftingStack());
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.ITALIC + SGExtraParts.i18n.subText(this, "desc1"));
        list.add(TextFormatting.ITALIC + SGExtraParts.i18n.subText(this, "desc2"));
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return "item." + SGExtraParts.MOD_ID + "." + getNameForStack(stack);
    }

    private String getNameForStack(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta >= 0 && meta < EnumPartMetal.values().length)
            return "ingot_" + EnumPartMetal.values()[meta].name().toLowerCase(Locale.ROOT);
        else
            return "ingot_unknown";
    }

    @Override
    public IItemColor getColorHandler() {
        return (stack, tintIndex) -> {
            int meta = stack.getItemDamage();
            if (meta < 0 || meta >= EnumPartMetal.values().length || tintIndex != 0)
                return 0xFFFFFF;
            return EnumPartMetal.values()[meta].getColor();
        };
    }
}
