package com.simomett.mycologymod.datacomponents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;

import java.util.function.UnaryOperator;

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
    private static <T> IRegisteredDataComponentType<T> registerDataComponentType(String name, UnaryOperator<DataComponentType.Builder<T>> builder)
    {
        DataComponentType<T> dataComponentType = Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, name),
                builder.apply(DataComponentType.builder()).build()
        );
        return new FabricDataComponent<>(dataComponentType);
    }

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
                    FUNGUS_DATA_CODEC.fieldOf("dominant").forGetter(FungusGenoma::dominantTraits),
                    FUNGUS_DATA_CODEC.fieldOf("recessive").forGetter(FungusGenoma::recessiveTraits)
            ).apply(instance, FungusGenoma::new)
    );

    public static StreamCodec<FriendlyByteBuf, FungusGenoma> FUNGUS_GENOMA_STREAM_CODEC = StreamCodec.ofMember(FungusGenoma::encode, FungusGenoma::new);

    public static final UnaryOperator<DataComponentType.Builder<FungusGenoma>> FUNGUS_GENOMA_BUILDER =
            b -> b
                    .persistent(FUNGUS_GENOMA_CODEC)
                    .networkSynchronized(FUNGUS_GENOMA_STREAM_CODEC);

    public static final String GENOMA_DATA_COMPONENT_NAME = "fungus_data";
    public static IRegisteredDataComponentType<FungusGenoma> FUNGUS_GENOMA = registerDataComponentType(GENOMA_DATA_COMPONENT_NAME, FUNGUS_GENOMA_BUILDER);

    public static void init(){}

}
