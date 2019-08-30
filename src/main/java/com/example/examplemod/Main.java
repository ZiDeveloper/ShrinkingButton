package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.example.examplemod.client.events.Events;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)

public class Main
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    
    public static final String CLIENT_PROXY_CLASS = "com.example.examplemod.ProxyClient";
    public static final String COMMON_PROXY_CLASS = "com.example.examplemod.ProxyCommon";

    @Instance 
    public static Main instance;
    
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static ProxyCommon proxy;
    
    
    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new Events());
    }
    
    @EventHandler 
    public static void postInit(FMLPostInitializationEvent event) 
    {
    }
}
