package com.github.zideveloper.shrinkingbutton.network;

import com.github.zideveloper.shrinkingbutton.Main;
import com.github.zideveloper.shrinkingbutton.network.packets.PacketShrink;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void init() {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Main.MODID);
		
		INSTANCE.registerMessage(PacketShrink.class, PacketShrink.class, 0, Side.SERVER);
	}
	
	public static void sendMessageToServer(IMessage message) {
		INSTANCE.sendToServer(message);
	}
}
