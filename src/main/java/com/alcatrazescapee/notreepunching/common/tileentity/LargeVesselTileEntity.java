/*
 * Part of the No Tree Punching mod by AlcatrazEscapee.
 * Copyright (c) 2019. See the project LICENSE.md for details.
 */

package com.alcatrazescapee.notreepunching.common.tileentity;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import com.alcatrazescapee.core.common.tileentity.DeviceTileEntity;
import com.alcatrazescapee.notreepunching.Config;
import com.alcatrazescapee.notreepunching.common.container.LargeVesselContainer;

import static com.alcatrazescapee.notreepunching.NoTreePunching.MOD_ID;

public class LargeVesselTileEntity extends DeviceTileEntity
{
    public static final int SLOT_COLUMNS = 5;
    public static final int SLOT_ROWS = 3;
    public static final int SLOTS = SLOT_COLUMNS * SLOT_ROWS;

    private static final ITextComponent NAME = new TranslationTextComponent(MOD_ID + ".tile_entity.large_vessel");

    public LargeVesselTileEntity()
    {
        super(ModTileEntities.LARGE_VESSEL.get(), SLOTS, NAME);
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity player)
    {
        return new LargeVesselContainer(this, playerInventory, windowId);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack)
    {
        return !Config.SERVER.largeCeramicVesselBlacklist.get().test(stack);
    }
}
