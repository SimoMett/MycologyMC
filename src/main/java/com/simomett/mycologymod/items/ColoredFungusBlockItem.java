package com.simomett.mycologymod.items;

import com.simomett.mycologymod.entities.ColoredFungusBlockEntity;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static com.simomett.mycologymod.datacomponents.ModDataComponentTypes.FUNGUS_GENOMA;

public class ColoredFungusBlockItem extends BlockItem
{
    private static final List<MobEffectInstance> EFFECTS_WHEN_EATEN_RAW = List.of(
            new MobEffectInstance(MobEffects.POISON, 80),
            new MobEffectInstance(MobEffects.HUNGER, 140));

    public ColoredFungusBlockItem(Block block, ResourceLocation resourceLocation)
    {
        super(block, new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, resourceLocation))
                .stacksTo(DEFAULT_MAX_STACK_SIZE)
                .food(new FoodProperties.Builder().alwaysEdible().nutrition(1).build(),
                        Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(EFFECTS_WHEN_EATEN_RAW)).build()));
    }

    /*public @Nullable FoodProperties getFoodProperties(ItemStack stack, LivingEntity entity)
    {
        Optional<String> eatEff = stack.get(FUNGUS_GENOMA).getDominantTraits().eatingEffect();
        if(eatEff.isPresent())
        {
            MobEffect mobEffect = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(eatEff.get()));
            if(mobEffect==null)
                throw new NullPointerException("mobEffect specified in "+EATING_EFFECT+" is null");
            return new FoodProperties.Builder().alwaysEdible().effect(()-> new MobEffectInstance(Holder.direct(mobEffect), -1), 1f).build();
        }
        return Foods.SPIDER_EYE;
    }*/

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
        //fungi can be placed from hand only on mycelium or podzol blocks
        BlockPos clickedPos = context.getClickedPos();
        BlockState belowBlock = context.getLevel().getBlockState(clickedPos.below());
        return context.getLevel().getBlockState(clickedPos).isAir() && belowBlock.is(ModBlockTags.CAN_PLANT_ON);
    }
}
