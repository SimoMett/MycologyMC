package com.mettsmirnov.mycology.effects;

import com.mettsmirnov.mycology.effects.PlayerEffects.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FungusEffects
{
    private static final HashMap<String, FungusEffect> effectsHashMap = new HashMap<>();

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
    public static final SingleEffect LEARNING_EFFECT = new SingleEffect("learning", ModEffects.GAIN_XP.get());
    public static final SingleEffect KNOWLEDGE_EFFECT = new SingleEffect("knowledge", ModEffects.XP_MULTIPLIER.get());
    public static final FungusEffect SPORING_EFFECT = new TransmuteBlockEffect("sporing", BlockTags.VALID_SPAWN, Blocks.MYCELIUM);
    public static final FungusEffect FREEZING_EFFECT = new TransmuteBlockEffect("freezing", Blocks.WATER, Blocks.ICE);
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
            RandomSource randomSource = RandomSource.create();
            block.performBonemeal(level, randomSource, randomPos, level.getBlockState(randomPos));

            int particlesCount = 4;
            //sendParticles(T type, double posX, double posY, double posZ, int particlesCount, double xOffset, double yOffset, double zOffset, double speed);
            level.sendParticles(ParticleTypes.HAPPY_VILLAGER, randomPos.getX() + randomSource.nextDouble(), randomPos.getY() + 0.6, randomPos.getZ() + randomSource.nextDouble(), particlesCount, 0, 0, 0.1, 0.5);
        }
    });
    public static final FungusEffect DECOMPOSING2_EFFECT = new SingleEffect("decomposing2", null, (lvl, pos, box) -> {
        final List<BlockPos> pList = new ArrayList<>();
        BlockPos.betweenClosedStream(box).forEach( p -> {
            pList.add(new BlockPos(p));
        });
        List <BlockPos> logBlocksList = pList.stream()
                .filter(p -> p.distSqr(pos) < box.getSize()/2.0f)
                .filter(p -> lvl.getBlockState(p).is(BlockTags.OVERWORLD_NATURAL_LOGS))
                //.filter(p -> lvl.getBlockState(p.below()).is(BlockTags.DIRT))
                .toList();
        if (!logBlocksList.isEmpty())
        {
            BlockPos randomPos = logBlocksList.get(new Random().nextInt(logBlocksList.size()));
            lvl.setBlock(randomPos, Blocks.AIR.defaultBlockState(), 2);
            if(lvl.getBlockState(randomPos.below()).is(BlockTags.DIRT))
                lvl.setBlock(randomPos.below(), Blocks.PODZOL.defaultBlockState(), 2);
        }
    });
    public static final FungusEffect DECOMPOSING_EFFECT = new SingleEffect("decomposing", null, (lvl, pos, box) -> {
        final List<BlockPos> pList = new ArrayList<>();
        BlockPos.betweenClosedStream(box).forEach( p -> {
            pList.add(new BlockPos(p));
        });
        List <BlockPos> logBlocksList = pList.stream()
                .filter(p -> p.distSqr(pos) < box.getSize()/2.0f)
                .filter(p -> lvl.getBlockState(p).is(BlockTags.OVERWORLD_NATURAL_LOGS))
                .toList();
        if (!logBlocksList.isEmpty())
        {
            BlockPos randomPos = logBlocksList.get(new Random().nextInt(logBlocksList.size()));
            Item blockItem = lvl.getBlockState(randomPos).getBlock().asItem();
            ItemStack itemStack = new ItemStack(blockItem);
            lvl.addFreshEntity(new ItemEntity(lvl, randomPos.getX(), randomPos.getY(), randomPos.getZ(), itemStack));
            lvl.setBlock(randomPos, Blocks.AIR.defaultBlockState(), 2);
            lvl.playLocalSound(randomPos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1f, 1f, false);
            if(lvl.getBlockState(randomPos.below()).is(BlockTags.DIRT))
                lvl.setBlock(randomPos.below(), Blocks.PODZOL.defaultBlockState(), 2);
        }
    });
    public static final FungusEffect BUDDING_EFFECT = new TransmuteBlockEffect("budding", Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST);
    //entities spawn
    public static final FungusEffect UNDEAD_EFFECT = new SpawnEntityEffect("undead", Zombie::new);
    public static final FungusEffect CREEPING_EFFECT = new SpawnEntityEffect("creeping", (lvl) -> new Creeper(EntityType.CREEPER, lvl));
    public static final FungusEffect SKELETONS_EFFECT = new SpawnEntityEffect("skeletons", (lvl) -> new Skeleton(EntityType.SKELETON, lvl));
    public static final FungusEffect GHASTLY_EFFECT = new SpawnEntityEffect("ghastly", (lvl) -> new Ghast(EntityType.GHAST, lvl));
    public static final FungusEffect BLAZING_EFFECT = new SpawnEntityEffect("blazing" ,(lvl) -> new Blaze(EntityType.BLAZE, lvl));
    public static final FungusEffect LIGHTNING_EFFECT = new SpawnEntityEffect("lightning", (lvl) -> new LightningBolt(EntityType.LIGHTNING_BOLT, lvl));
    public static final FungusEffect EXPORBS_EFFECT = new SpawnEntityEffect("exporbs", (lvl) -> {
        ExperienceOrb orb = new ExperienceOrb(EntityType.EXPERIENCE_ORB, lvl);
        orb.value = 1;
        return orb;
    });
    //dev
    public static final FungusEffect DEV_TEST_EFFECT = new TransmuteBlockEffect("testing", Blocks.GRASS_BLOCK, Blocks.DIAMOND_ORE);
    public static final FungusEffect TNT_EFFECT = new SpawnEntityEffect("tnt", (lvl) -> {
        PrimedTnt tnt = new PrimedTnt(EntityType.TNT, lvl);
        tnt.setFuse(100);//five seconds
        return tnt;
    });

    public static FungusEffect getEffectByName(String effectName)
    {
        return effectsHashMap.get(effectName);
    }

    public static void registerFungusEffect(String effectName, FungusEffect fungusEffect)
    {
        effectsHashMap.put(effectName, fungusEffect);
    }
}
