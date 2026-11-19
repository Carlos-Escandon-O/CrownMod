package com.carlosescandon.crownmod.mixin;

import com.carlosescandon.crownmod.CrownMod;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MerchantOffer.class)
public abstract class MerchantOfferMixin {
	@Inject(method = "getModifiedCostCount", at = @At("HEAD"), cancellable = true)
	private void crownmod$crownDiscount(ItemCost cost, CallbackInfoReturnable<Integer> cir) {
		if (!CrownMod.discountActive) {
			return;
		}

		int base = cost.count();
		if (base <= 1) {
			// Un elementico = gratis
			cir.setReturnValue(0);
		} else {
			// Mitad de precio redondeada hacia arriba
			cir.setReturnValue((int) Math.ceil(base / 2.0));
		}
	}
}
