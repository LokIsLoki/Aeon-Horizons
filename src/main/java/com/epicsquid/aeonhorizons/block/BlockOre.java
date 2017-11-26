package com.epicsquid.aeonhorizons.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;

public class BlockOre extends BlockBase
    {

    public static final PropertyEnum<OreType> VARIANT = PropertyEnum.create("type", OreType.class);

    public BlockOre()
        {
        super(Material.ROCK, "ore");

        setHardness(3.0f);
        setResistance(5.0f);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, OreType.VORTEX));

        setHarvestLevel("pickaxe", 2);
        }

    @Override
    public void registerModels(Item item)
        {
        for (int i = 0; i < OreType.values().length; i++)
            {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation("aeonhorizons:" + name, "type=" + OreType.byMetadata(i).getName()));
            }
        }

    @Override
    protected BlockStateContainer createBlockState()
        {
        return new BlockStateContainer(this, VARIANT);
        }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items)
        {
        for (int i = 0; i < OreType.METADATA_LOOKUP.length; i++)
            {
            items.add(new ItemStack(this, 1, i));
            }
        }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
        {
        return this.getDefaultState().withProperty(VARIANT, OreType.byMetadata(meta));
        }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
        {
        return state.getValue(VARIANT).getMetadata();
        }

    @Override
    public int damageDropped(IBlockState state)
        {
        return state.getValue(VARIANT).getMetadata();
        }

    public enum OreType implements IStringSerializable
        {

            VORTEX(0, "vortex"),
            NEBULA(1, "nebula"),
            SOLAR(2, "solar"),
            STARDUST(3, "stardust");


        private static final OreType[] METADATA_LOOKUP = new OreType[values().length];
        private final int metadata;
        private final String name;

        OreType(int metadata, String name)
            {
            this.metadata = metadata;
            this.name = name;
            }

        @Override
        public String getName()
            {
            return this.name;
            }

        public int getMetadata()
            {
            return this.metadata;
            }

        public static OreType byMetadata(int metadata)
            {
            if (metadata < 0 || metadata >= METADATA_LOOKUP.length)
                {
                metadata = 0;
                }
            return METADATA_LOOKUP[metadata];
            }

        static
            {
            for (OreType type : values())
                {
                METADATA_LOOKUP[type.getMetadata()] = type;
                }
            }

        }

    }
