package com.simomett.mycologymod.mixins;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FlowerPotBlock.class)
public interface IFlowerPotBlockMixin
{
    @Invoker("isEmpty")
    boolean invokeIsEmpty();
}
