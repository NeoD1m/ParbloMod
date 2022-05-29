package com.neodim.parblomod;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.neodim.parblomod.client.ModItemGroup;
import com.neodim.parblomod.client.ShieldTileEntityRenderer;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tags.ITag;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ParbloShieldItem extends ShieldItem {

	private Supplier<Integer> damageReduction;
	private LazyValue<Ingredient> repairMaterial;

	public ParbloShieldItem(String registryName, Supplier<Integer> damageReduction, ITag<Item> repairMaterial,
							int durability, boolean fireProof) {

		this(new ResourceLocation(ParbloMod.MOD_ID, registryName), damageReduction,
				() -> Ingredient.fromTag(repairMaterial), durability, fireProof);
	}

	public ParbloShieldItem(ResourceLocation registryName, Supplier<Integer> damageReduction,
							Supplier<Ingredient> repairMaterial, int durability, boolean fireProof) {
		super((fireProof ? new Properties().isImmuneToFire() : new Properties()).setISTER(() -> getISTER())
				.group(ModItemGroup.PARBLO_GROUP));
		setRegistryName(registryName);
		this.damageReduction = damageReduction;
		this.repairMaterial = new LazyValue<>(repairMaterial);
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
	}

	@OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> getISTER() {
		return ShieldTileEntityRenderer::new;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		tooltip.add(new TranslationTextComponent("tooltip.parblomod.parblo_first"));
		super.addInformation(stack, world, tooltip, flag);
	}
	/**
	 * Gets the percentage of the damage received this shield blocks.
	 * 
	 * @return The percentage of the damage received this shield blocks.
	 */
	public int getDamageReduction() {
		return damageReduction.get();
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repairMaterial.getValue().test(repair);
	}

	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) {
		return true;
	}

}
