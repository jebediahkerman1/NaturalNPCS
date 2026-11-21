# Natural NPCs

A Minecraft Forge mod that adds player-like civilian NPCs who wander around the world.

## Current prototype

- **NPC Stick:** a normal Minecraft stick texture named "NPC Stick".
- Right-click a block to spawn an NPC on the clicked face.
- Right-click the air to spawn an NPC a short distance in front of you.
- NPCs wander, look around, and have no visible nametags.

## Development target

- Minecraft 1.20.1
- Minecraft Forge 47.x
- Java 17

## Planned features

- Random player skins selected from a dedicated collection of 10–30 PNG files.
- Persistent skin assignments for each NPC.
- Natural world spawning with configurable population density.
- More natural pedestrian behaviours.

## Skin folder (planned)

The intended skin folder is:

`src/main/resources/assets/naturalnpcs/textures/entity/skins/`

Use standard 64×64 Minecraft player skin PNG files named `skin_01.png`, `skin_02.png`, and so on. Automatic skin discovery and per-NPC skin selection are not implemented yet.

## Build

Import this repository as a Gradle project in an IDE with Java 17, or run the Gradle `build` task. The mod JAR will be generated in `build/libs/`.
