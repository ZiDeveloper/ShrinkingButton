package com.example.examplemod.client.events;

import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.Collection;

import org.lwjgl.input.Mouse;

import com.artemis.artemislib.compatibilities.sizeCap.SizeDefaultCap;
import com.artemis.artemislib.util.attributes.ArtemisLibAttributes;
import com.camellias.resizer.Main;
import com.camellias.resizer.common.potions.PotionShrinking;
import com.sun.jna.platform.win32.WinUser.INPUT;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.GuiScreenEvent.MouseInputEvent;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.ListenerList;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events{
	
	private int left;
	private int height;
	
	private GuiContainer gui;
	private GuiButtonExt guiButton;
	
	
	@SubscribeEvent
	protected void guiPostInit(GuiScreenEvent.InitGuiEvent.Post event)
	{
		if (event.getGui() instanceof GuiInventory)
		{			
			this.gui = (GuiContainer)event.getGui();
			
			this.left = this.gui.getGuiLeft();
			this.height = this.gui.height;
			
			this.guiButton = new GuiButtonExt(13, this.left + 134, this.height/2 - 22 , 20, 18, "S");
			
			event.getButtonList().add(this.guiButton);
		}
	}
	
	@SubscribeEvent
	protected void actionPerformed(GuiScreenEvent.ActionPerformedEvent.Post event){	
		
		this.left = this.gui.getGuiLeft();
		this.guiButton.x = (this.left + 134);
		
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		PotionEffect potionEffect = player.getActivePotionEffect(Main.SHRINKING);
		
		if(event.getButton().id == 13) {
			
			if(player.isPotionActive(Main.SHRINKING)) {
				if(potionEffect.getAmplifier() == 0) {
					// add potion effect at lvl 2
					player.addPotionEffect(new PotionEffect(Main.SHRINKING, 9999999, 1, true, false));
				}else {
					// clear potion effect
					player.removeActivePotionEffect(Main.SHRINKING);
				}
									
			}else {
				player.addPotionEffect(new PotionEffect(Main.SHRINKING, 9999999, 0, true, false));
			}
		}
	}
}


















