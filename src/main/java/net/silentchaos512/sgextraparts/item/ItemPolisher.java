package net.silentchaos512.sgextraparts.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.silentchaos512.lib.registry.IAddRecipes;
import net.silentchaos512.sgextraparts.SGExtraParts;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPolisher extends Item implements IAddRecipes {
    public ItemPolisher() {
        setContainerItem(this);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.ITALIC + SGExtraParts.i18n.subText(this, "desc"));
    }
}
