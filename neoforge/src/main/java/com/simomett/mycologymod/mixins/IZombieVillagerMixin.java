package com.simomett.mycologymod.mixins;

import net.minecraft.world.entity.monster.ZombieVillager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import javax.annotation.Nullable;
import java.util.UUID;

@Mixin(ZombieVillager.class)
public interface IZombieVillagerMixin
{
    @Invoker
    void invokeStartConverting(@Nullable UUID p_34384_, int p_34385_);
}
