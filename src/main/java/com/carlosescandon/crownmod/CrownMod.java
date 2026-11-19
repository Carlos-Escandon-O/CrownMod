package com.carlosescandon.crownmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrownMod implements ModInitializer {
	public static final String MOD_ID = "crownmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item CROWN = new Item(new Item.Properties().stacksTo(1));

	public static final CreativeModeTab CROWN_TAB = Registry.register(
		BuiltInRegistries.CREATIVE_MODE_TAB,
		Identifier.fromNamespaceAndPath(MOD_ID, "crown_tab"),
		FabricCreativeModeTab.builder()
			.title(Component.translatable("itemGroup.crownmod.crown"))
			.icon(() -> new ItemStack(CROWN))
			.displayItems((parameters, output) -> output.accept(CROWN))
			.build()
	);

	@Override
	public void onInitialize() {
		Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "crown"), CROWN);

		// Cada ~1 segundo, los aldeanos cercanos siguen al jugador que lleva puesta la corona.
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			if (server.getTickCount() % 20 != 0) {
				return;
			}
			for (ServerLevel level : server.getAllLevels()) {
				for (ServerPlayer player : level.players()) {
					ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
					if (head.isEmpty() || head.getItem() != CROWN) {
						continue;
					}
					AABB box = player.getBoundingBox().inflate(12.0);
					for (Villager villager : level.getEntitiesOfClass(Villager.class, box)) {
						double dist = villager.distanceTo(player);
						if (dist > 2.5) {
							villager.getNavigation().moveTo(player, 0.6);
						} else {
							villager.getNavigation().stop();
						}
					}
				}
			}
		});

		LOGGER.info("CrownMod encendido: que los aldeanos hagan cola.");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
