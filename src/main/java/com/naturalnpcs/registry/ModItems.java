package com.naturalnpcs.registry;

import com.naturalnpcs.NaturalNPCs;
import com.naturalnpcs.item.NpcStickItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NaturalNPCs.MOD_ID);

    public static final RegistryObject<Item> NPC_STICK = ITEMS.register("npc_stick",
            () -> new NpcStickItem(new Item.Properties().stacksTo(1)));
}
