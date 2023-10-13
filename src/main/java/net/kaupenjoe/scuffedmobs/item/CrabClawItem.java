package net.kaupenjoe.scuffedmobs.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class CrabClawItem extends Item {
    public CrabClawItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(((Player) pEntity).getItemInHand(InteractionHand.OFF_HAND).is(pStack.getItem())) {
            ((Player) pEntity).getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue(4.5d + (pStack.getCount() / 2d));
        } else {
            ((Player) pEntity).getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue(4.5d);
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
