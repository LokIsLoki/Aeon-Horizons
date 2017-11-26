package com.epicsquid.aeonhorizons.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import com.epicsquid.aeonhorizons.block.BlockOre.OreType;


public class ItemBlockOre extends ItemBlock
    {

    public ItemBlockOre(Block block)
        {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
        }

    @Override
    public String getUnlocalizedName(ItemStack stack)
        {
        return "tile.aeonhorizons.ore." + OreType.byMetadata(stack.getItemDamage()).getName();
        }

    @Override
    public int getMetadata(int damage)
        {
        return damage;
        }
    }
