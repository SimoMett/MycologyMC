package com.simomett.mycologymod.items;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simomett.mycologymod.data.FungusSpeciesColorsMap;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.simomett.mycologymod.datacomponents.DataComponentTypes.FUNGUS_GENOMA;

public record FungusTintSource(String fungusPart) implements ItemTintSource
{
    public static final MapCodec<FungusTintSource> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    ExtraCodecs.NON_EMPTY_STRING.fieldOf("part_name").forGetter(FungusTintSource::fungusPart)
            ).apply(instance, FungusTintSource::new)
    );

    public FungusTintSource(String fungusPart)
    {
        this.fungusPart = fungusPart;
    }

    private static final String[] partNames = {"stelum", "head", "details", "details2"};

    @Override
    public int calculate(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity)
    {
        int tintIndex = -1;
        for(int i = 0; i< partNames.length; i++)
        {
            if(partNames[i].equals(this.fungusPart))
            {
                tintIndex = i;
                break;
            }
        }

        if(itemStack.has(FUNGUS_GENOMA.dataComponentType()))
            return FungusSpeciesColorsMap.getInstance().get(itemStack.get(FUNGUS_GENOMA.dataComponentType()).dominantTraits().species())[tintIndex] | 0xff000000;
        else
            return 0;
    }

    @Override
    public MapCodec<? extends ItemTintSource> type()
    {
        return MAP_CODEC;
    }
}
