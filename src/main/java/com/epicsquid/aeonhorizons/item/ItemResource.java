package com.epicsquid.aeonhorizons.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;

public class ItemResource extends ItemBase
    {

    public ItemResource()
        {
        super("resource");
        }

    @Override
    public void registerModels(Item item)
        {
        for (int i = 0; i < EnumItemType.values().length; i++)
            {
            ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation("aeonhorizons:resource_" + EnumItemType.byMetadata(i).getName()));
            }
        }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
        {
        for (int i = 0; i < EnumItemType.values().length; i++)
            {
            items.add(new ItemStack(this, 1, i));
            }
        }

    @Override
    public String getUnlocalizedName(ItemStack stack)
        {
        int meta = stack.getItemDamage();
        return getUnlocalizedName() + "." + EnumItemType.byMetadata(meta).getName();
        }

    public enum EnumItemType
        {
            STARDUST(0, "stardust");

        private static final EnumItemType[] METADATA_LOOKUP = new EnumItemType[values().length];
        private String name;
        private int meta;

        EnumItemType(int meta, String name)
            {
            this.name = name;
            this.meta = meta;
            }

        public static EnumItemType byMetadata(int metadata)
            {
            if (metadata < 0 || metadata >= METADATA_LOOKUP.length)
                {
                metadata = 0;
                }
            return METADATA_LOOKUP[metadata];
            }

        public String getName()
            {
            return name;
            }

        public int getMeta()
            {
            return meta;
            }

        static
            {
            for (EnumItemType type : values())
                {
                METADATA_LOOKUP[type.getMeta()] = type;
                }
            }
        }

    }
