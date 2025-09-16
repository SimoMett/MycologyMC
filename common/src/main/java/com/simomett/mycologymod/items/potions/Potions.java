package com.simomett.mycologymod.items.potions;

import com.simomett.mycologymod.effects.FungusEffect;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.effects.player.EffectsDefinitions;
import com.simomett.mycologymod.platform.Services;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;

import java.util.ArrayList;
import java.util.List;

public class Potions
{
    public static final int DEFAULT_DURATION = 20*60*3;
    public static final int LONG_DURATION = 20*60*8;
    public static final int STRONG_DURATION = 20*90;

    public static final Holder<Potion> HASTE = Services.PLATFORM.registerPotion("haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED)));
    public static final Holder<Potion> LONG_HASTE = Services.PLATFORM.registerPotion("long_haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, LONG_DURATION)));
    public static final Holder<Potion> STRONG_HASTE = Services.PLATFORM.registerPotion("strong_haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, STRONG_DURATION, 1)));
    public static final Holder<Potion> ANESTHETIC = register(FungusEffects.ANESTHETIC_EFFECT, EffectsDefinitions.ANESTHETIC.holder());
    //public static final Holder<Potion> ILLUCINATING = Services.PLATFORM.registerPotion(FungusEffects.ILLUCINATING_EFFECT.getEffectName(), () -> new Potion(FungusEffects.ILLUCINATING_EFFECT.getEffectName(), new MobEffectInstance(EffectsDefinitions.holderOf(EffectsDefinitions.ILLUCINATIONS))));
    //public static final Holder<Potion> HALLUCINATING = register("", EffectsDefinitions.HALL);
    public static final Holder<Potion> BLINDING = register(FungusEffects.BLINDING_EFFECT, MobEffects.BLINDNESS);
    public static final Holder<Potion> SENSING = register(FungusEffects.SENSING_EFFECT, EffectsDefinitions.SENSING.holder());
    public static final Holder<Potion> WITHERING = register(FungusEffects.WITHERING_EFFECT, MobEffects.WITHER);
    //public static final Potion RAPTING = register("", EffectsDefinitions.RA.)));
    public static final Holder<Potion> TELEPORTING = Services.PLATFORM.registerPotion(FungusEffects.TELEPORTING_EFFECT.getEffectName(),
            () -> new Potion(FungusEffects.TELEPORTING_EFFECT.getEffectName(), new MobEffectInstance(EffectsDefinitions.TELEPORTING.holder())));

    private static Holder<Potion> register(FungusEffect fungusEffectName, Holder<MobEffect> effectHolder)
    {
        return Services.PLATFORM.registerPotion(fungusEffectName.getEffectName(),
                () -> new Potion(fungusEffectName.getEffectName(), new MobEffectInstance(effectHolder)));
    }

    public static List<ItemStack> getModPotions()
    {
        ArrayList<ItemStack> potions = new ArrayList<>(11);
        potions.add(PotionContents.createItemStack(Items.POTION, HASTE));
        potions.add(PotionContents.createItemStack(Items.POTION, LONG_HASTE));
        potions.add(PotionContents.createItemStack(Items.POTION, STRONG_HASTE));
        //potions.add(PotionContents.createItemStack(Items.POTION, ANESTHETIC));
        //potions.add(PotionContents.createItemStack(Items.POTION, ILLUCINATING));
        //potions.add(PotionContents.createItemStack(Items.POTION, HALLUCINATING));
        potions.add(PotionContents.createItemStack(Items.POTION, BLINDING));
        potions.add(PotionContents.createItemStack(Items.POTION, SENSING));
        potions.add(PotionContents.createItemStack(Items.POTION, WITHERING));
        //potions.add(PotionContents.createItemStack(Items.POTION, RAPTING));
        potions.add(PotionContents.createItemStack(Items.POTION, TELEPORTING));
        return potions;
    }

    public static void init(){}

}
