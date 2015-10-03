package com.andrewlray.mcmods.dessertcraft.handler;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyHandler {
	
	private static final String[] keyDesc = {};
	
	/* Format: {Keyboard.KEY_~, ... } */
	private static final int[] keyValues = {};
	
	private final KeyBinding[] keys;
	
	public KeyHandler() {
		keys = new KeyBinding[keyValues.length];
		
		for (int value = 0; value < keyValues.length; value++) {
			keys[value] = new KeyBinding(keyDesc[value], keyValues[value], "key.andrew.dessertcraft");
			ClientRegistry.registerKeyBinding(keys[value]);
		}
	}
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			int key = Keyboard.getEventKey();
			boolean isPressed = Keyboard.getEventKeyState();
			
		}
	}
	
}
