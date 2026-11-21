package com.naturalnpcs.registry;

import com.naturalnpcs.NaturalNPCs;
import com.naturalnpcs.entity.NaturalNpcEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = NaturalNPCs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NaturalNPCs.MOD_ID);

    public static final RegistryObject<EntityType<NaturalNpcEntity>> NATURAL_NPC =
            ENTITY_TYPES.register("natural_npc", () -> EntityType.Builder
                    .of(NaturalNpcEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F)
                    .clientTrackingRange(8)
                    .build("natural_npc"));

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(NATURAL_NPC.get(), NaturalNpcEntity.createAttributes().build());
    }
}
