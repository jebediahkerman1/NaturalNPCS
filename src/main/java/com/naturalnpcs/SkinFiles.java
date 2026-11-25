package com.naturalnpcs;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class SkinFiles {
    private static final int MAX_PRESET_SKINS = 30;

    private SkinFiles() {}

    public static List<String> listSkins() {
        List<String> skins = new ArrayList<>();
        for (int i = 1; i <= MAX_PRESET_SKINS; i++) {
            String name = "skin" + i + ".png";
            try (InputStream input = NaturalNPCs.class.getResourceAsStream("/skins/" + name)) {
                if (input != null) skins.add(name);
            } catch (Exception exception) {
                NaturalNPCs.LOGGER.error("Could not check built-in NPC skin {}", name, exception);
            }
        }
        return skins;
    }

    public static InputStream openSkin(String fileName) {
        return NaturalNPCs.class.getResourceAsStream("/skins/" + fileName);
    }
}
