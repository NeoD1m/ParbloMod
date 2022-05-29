package com.neodim.parblomod.client;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class ParbloItem extends Item {
    public ParbloItem(Properties properties, String tooltip,ListNBT explosionsListNBT,Boolean isSecond) {
        super(properties);
        _tooltip = tooltip;
        _explosionsNBT = explosionsListNBT;
        _isSecond = isSecond;
    }
    ListNBT _explosionsNBT;
    String _tooltip;
    Boolean _isSecond;
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent(_tooltip));
        super.addInformation(stack, world, tooltip, flag);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        if (!world.isRemote) {
            ItemStack itemstack = context.getItem();
            // нбт это ад

            CompoundNBT fireworksNBT = new CompoundNBT();


            CompoundNBT finalExplosionsNBT = new CompoundNBT();

            finalExplosionsNBT.put("Explosions",_explosionsNBT);
            CompoundNBT flightNBT = new CompoundNBT();
            flightNBT.putByte("Flight",(byte) 1);

            flightNBT.merge(finalExplosionsNBT);

            fireworksNBT.put("Fireworks",flightNBT);

            itemstack.setTag(fireworksNBT);

            Vector3d vector3d = context.getHitVec();
            Direction direction = context.getFace();

            int offset = 2;
            if (_isSecond){
                world.addEntity(new FireworkRocketEntity(world, context.getPlayer(), vector3d.x + offset + (double)direction.getXOffset() * 0.15D, vector3d.y + (double)direction.getYOffset() * 0.15D, vector3d.z + (double)direction.getZOffset() * 0.15D, itemstack));
                world.addEntity(new FireworkRocketEntity(world, context.getPlayer(), vector3d.x + (double)direction.getXOffset() * 0.15D, vector3d.y + (double)direction.getYOffset() * 0.15D, vector3d.z - offset + (double)direction.getZOffset() * 0.15D, itemstack));
                world.addEntity(new FireworkRocketEntity(world, context.getPlayer(), vector3d.x - offset + (double)direction.getXOffset() * 0.15D, vector3d.y + (double)direction.getYOffset() * 0.15D, vector3d.z + offset + (double)direction.getZOffset() * 0.15D, itemstack));
            } else {
                FireworkRocketEntity fireworkrocketentity = new FireworkRocketEntity(world, context.getPlayer(), vector3d.x + (double)direction.getXOffset() * 0.15D, vector3d.y + (double)direction.getYOffset() * 0.15D, vector3d.z + (double)direction.getZOffset() * 0.15D, itemstack);
                world.addEntity(fireworkrocketentity);
            }

        }

        return ActionResultType.func_233537_a_(world.isRemote);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }
    }
