package com.simomett.mycologymod.effects;

import com.simomett.mycologymod.config.ModCommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Random;

import static com.simomett.mycologymod.effects.SpawnEntityEffect.getPositionsForSpawningEntity;

public class LightningEffect extends FungusEffect
{
    public LightningEffect(String effectName)
    {
        super(effectName);
    }

    @Override
    public void applyEffectToEntity(LivingEntity entity) {

    }

    @Override
    public void applyEffectToLevel(ServerLevel level, BlockPos origin, int radius)
    {
        LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);

        Random rand = new Random();
        AABB bbox = FungusEffect.getAABB(origin, radius);
        List<Creeper> creepers = level.getEntitiesOfClass(Creeper.class, bbox);
        if(rand.nextInt(ModCommonConfigs.EFFECT_LIGHTNING_HIT_CREEPER_CHANCE.get()) == 0 && !creepers.isEmpty())
        {
            LivingEntity e = creepers.get(rand.nextInt(creepers.size()));
            lightningBolt.setPos(e.position());
        }
        else
        {
            List<BlockPos> pList = getPositionsForSpawningEntity(level, origin, radius);
            if(!pList.isEmpty())
                lightningBolt.setPos(pList.get(rand.nextInt(pList.size())).getCenter());
        }

        level.addFreshEntity(lightningBolt);
    }
}
