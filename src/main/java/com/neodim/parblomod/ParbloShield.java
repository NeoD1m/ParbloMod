//package com.neodim.parblomod;
//
//import net.minecraft.item.Item;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TextFormatting;
//import net.minecraft.util.text.TranslationTextComponent;
//import net.minecraftforge.common.Tags;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
//import net.minecraftforge.registries.IForgeRegistry;
//
////@Mod(ParbloShield.MODID)
////@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
//public class ParbloShield {
//
//	//public static final String MODID = "parblomod";
//
//	public static ParbloShieldItem netheriteShield;
//
////	public ParbloShield() {
////		new Config();
////		netheriteShield = new ParbloShieldItem("parblo_shield", () -> Config.netheriteDamageReduction.get(),
////				Tags.Items.INGOTS_NETHERITE, Config.netheriteDurability.get(), true);
////	}
////
////	@SubscribeEvent
////	public static void registerItems(RegistryEvent.Register<Item> e) {
////		final IForgeRegistry<Item> registry = e.getRegistry();
////		registry.registerAll(netheriteShield);
////	}
//
////	@SubscribeEvent
////	public static void registerRecipes(RegistryEvent.Register<IRecipeSerializer<?>> e) {
////		final IForgeRegistry<IRecipeSerializer<?>> registry = e.getRegistry();
////		registry.register(ShieldRecipes.SERIALIZER.setRegistryName(new ResourceLocation(MODID, "shield_decoration")));
////	}
//
//	/**
//	 * Creates a {@link TranslationTextComponent} for the when blocking tooltip.
//	 *
//	 * @return the new text component.
//	 */
//	public static ITextComponent getBlockingTextComponent() {
//		return new TranslationTextComponent("kek").mergeStyle(TextFormatting.GRAY);
//	}
//
//	/**
//	 * Creates a {@link TranslationTextComponent} for the damage reduction tooltip.
//	 *
//	 * @param reduction the damage reduction of the shield for which the text
//	 *                  component will be used.
//	 * @return the new text component.
//	 */
//	public static ITextComponent getDamageReductionTextComponent(int reduction) {
//		return new TranslationTextComponent("tooltip.parblomod.parblo_first", reduction)
//				.mergeStyle(TextFormatting.DARK_GREEN);
//	}
//
//}
