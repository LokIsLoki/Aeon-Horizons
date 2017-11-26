package com.epicsquid.aeonhorizons.item;

import com.epicsquid.aeonhorizons.AeonHorizons;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBase extends Item
    {

    protected String name;

    public ItemBase(String name)
        {
        this.name = name;

        setRegistryName(name);
        setUnlocalizedName(AeonHorizons.MODID + "." + name);
        }

    public void registerModels(Item item)
        {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        }

    }
