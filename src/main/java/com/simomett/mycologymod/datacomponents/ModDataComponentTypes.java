package com.simomett.mycologymod.datacomponents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.simomett.mycologymod.genetics.FungusGenoma.*;

public class ModDataComponentTypes
{
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MycologyMod.MODID);

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

    public static StreamCodec<ByteBuf, FungusGenoma> FUNGUS_GENOMA_STREAM_CODEC = StreamCodec.ofMember(FungusGenoma::encode, FungusGenoma::FungusGenomaFromByteBuf);

    public static final Supplier<DataComponentType<FungusGenoma>> FUNGUS_GENOMA = DATA_COMPONENTS.registerComponentType(
            "fungus_data",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent(FUNGUS_GENOMA_CODEC)
                    // The codec to read/write the data across the network
                    .networkSynchronized(FUNGUS_GENOMA_STREAM_CODEC)
    );
}
