package com.naturalnpcs.client;

import com.naturalnpcs.NaturalNPCs;
import com.naturalnpcs.entity.NaturalNpcEntity;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NaturalNPCs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(com.naturalnpcs.registry.ModEntities.NATURAL_NPC.get(), context ->
                new NaturalNpcRenderer(context));
    }

    private static class NaturalNpcRenderer extends MobRenderer<NaturalNpcEntity, PlayerModel<NaturalNpcEntity>> {
        private static final ResourceLocation DEFAULT_SKIN =
                new ResourceLocation("minecraft", "textures/entity/steve.png");

        NaturalNpcRenderer(EntityRendererProvider.Context context) {
            super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
        }

        @Override
        public ResourceLocation getTextureLocation(NaturalNpcEntity entity) {
            return DEFAULT_SKIN;
        }
    }
}
