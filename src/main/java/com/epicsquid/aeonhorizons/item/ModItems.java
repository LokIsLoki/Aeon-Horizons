package com.epicsquid.aeonhorizons.item;

import com.epicsquid.aeonhorizons.AeonHorizons;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(AeonHorizons.MODID)
public class ModItems
    {

    // List of all Items
    public static final ItemBase resource = new ItemResource();

    public static void register(IForgeRegistry<Item> registry)
        {
        registry.registerAll(resource);
        }

    public static void registerModels()
        {
        resource.registerModels(resource);
        }

    }
