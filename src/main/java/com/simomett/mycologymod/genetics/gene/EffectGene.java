package com.simomett.mycologymod.genetics.gene;

import com.simomett.mycologymod.effects.FungusEffects;

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
}
