# Natural NPCs

A Minecraft Forge mod that adds player-like civilian NPCs who wander around the world.

## Planned features

- Random player skins selected from `assets/naturalnpcs/textures/entity/skins/`.
- Supports a collection of 10–30 PNG skins.
- No visible nametags.
- Random wandering, occasional pauses, and natural-looking head turns.
- Natural world spawning with configurable spawn density.
- Skin assignments remain consistent for each NPC.

## Development target

- Minecraft 1.20.1
- Minecraft Forge 47.x
- Java 17

## Adding skins

Place standard 64×64 Minecraft player skin PNG files in:

`src/main/resources/assets/naturalnpcs/textures/entity/skins/`

Use filenames such as `skin_01.png`, `skin_02.png`, and so on. Keep between 10 and 30 skins in the folder. The mod is being developed to discover the available skins automatically.

## Status

Early development. Features and setup instructions will be updated as the first playable build is implemented.
