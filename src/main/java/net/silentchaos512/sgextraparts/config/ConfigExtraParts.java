package net.silentchaos512.sgextraparts.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.silentchaos512.gems.api.tool.part.IPartProperties;

public class ConfigExtraParts {

  public static float ROCK_FELDSPAR_PER_CHUNK = 0.6f;

  static final String split = Configuration.CATEGORY_SPLITTER;
  public static final String CAT_MAIN = "main";
  public static final String CAT_MODULES = CAT_MAIN + split + "modules";
  public static final String CAT_WORLD = CAT_MAIN + split + "world";

  private static Configuration c;

  public static void init(File file) {

    c = new Configuration(file);
    load();
  }

  public static void load() {

    try {
      ROCK_FELDSPAR_PER_CHUNK = c.getFloat("Feldspar Per Chunk", CAT_WORLD,
          ROCK_FELDSPAR_PER_CHUNK, 0f, 10f,
          "The number of feldspar rocks per chunk on average.");
    } catch (Exception ex) {
    }
  }

  public static void save() {

    if (c.hasChanged()) {
      c.save();
    }
  }

  public static boolean[] loadPartModule(String moduleName, String[] keys,
      Object[] values) {

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
