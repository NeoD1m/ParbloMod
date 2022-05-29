package com.neodim.parblomod.client;

import com.neodim.parblomod.ParbloMod;

import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShieldTextures {

	public static final RenderMaterial LOCATION_PARBLO_SHIELD_BASE = material("entity/parblo_shield_base");
	public static final RenderMaterial LOCATION_PARBLO_SHIELD_BASE_NOPATTERN = material("entity/parblo_shield_base_nopattern");

	@SuppressWarnings("deprecation")
	private static RenderMaterial material(String path) {
		return new RenderMaterial(
				AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(ParbloMod.MOD_ID, path));
    }
}
