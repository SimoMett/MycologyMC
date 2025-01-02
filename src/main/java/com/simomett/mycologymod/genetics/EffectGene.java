package com.simomett.mycologymod.genetics;

import com.simomett.mycologymod.effects.FungusEffects;

public class EffectGene extends AbstractGene<String>
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
