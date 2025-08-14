package com.simomett.mycologymod.datacomponents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

import static com.simomett.mycologymod.genetics.FungusGenoma.*;
import static com.simomett.mycologymod.genetics.FungusGenoma.AREA;
import static com.simomett.mycologymod.genetics.FungusGenoma.EATING_EFFECT;
import static com.simomett.mycologymod.genetics.FungusGenoma.EFFECT;
import static com.simomett.mycologymod.genetics.FungusGenoma.HUMIDITY;
import static com.simomett.mycologymod.genetics.FungusGenoma.LIGHT;
import static com.simomett.mycologymod.genetics.FungusGenoma.TEMP;
import static com.simomett.mycologymod.genetics.FungusGenoma.TERRAIN;

public class DataComponentTypes
{
    public static final Codec<FungusTraits> FUNGUS_DATA_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf(SPECIES).forGetter(FungusTraits::species),
                    Codec.INT.fieldOf(SPREADING).forGetter(FungusTraits::spreading),
                    Codec.FLOAT.fieldOf(SPREAD_BOOST).forGetter(FungusTraits::spreadboost),
                    Codec.INT.fieldOf(LIGHT).forGetter(FungusTraits::light),
                    Codec.STRING.fieldOf(TERRAIN).forGetter(FungusTraits::terrain),
                    Codec.FLOAT.fieldOf(HUMIDITY).forGetter(FungusTraits::humidity),
                    Codec.FLOAT.fieldOf(TEMP).forGetter(FungusTraits::temp),
                    Codec.INT.fieldOf(AREA).forGetter(FungusTraits::area),
                    Codec.STRING.fieldOf(EFFECT).forGetter(FungusTraits::effect),
                    Codec.STRING.optionalFieldOf(EATING_EFFECT).forGetter(FungusTraits::eatingEffect)
            ).apply(instance, FungusTraits::new)
    );

    public static final Codec<FungusGenoma> FUNGUS_GENOMA_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    FUNGUS_DATA_CODEC.fieldOf("dominant").forGetter(FungusGenoma::getDominantTraits),
                    FUNGUS_DATA_CODEC.fieldOf("recessive").forGetter(FungusGenoma::getRecessiveTraits)
            ).apply(instance, FungusGenoma::new)
    );

    public static StreamCodec<FriendlyByteBuf, FungusGenoma> FUNGUS_GENOMA_STREAM_CODEC = StreamCodec.ofMember(FungusGenoma::encode, FungusGenoma::new);

    public static final String GENOMA_DATA_COMPONENT_NAME = "fungus_data";

}
