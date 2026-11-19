package com.carlosescandon.crownmod.mixin;

import com.carlosescandon.crownmod.CrownMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractVillager.class)
public abstract class VillagerMixin {
	@Inject(method = "setTradingPlayer", at = @At("HEAD"))
	private void crownmod$captureTrader(Player player, CallbackInfo ci) {
		if (player == null) {
			CrownMod.discountActive = false;
			return;
		}

		CrownMod.discountActive = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == CrownMod.CROWN;
	}
}
