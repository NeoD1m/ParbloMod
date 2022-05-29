package com.neodim.parblomod.client;

import com.neodim.parblomod.ParbloMod;
//import com.neodim.parblomod.ParbloShield;

import net.minecraft.item.ShieldItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT, modid = ParbloMod.MOD_ID)
public class TooltipHandler {

	@SubscribeEvent
	public static void onTooltip(ItemTooltipEvent e) {
		if (e.getItemStack().getItem() instanceof ShieldItem) {
//			if (!Config.enableDamageReduction.get()) {
//				return;
//			}
//
//			Item shield = e.getItemStack().getItem();
//			List<ITextComponent> tooltip = e.getToolTip();
//			tooltip.add(new StringTextComponent(""));
//			tooltip.add(BetterShields.getBlockingTextComponent());
//
//			if (shield == Items.SHIELD) {
//				tooltip.add(BetterShields.getDamageReductionTextComponent(Config.defaultDamageReduction.get()));
//			} else if (shield instanceof BetterShieldItem) {
//				tooltip.add(BetterShields
//						.getDamageReductionTextComponent(((BetterShieldItem) shield).getDamageReduction()));
//			} else {
//				tooltip.add(BetterShields.getDamageReductionTextComponent(
//						Config.customShieldMaxReduction.get() ? 100 : Config.defaultDamageReduction.get()));
//			}
		}
	}

}