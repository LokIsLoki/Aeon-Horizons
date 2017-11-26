package com.epicsquid.aeonhorizons.block;

import com.epicsquid.aeonhorizons.item.ItemResource;
import com.epicsquid.aeonhorizons.item.ModItems;
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

import java.util.Random;

public class BlockOre extends BlockBase
    {

    public static final PropertyEnum<EnumOreType> VARIANT = PropertyEnum.create("type", EnumOreType.class);

    public BlockOre()
        {
        super(Material.ROCK, "ore");

        setHardness(3.0f);
        setResistance(5.0f);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumOreType.VORTEX));

        setHarvestLevel("pickaxe", 2);
        }

    @Override
    public void registerModels(Item item)
        {
        for (int i = 0; i < EnumOreType.values().length; i++)
            {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation("aeonhorizons:" + name, "type=" + EnumOreType.byMetadata(i).getName()));
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
        for (int i = 0; i < EnumOreType.METADATA_LOOKUP.length; i++)
            {
            items.add(new ItemStack(this, 1, i));
            }
        }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
        {
        int meta = getMetaFromState(state);

        if (meta == EnumOreType.STARDUST.getMetadata())
            {
            return ModItems.resource;
            }

        return super.getItemDropped(state, rand, fortune);
        }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
        {
        int meta = getMetaFromState(state);

        if (meta == EnumOreType.STARDUST.getMetadata())
            {
            return random.nextInt(2) + 2 + (2 * fortune);
            }
        return super.quantityDropped(state, fortune, random);
        }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
        {
        return this.getDefaultState().withProperty(VARIANT, EnumOreType.byMetadata(meta));
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
        // Account for item drops from ores
        if (state.getValue(VARIANT).equals(EnumOreType.STARDUST))
            {
            return ItemResource.EnumItemType.STARDUST.getMeta();
            }
        return state.getValue(VARIANT).getMetadata();
        }

    public enum EnumOreType implements IStringSerializable
        {

            VORTEX(0, "vortex"),
            NEBULA(1, "nebula"),
            SOLAR(2, "solar"),
            STARDUST(3, "stardust");


        private static final EnumOreType[] METADATA_LOOKUP = new EnumOreType[values().length];
        private final int metadata;
        private final String name;

        EnumOreType(int metadata, String name)
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

        public static EnumOreType byMetadata(int metadata)
            {
            if (metadata < 0 || metadata >= METADATA_LOOKUP.length)
                {
                metadata = 0;
                }
            return METADATA_LOOKUP[metadata];
            }

        static
            {
            for (EnumOreType type : values())
                {
                METADATA_LOOKUP[type.getMetadata()] = type;
                }
            }

        }

    }
