package io.github.Qianyvkisa.don_touch_berry;

import io.github.Qianyvkisa.don_touch_berry.blocks.star_light_berry_bush;
import io.github.Qianyvkisa.don_touch_berry.blocks.the_god_berry_bush;
import io.github.Qianyvkisa.don_touch_berry.items.the_god_berry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
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


	public static final Block the_god_berry_bush = new the_god_berry_bush(FabricBlockSettings.of(Material.BARRIER).breakInstantly().strength(0.0f,0.0f).noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
	public static final BlockItem the_god_berry_bush_block = new BlockItem(the_god_berry_bush,new FabricItemSettings());

	public static final Block star_light_berry_bush = new star_light_berry_bush(FabricBlockSettings.of(Material.BARRIER).breakInstantly().strength(0.0f,0.0f).noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
	public static final BlockItem star_light_berry_bush_block = new BlockItem(star_light_berry_bush, new FabricItemSettings());


	private static final ItemGroup The_Berry = FabricItemGroup.builder(new Identifier(ModID, "the_berry"))
			.icon(() -> new ItemStack(the_god_berry))
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		Registry.register(Registries.BLOCK, new Identifier(ModID, "the_god_berry_bush"), the_god_berry_bush);
		Registry.register(Registries.BLOCK,new Identifier(ModID,"star_light_berry_bush"), star_light_berry_bush);

		Registry.register(Registries.ITEM, new Identifier(ModID, "the_god_berry_bush_block"), the_god_berry_bush_block);
		Registry.register(Registries.ITEM, new Identifier(ModID,"star_light_berry_bush_block"),star_light_berry_bush_block);

		ItemGroupEvents.modifyEntriesEvent(The_Berry).register(content -> {
			content.add(the_god_berry_bush_block);
		});
		ItemGroupEvents.modifyEntriesEvent(The_Berry).register(content -> {
			content.add(star_light_berry_bush);
		});


		BlockRenderLayerMap.INSTANCE.putBlock(the_god_berry_bush, RenderLayer.getCutout());
	}
}
