package com.naturalnpcs.item;

import com.naturalnpcs.entity.NaturalNpcEntity;
import com.naturalnpcs.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class NpcStickItem extends Item {
    public NpcStickItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide) {
            BlockPos spawnPos = context.getClickedPos().relative(context.getClickedFace());
            spawnNpc(level, spawnPos.getX() + 0.5D, spawnPos.getY(), spawnPos.getZ() + 0.5D);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public net.minecraft.world.InteractionResultHolder<net.minecraft.world.item.ItemStack> use(
            Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            Vec3 look = player.getLookAngle();
            double x = player.getX() + look.x * 2.0D;
            double y = player.getY();
            double z = player.getZ() + look.z * 2.0D;
            spawnNpc(level, x, y, z);
        }
        return net.minecraft.world.InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide);
    }

    private void spawnNpc(Level level, double x, double y, double z) {
        NaturalNpcEntity npc = ModEntities.NATURAL_NPC.get().create(level);
        if (npc == null) return;
        npc.chooseRandomSkin();
        npc.moveTo(x, y, z, level.random.nextFloat() * 360.0F, 0.0F);
        level.addFreshEntity(npc);
    }
}
