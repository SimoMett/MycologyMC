package com.simomett.mycologymod.items;

import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Optional;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class ColoredFungusBlockItem extends BlockItem
{
    public static final List<MobEffectInstance> EFFECTS_WHEN_EATEN_RAW = List.of(
            new MobEffectInstance(MobEffects.POISON, 80),
            new MobEffectInstance(MobEffects.HUNGER, 140));

    public ColoredFungusBlockItem(Block block, ResourceLocation resourceLocation)
    {
        super(block, new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, resourceLocation))
                .stacksTo(DEFAULT_MAX_STACK_SIZE)
                .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity)
    {
        if(stack.get(FUNGUS_GENOMA).getDominantTraits().eatingEffect().isPresent())
        {
            String eatEff = stack.get(FUNGUS_GENOMA).getDominantTraits().eatingEffect().get();
            Optional<Holder.Reference<MobEffect>> mobEffect = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(eatEff));
            if(mobEffect.isPresent())
                livingEntity.addEffect(new MobEffectInstance(mobEffect.get().getDelegate(), -1));
            else
            {
                for(MobEffectInstance i : EFFECTS_WHEN_EATEN_RAW)
                    livingEntity.addEffect(i);
            }
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }

    @Override
    public Component getName(ItemStack itemStack)
    {
        String speciesName = itemStack.has(FUNGUS_GENOMA) ? itemStack.get(FUNGUS_GENOMA).getDominantTraits().species() : "Fungus impossibilis";
        return Component.literal(speciesName);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> components, TooltipFlag p_41424_)
    {
        super.appendHoverText(itemStack, tooltipContext, components, p_41424_);
        components.add(Component.literal("\u00a77Mycology WIP build"));
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState blockState)
    {
        boolean result = super.placeBlock(context, blockState);
        ColoredFungusBlockEntity entity = (ColoredFungusBlockEntity)context.getLevel().getBlockEntity(context.getClickedPos());

        entity.applyGenoma(context.getItemInHand().get(FUNGUS_GENOMA));
        return result;
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState blockState)
    {
        //fungi can be placed from hand only on mycelium or podzol blocks by default (see can_plant_on block tag)
        BlockPos clickedPos = context.getClickedPos();
        BlockState belowBlock = context.getLevel().getBlockState(clickedPos.below());
        return context.getLevel().getBlockState(clickedPos).isAir() && belowBlock.is(ModBlockTags.CAN_PLANT_ON);
    }
}
