package com.github.zideveloper.shrinkingbutton.network.packets;

import com.camellias.resizer.Main;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;

public class PacketShrink extends PacketBase<PacketShrink> {

	@Override
	public void fromBytes(ByteBuf buf) {}

	@Override
	public void toBytes(ByteBuf buf) {}

	@Override
	public void handleClientSide(PacketShrink message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(PacketShrink message, EntityPlayer player) {
		PotionEffect effect = player.getActivePotionEffect(Main.SHRINKING);

		if(effect == null) {
			player.addPotionEffect(new PotionEffect(Main.SHRINKING, 9999, 0, true, false));
		}else if(effect.getAmplifier() == 0) {
			player.addPotionEffect(new PotionEffect(Main.SHRINKING, 9999, 1, true, false));
		}else {
			player.removePotionEffect(Main.SHRINKING);
		}
	}
}
