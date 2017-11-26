package com.epicsquid.aeonhorizons.handler;

import com.epicsquid.aeonhorizons.block.ModBlocks;
import com.epicsquid.aeonhorizons.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegistrationHandler
    {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
        {
        ModItems.register(event.getRegistry());
        ModBlocks.registerItemBlocks(event.getRegistry());
        }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
        {
        ModBlocks.register(event.getRegistry());
        }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event)
        {
        ModItems.registerModels();
        ModBlocks.registerModels();
        }

    }
