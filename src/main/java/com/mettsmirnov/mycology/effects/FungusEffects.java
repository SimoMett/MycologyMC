package com.mettsmirnov.mycology.effects;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FungusEffects
{
    private static final HashMap<String, IFungusEffect> effectsHashMap = new HashMap<>();

    public static final SingleEffect NO_EFFECT = new SingleEffect("none");
    public static final MultipleEffect POISON_EFFECT = new MultipleEffect("poison", List.of(MobEffects.POISON, MobEffects.CONFUSION));
    public static final SingleEffect DRUNK_EFFECT = new SingleEffect("drunkenness");
    public static final MultipleEffect FATIGUE_EFFECT = new MultipleEffect("mining_fatigue", List.of(MobEffects.MOVEMENT_SLOWDOWN, MobEffects.DIG_SLOWDOWN));
    public static final SingleEffect HEALING_EFFECT = new SingleEffect("regeneration", MobEffects.REGENERATION);
    public static final SingleEffect STRENGTH_EFFECT = new SingleEffect("strengthening", MobEffects.DAMAGE_BOOST);
    public static final SingleEffect ANESTHETIC_EFFECT = new SingleEffect("anesthetic");
    public static final SingleEffect ILLUCINATING_EFFECT = new SingleEffect("illucinating");
    public static final SingleEffect HALLUCINATING_EFFECT = new SingleEffect("hallucinating");
    public static final SingleEffect RADIOACTIVE_EFFECT = new SingleEffect("radioactive");
    public static final SingleEffect BLINDING_EFFECT = new SingleEffect("blinding", MobEffects.BLINDNESS);
    public static final SingleEffect PHANTOM_EFFECT = new SingleEffect("phantom", MobEffects.INVISIBILITY);
    public static final SingleEffect NIGHTLY_EFFECT = new SingleEffect("nightly", MobEffects.NIGHT_VISION);
    public static final SingleEffect SENSING_EFFECT = new SingleEffect("sensing");
    public static final SingleEffect SHINING_EFFECT = new SingleEffect("shining", MobEffects.GLOWING);
    public static final SingleEffect SCHIZO_EFFECT = new SingleEffect("schizo");
    public static final SingleEffect SPARKLING_EFFECT = new SingleEffect("sparkling");
    public static final SingleEffect WITHERING_EFFECT = new SingleEffect("wither", MobEffects.WITHER);
    public static final SingleEffect RAPTING_EFFECT = new SingleEffect("rapting");
    public static final SingleEffect TELEPORTING_EFFECT = new SingleEffect("teleporting");
    public static final SingleEffect LIGHTFUL_EFFECT = new SingleEffect("lightful", MobEffects.SLOW_FALLING);
    public static final SingleEffect GOODCHANCE_EFFECT = new SingleEffect("goodchance", MobEffects.LUCK);
    public static final SingleEffect LEARNING_EFFECT = new SingleEffect("learning");
    public static final SingleEffect KNOWLEDGE_EFFECT = new SingleEffect("knowledge");
    public static final SingleEffect SPORING_EFFECT = new SingleEffect("sporing", null, (level, pos, box) -> {
        final List<BlockPos> pList = new ArrayList<>();
        BlockPos.betweenClosedStream(box).forEach( p -> {
            pList.add(new BlockPos(p));
        });
        List <BlockPos> pList2 = pList.stream()
                .filter(p -> p.distSqr(pos) < box.getSize()/2.0f)
                .filter(p -> level.getBlockState(p).is(Blocks.GRASS_BLOCK))
                .toList();
        if (!pList2.isEmpty())
        {
            BlockPos randomPos = pList2.get(new Random().nextInt(pList2.size()));
            level.setBlock(randomPos, Blocks.MYCELIUM.defaultBlockState(), 2);
        }
    });
    public static final SingleEffect DYEING_EFFECT = new SingleEffect("dyeing", null, (level, pos, box) -> {
        level.getEntitiesOfClass(Sheep.class, box).forEach( sheep -> {
            sheep.setColor(DyeColor.byId(new Random().nextInt(16)));
        });

    });
    public static final SingleEffect FERTILIZING_EFFECT = new SingleEffect("fertilizing", null, (level, pos, box) -> {
        final List<BlockPos> pList = new ArrayList<>();
        BlockPos.betweenClosedStream(box).forEach( p -> {
            pList.add(new BlockPos(p));
        });
        List <BlockPos> pList2 = pList.stream()
                //.filter(p -> p.distSqr(pos) < box.getSize()/2.0f)
                .filter(p -> level.getBlockState(p).is(BlockTags.CROPS))
                .toList();
        if (!pList2.isEmpty())
        {
            BlockPos randomPos = pList2.get(new Random().nextInt(pList2.size()));
            BonemealableBlock block = (BonemealableBlock) level.getBlockState(randomPos).getBlock();
            block.performBonemeal(level, RandomSource.create(), randomPos, level.getBlockState(randomPos));
            //Particles are working with this patch, but I'm not sure about the quality of this code.
            if (Minecraft.getInstance().player != null)
                BoneMealItem.addGrowthParticles(Minecraft.getInstance().player.clientLevel, randomPos, 0);
        }
    });

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
