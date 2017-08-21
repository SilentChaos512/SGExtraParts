package net.silentchaos512.sgextraparts.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.silentchaos512.lib.registry.SRegistry;
import net.silentchaos512.sgextraparts.SGExtraParts;
import net.silentchaos512.sgextraparts.init.ModItems;
import net.silentchaos512.sgextraparts.lib.EnumPartMetal;

public class ClientProxy extends CommonProxy {

  @Override
  public void preInit(SRegistry reg) {

    OBJLoader.INSTANCE.addDomain(SGExtraParts.MOD_ID);

    super.preInit(reg);
    reg.clientPreInit();
  }

  @Override
  public void init(SRegistry reg) {

    Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {

      @Override
      public int getColorFromItemstack(ItemStack stack, int tintIndex) {

        int meta = stack.getItemDamage();
        if (meta < 0 || meta >= EnumPartMetal.values().length || tintIndex != 0)
          return 0xFFFFFF;
        return EnumPartMetal.values()[meta].getColor();
      }
    }, ModItems.ingot);

    super.init(reg);
    reg.clientInit();
  }

  @Override
  public void postInit(SRegistry reg) {

    super.postInit(reg);
    reg.clientPostInit();
  }
}
