package com.epicsquid.aeonhorizons.block;

import com.epicsquid.aeonhorizons.AeonHorizons;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(AeonHorizons.MODID)
public class ModBlocks
    {

    public static final BlockBase ore = new BlockOre();

    public static void register(IForgeRegistry<Block> registry)
        {
        registry.registerAll(
                ore
        );
        }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
        {
        registry.registerAll(
                new ItemBlockOre(ore).setRegistryName(ore.getRegistryName())
        );
        }

    public static void registerModels()
        {
        ore.registerModels(Item.getItemFromBlock(ore));
        }
    }
