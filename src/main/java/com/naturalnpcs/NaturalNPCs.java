package com.naturalnpcs;

import com.mojang.logging.LogUtils;
import com.naturalnpcs.registry.ModEntities;
import com.naturalnpcs.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(NaturalNPCs.MOD_ID)
public class NaturalNPCs {
    public static final String MOD_ID = "naturalnpcs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public NaturalNPCs() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modBus);
        ModEntities.ENTITY_TYPES.register(modBus);
    }
}
