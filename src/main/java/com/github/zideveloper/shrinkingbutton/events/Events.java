package com.github.zideveloper.shrinkingbutton.events;

import com.github.zideveloper.shrinkingbutton.network.NetworkHandler;
import com.github.zideveloper.shrinkingbutton.network.packets.PacketShrink;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events{
	
	private int left;
	private int height;
	private int yPosDifference;
	
	private GuiContainer gui;
	private GuiButtonExt guiButton;
	
	
	@SubscribeEvent
	protected void guiPostInit(GuiScreenEvent.InitGuiEvent.Post event)
	{
		if (event.getGui() instanceof GuiContainerCreative || event.getGui() instanceof GuiInventory)
		{			
			this.gui = (GuiContainer)event.getGui();
			this.left = this.gui.getGuiLeft();
			this.height = this.gui.height;
			
			if(this.gui instanceof GuiContainerCreative) {
				this.yPosDifference = 44;
			}else {
				this.yPosDifference = 22;
			}
			
			this.guiButton = new GuiButtonExt(13, this.left + 134, this.height/2 - this.yPosDifference , 20, 18, "S");
			event.getButtonList().add(this.guiButton);
		}
	}
	
	@SubscribeEvent
	protected void actionPerformed(GuiScreenEvent.ActionPerformedEvent.Post event){	
		
		this.left = this.gui.getGuiLeft();
		this.guiButton.x = (this.left + 134);
		
		if(event.getButton().id == 13 && (event.getGui() instanceof GuiContainerCreative || event.getGui() instanceof GuiInventory)) {
			NetworkHandler.sendMessageToServer(new PacketShrink());
		}
	}
	
}


















