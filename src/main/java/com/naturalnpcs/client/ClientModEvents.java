package com.naturalnpcs.client;

import com.mojang.blaze3d.platform.NativeImage;
import com.naturalnpcs.NaturalNPCs;
import com.naturalnpcs.SkinFiles;
import com.naturalnpcs.entity.NaturalNpcEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = NaturalNPCs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    private static final List<ResourceLocation> SKIN_TEXTURES = new ArrayList<>();
    private static final ResourceLocation DEFAULT_SKIN =
            new ResourceLocation("minecraft", "textures/entity/steve.png");

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            SKIN_TEXTURES.clear();
            List<String> skins = SkinFiles.listSkins();

            for (int i = 0; i < skins.size(); i++) {
                String fileName = skins.get(i);
                try (InputStream input = SkinFiles.openSkin(fileName)) {
                    if (input == null) continue;
                    NativeImage image = NativeImage.read(input);
                    ResourceLocation id = new ResourceLocation(NaturalNPCs.MOD_ID, "preset_skins/skin_" + i);
                    Minecraft.getInstance().getTextureManager().register(id, new DynamicTexture(image));
                    SKIN_TEXTURES.add(id);
                } catch (Exception exception) {
                    NaturalNPCs.LOGGER.error("Could not load built-in NPC skin: {}", fileName, exception);
                }
            }
            NaturalNPCs.LOGGER.info("Loaded {} built-in Natural NPC preset skin(s).", SKIN_TEXTURES.size());
        });
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(com.naturalnpcs.registry.ModEntities.NATURAL_NPC.get(),
                NaturalNpcRenderer::new);
    }

    private static class NaturalNpcRenderer extends MobRenderer<NaturalNpcEntity, PlayerModel<NaturalNpcEntity>> {
        NaturalNpcRenderer(EntityRendererProvider.Context context) {
            super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
        }

        @Override
        public ResourceLocation getTextureLocation(NaturalNpcEntity entity) {
            int index = entity.getSkinIndex();
            return index >= 0 && index < SKIN_TEXTURES.size() ? SKIN_TEXTURES.get(index) : DEFAULT_SKIN;
        }
    }
}
