package com.github.zideveloper.shrinkingbutton;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.github.zideveloper.shrinkingbutton.events.Events;
import com.github.zideveloper.shrinkingbutton.network.NetworkHandler;


@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "shrinkingbutton";
    public static final String NAME = "Shrinking Button Addon";
    public static final String VERSION = "1.2-1.12.2";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    public static final String[] CREDITS = {"Camellias_", "zabi94", "MineMaarten"};
    
    public static final String CLIENT_PROXY_CLASS = "com.github.zideveloper.shrinkingbutton.ProxyClient";
    public static final String COMMON_PROXY_CLASS = "com.github.zideveloper.shrinkingbutton.ProxyCommon";
    
    @Instance 
    public static Main instance;
    
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static ProxyCommon proxy;
    
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
    	NetworkHandler.init();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new Events());
    }
    
    @EventHandler 
    public static void postInit(FMLPostInitializationEvent event) {}
}
