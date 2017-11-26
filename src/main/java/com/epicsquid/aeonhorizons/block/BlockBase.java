package com.epicsquid.aeonhorizons.block;

import com.epicsquid.aeonhorizons.AeonHorizons;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class BlockBase extends Block
    {
    protected String name;

    public BlockBase(Material material, String name)
        {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(AeonHorizons.MODID + ":" + name);
        }

    public void registerModels(Item item)
        {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(getRegistryName().toString(), "inventory"));
        }
    }
