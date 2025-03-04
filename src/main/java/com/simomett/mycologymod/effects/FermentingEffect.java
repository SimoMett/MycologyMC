package com.simomett.mycologymod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.function.TriConsumer;

import java.util.List;
import java.util.Random;

public class FermentingEffect extends LevelOnlyEffect
{
    private static final TriConsumer<ServerLevel, BlockPos, AABB> consumer = (s, b, a) -> {
        List<ItemEntity> entityList = s.getEntitiesOfClass(ItemEntity.class, a, e->e.getItem().is(Items.SPIDER_EYE));
        if(!entityList.isEmpty())
        {
            int size = entityList.size();
            Random random = new Random();
            ItemEntity spiderEyeItem = entityList.get(random.nextInt(size));
            ItemStack fermentedSpiderEyeStack = new ItemStack(Items.FERMENTED_SPIDER_EYE, spiderEyeItem.getItem().getCount());
            spiderEyeItem.setItem(fermentedSpiderEyeStack);
        }
    };

    public FermentingEffect(String effectName)
    {
        super(effectName, consumer);
    }
}
