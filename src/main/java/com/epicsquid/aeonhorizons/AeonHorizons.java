package com.epicsquid.aeonhorizons;

import com.epicsquid.aeonhorizons.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = AeonHorizons.MODID, name = AeonHorizons.MODNAME, version = AeonHorizons.VERSION, useMetadata = true)
public class AeonHorizons
    {
    public static final String MODID = "aeonhorizons";
    public static final String MODNAME = "Aeon Horizons";
    public static final String VERSION = "0.0.2";

    @SidedProxy(clientSide = "com.epicsquid.aeonhorizons.proxy.ClientProxy", serverSide = "com.epicsquid.aeonhorizons.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static AeonHorizons instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
        {
        logger = event.getModLog();
        proxy.preInit(event);
        }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
        {
        proxy.init(event);
        }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
        {
        proxy.postInit(event);
        }
    }
