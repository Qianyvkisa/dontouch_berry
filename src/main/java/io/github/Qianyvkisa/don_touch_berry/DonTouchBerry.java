package io.github.Qianyvkisa.don_touch_berry;

import io.github.Qianyvkisa.don_touch_berry.items.the_god_berry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
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


	public static final Block the_god_berry_bush = new PlantBlock(FabricBlockSettings.of(Material.BARRIER).breakInstantly().strength(0.0f,0.0f).noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH));
	public static final BlockItem the_god_berry_bush_block = new BlockItem(the_god_berry_bush,new FabricItemSettings());


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		Registry.register(Registries.BLOCK, new Identifier(ModID,"the_god_berry_bush"),the_god_berry_bush);
		Registry.register(Registries.ITEM, new Identifier(ModID,"the_god_berry_bush_block"),the_god_berry_bush_block);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(the_god_berry_bush_block -> {
			the_god_berry_bush_block.addAfter(Items.CUT_COPPER_SLAB,the_god_berry_bush);
		});



	}
}
