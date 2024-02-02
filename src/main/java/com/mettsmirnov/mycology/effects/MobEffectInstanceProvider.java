package com.mettsmirnov.mycology.effects;

import net.minecraft.advancements.critereon.MobEffectsPredicate;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Deprecated(forRemoval = true)
public class MobEffectInstanceProvider
{
    private static final Map<String, MobEffect> mobEffectMap = new HashMap<>();
    static
    {
        //Vanilla effects
        mobEffectMap.put("speed", MobEffects.MOVEMENT_SPEED);
        mobEffectMap.put("slowness", MobEffects.MOVEMENT_SLOWDOWN);
        mobEffectMap.put("haste",MobEffects.DIG_SPEED);
        mobEffectMap.put("mining_fatigue", MobEffects.DIG_SLOWDOWN);
        mobEffectMap.put("strength",MobEffects.DAMAGE_BOOST);
        mobEffectMap.put("jump_boost",MobEffects.JUMP);
        mobEffectMap.put("nausea",MobEffects.CONFUSION);
        mobEffectMap.put("regeneration", MobEffects.REGENERATION);
        mobEffectMap.put("resistance",MobEffects.DAMAGE_RESISTANCE);
        mobEffectMap.put("fire_resistance", MobEffects.FIRE_RESISTANCE);
        mobEffectMap.put("water_breathing", MobEffects.WATER_BREATHING);
        mobEffectMap.put("invisibility", MobEffects.INVISIBILITY);
        mobEffectMap.put("blindness", MobEffects.BLINDNESS);
        mobEffectMap.put("night_vision", MobEffects.NIGHT_VISION);
        mobEffectMap.put("hunger", MobEffects.HUNGER);
        mobEffectMap.put("weakness", MobEffects.WEAKNESS);
        mobEffectMap.put("poison", MobEffects.POISON);
        mobEffectMap.put("wither", MobEffects.WITHER);
        mobEffectMap.put("health_boost", MobEffects.HEALTH_BOOST);
        mobEffectMap.put("absorption", MobEffects.ABSORPTION);
        mobEffectMap.put("saturation", MobEffects.SATURATION);
        mobEffectMap.put("glowing", MobEffects.GLOWING);
        mobEffectMap.put("levitation", MobEffects.LEVITATION);
        mobEffectMap.put("luck", MobEffects.LUCK);
        mobEffectMap.put("unluck", MobEffects.UNLUCK);
        mobEffectMap.put("slow_falling", MobEffects.SLOW_FALLING);
        mobEffectMap.put("conduit_power", MobEffects.CONDUIT_POWER);
        mobEffectMap.put("dolphins_grace", MobEffects.DOLPHINS_GRACE);
        mobEffectMap.put("bad_omen", MobEffects.BAD_OMEN);
        mobEffectMap.put("hero_of_the_village", MobEffects.HERO_OF_THE_VILLAGE);
        mobEffectMap.put("darkness", MobEffects.DARKNESS);
    }
}
