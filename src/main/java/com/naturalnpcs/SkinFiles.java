package com.naturalnpcs;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public final class SkinFiles {
    private SkinFiles() {}

    public static Path getSkinDirectory() {
        return FMLPaths.GAMEDIR.get().resolve("config").resolve("naturalnpcs").resolve("skins");
    }

    public static List<Path> listSkins() {
        Path directory = getSkinDirectory();
        try {
            Files.createDirectories(directory);
            try (Stream<Path> files = Files.list(directory)) {
                return files.filter(Files::isRegularFile)
                        .filter(path -> path.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".png"))
                        .sorted(Comparator.comparing(path -> path.getFileName().toString().toLowerCase(Locale.ROOT)))
                        .toList();
            }
        } catch (IOException exception) {
            NaturalNPCs.LOGGER.error("Could not read Natural NPCs skin folder: {}", directory, exception);
            return List.of();
        }
    }
}
