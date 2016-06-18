package net.silentchaos512.sgextraparts.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.silentchaos512.gems.api.tool.part.IPartProperties;
import net.silentchaos512.sgextraparts.SGExtraParts;

public class ConfigExtraParts {

  static final String split = Configuration.CATEGORY_SPLITTER;
  public static final String CAT_MAIN = "main";
  public static final String CAT_MODULES = CAT_MAIN + split + "modules";

  private static Configuration c;

  public static void init(File file) {

    c = new Configuration(file);
    load();
  }

  public static void load() {

    try {
    } catch (Exception ex) {
    }
  }

  public static void save() {

    if (c.hasChanged()) {
      c.save();
    }
  }

  public static boolean[] loadPartModule(String moduleName, String[] keys,
      IPartProperties[] values) {

    if (keys.length != values.length)
      throw new IllegalArgumentException("keys and values arrays are different lengths!");

    String cat = CAT_MODULES + split + moduleName;
    String catPart = cat + split + "parts";
    boolean[] ret = new boolean[values.length];

    boolean allDisabled = c.getBoolean("DisableAll", cat, false,
        "Disable all parts in this module by setting to 'true'.");

    for (int i = 0; i < ret.length; ++i) {
      if (allDisabled) {
        ret[i] = false;
      } else {
        ret[i] = c.get(catPart, keys[i], true).getBoolean();
      }
    }

    c.setCategoryComment(catPart,
        "Enable/disable individual parts in this module. Set to 'false' to disable.");

    return ret;
  }
}
