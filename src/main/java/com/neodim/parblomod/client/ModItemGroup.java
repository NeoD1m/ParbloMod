package com.neodim.parblomod.client;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static  final ItemGroup PARBLO_GROUP = new ItemGroup("parbloModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.PARBLOSECOND.get());
        }
    };
}
