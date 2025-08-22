package com.simomett.mycologymod.genetics.gene;

import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.effects.FungusEffects;
import net.minecraft.network.chat.Component;

public class EffectGene extends Gene<String>
{
    public EffectGene(String value) {
        super(value);
    }

    @Override
    public final void randomMutate()
    {
        value = FungusEffects.NO_EFFECT.getEffectName();
    }


    public Component translatableComponent()
    {
        return Component.translatable("gui."+ Constants.MOD_ID+".fungus_effect."+this.value);
    }
}
