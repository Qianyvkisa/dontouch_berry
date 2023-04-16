package io.github.Qianyvkisa.don_touch_berry;

import io.github.Qianyvkisa.don_touch_berry.items.the_god_berry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DonTouchBerry implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String ModID = "don_touch_berry";
	public static final Logger LOGGER = LoggerFactory.getLogger(ModID);

	public static final Item the_god_berry =
			Registry.register(Registries.ITEM, new Identifier(ModID, "the_god_berry"),
					new the_god_berry(new FabricItemSettings()));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
