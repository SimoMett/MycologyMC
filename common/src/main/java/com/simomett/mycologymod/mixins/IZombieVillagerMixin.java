package com.simomett.mycologymod.mixins;

import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.UUID;

@Mixin(ZombieVillager.class)
public interface IZombieVillagerMixin
{
    @Invoker
    void invokeStartConverting(UUID p_34384_, int p_34385_);
}
