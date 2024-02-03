package com.mettsmirnov.mycology.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FungusEffects
{
    private static final HashMap<String, IFungusEffect> effectsHashMap = new HashMap<>();

    @Deprecated(forRemoval = true)
    public static final SingleEffect NO_EFFECT = new SingleEffect("none", null);
    public static final MultipleEffect POISON_EFFECT = new MultipleEffect("poison", List.of(MobEffects.POISON, MobEffects.CONFUSION));
    public static final SingleEffect DRUNK_EFFECT = new SingleEffect("drunkenness", null);
    public static final MultipleEffect FATIGUE_EFFECT = new MultipleEffect("mining_fatigue", List.of(MobEffects.MOVEMENT_SLOWDOWN, MobEffects.DIG_SLOWDOWN));
    public static final SingleEffect HEALING_EFFECT = new SingleEffect("regeneration", MobEffects.REGENERATION);
    public static final SingleEffect STRENGTH_EFFECT = new SingleEffect("strengthening", MobEffects.DAMAGE_BOOST);
    public static final SingleEffect ANESTHETIC_EFFECT = new SingleEffect("anesthetic", null);
    public static final SingleEffect ILLUCINATING_EFFECT = new SingleEffect("illucinating", null);
    public static final SingleEffect HALLUCINATING_EFFECT = new SingleEffect("hallucinating", null);
    public static final SingleEffect RADIOACTIVE_EFFECT = new SingleEffect("radioactive", null);
    public static final SingleEffect BLINDING_EFFECT = new SingleEffect("blinding", MobEffects.BLINDNESS);
    public static final SingleEffect PHANTOM_EFFECT = new SingleEffect("phantom", MobEffects.INVISIBILITY);
    public static final SingleEffect NIGHTLY_EFFECT = new SingleEffect("nightly", MobEffects.NIGHT_VISION);
    public static final SingleEffect SENSING_EFFECT = new SingleEffect("sensing", null);
    public static final SingleEffect SHINING_EFFECT = new SingleEffect("shining", MobEffects.GLOWING);
    public static final SingleEffect SCHIZO_EFFECT = new SingleEffect("schizo", null);
    public static final SingleEffect SPARKLING_EFFECT = new SingleEffect("sparkling", null);
    public static final SingleEffect WITHERING_EFFECT = new SingleEffect("wither", MobEffects.WITHER);
    public static final SingleEffect RAPTING_EFFECT = new SingleEffect("rapting", null);
    public static final SingleEffect TELEPORTING_EFFECT = new SingleEffect("teleporting", null);
    public static final SingleEffect LIGHTFUL_EFFECT = new SingleEffect("lightful", MobEffects.SLOW_FALLING);
    public static final SingleEffect GOODCHANCE_EFFECT = new SingleEffect("goodchance", MobEffects.LUCK);
    public static final SingleEffect LEARNING_EFFECT = new SingleEffect("learning", null);
    public static final SingleEffect KNOWLEDGE_EFFECT = new SingleEffect("knowledge", null);
    public static final SingleEffect SPORING_EFFECT = new SingleEffect("sporing", null);
    public static final SingleEffect DYEING_EFFECT = new SingleEffect("dyeing", null, (level, pos, box) -> {
        level.getEntitiesOfClass(Sheep.class, box).forEach( sheep -> {
            sheep.setColor(DyeColor.byId(new Random().nextInt(16)));
        });

    });
    public static final SingleEffect FERTILIZING_EFFECT = new SingleEffect("fertilizing", null);

    //dev
    public static final SingleEffect DEV_TEST_EFFECT = new SingleEffect("testing", null, (level, pos, box) -> {
            BlockPos.betweenClosedStream(box).forEach( p -> {
            level.setBlock(p, Blocks.DIAMOND_BLOCK.defaultBlockState(), 2);
        });
    });

    public static IFungusEffect getEffectByName(String effectName)
    {
        return effectsHashMap.get(effectName);
    }

    public static void registerFungusEffect(String effectName, IFungusEffect fungusEffect)
    {
        effectsHashMap.put(effectName, fungusEffect);
    }
}
