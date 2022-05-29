package com.neodim.parblomod.client;

import com.neodim.parblomod.Config;
import com.neodim.parblomod.ParbloMod;
import com.neodim.parblomod.ParbloShieldItem;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

//    public ModItems(){
//        new Config();
//        parbloShieldItem = new ParbloShieldItem("parblo_shield", () -> Config.netheriteDamageReduction.get(),
//				Tags.Items.INGOTS_NETHERITE, Config.netheriteDurability.get(), true);
//    }
//    public static ParbloShieldItem parbloShieldItem;

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ParbloMod.MOD_ID);

    public static final RegistryObject<Item> PARBLOSECOND = ITEMS.register("parblo_second",
            () -> new ParbloItem(new Item.Properties().maxStackSize(1).group(ModItemGroup.PARBLO_GROUP).isImmuneToFire(), "tooltip.parblomod.parblo_second", createExplosions((byte) 2), true));
    public static final RegistryObject<Item> PARBLOTHIRD = ITEMS.register("parblo_third",
            () -> new ParbloItem(new Item.Properties().maxStackSize(1).group(ModItemGroup.PARBLO_GROUP).isImmuneToFire(), "tooltip.parblomod.parblo_third", createExplosions((byte) 1), false));


    public static final RegistryObject<Item> PARBLO_SWORD = ITEMS.register("parblo_sword",
            () -> new ParbloSword(ModItemTier.PARBLO, 2, 3f, new Item.Properties().maxStackSize(1).group(ModItemGroup.PARBLO_GROUP).isImmuneToFire().setNoRepair()));

//    public static final RegistryObject<Item> PARBLO_SHIELD = ITEMS.register("parblo_shield", () ->
//            new ParbloShieldItem("parblo_shield", () -> Config.netheriteDamageReduction.get(),
//                    Tags.Items.INGOTS_NETHERITE, Config.netheriteDurability.get(), true));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static ListNBT createExplosions(Byte type) {
        ListNBT explosionsListNBT = new ListNBT();

        CompoundNBT explosionsNBT = new CompoundNBT();
        int[] colorsList = new int[]{14602026, 4312372, 11743532, 15435844, 2437522, 12801229};
        explosionsNBT.putIntArray("Colors", colorsList);
        explosionsNBT.putByte("Type", type);
        explosionsListNBT.add(explosionsNBT);

        return explosionsListNBT;
    }
}