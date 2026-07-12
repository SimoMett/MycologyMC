package com.simomett.mycologymod.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SporeParticles extends SingleQuadParticle
{
    protected SporeParticles(ClientLevel level, SpriteSet spriteSet, double x, double y, double z, double vX, double vY, double vZ)
    {
        super(level, x, y, z, spriteSet.first());
        this.friction = .8f;
        this.xd = vX;
        this.yd = vY;
        this.zd = vZ;
        this.quadSize *= 1.5f;
        this.setLifetime(3*20 + (new Random().nextInt(-4, 4)*5));
        this.gravity = 0.01f;
        this.setSpriteFromAge(spriteSet);
        int [] colors = {0x55453c, 0x6e5a4d, 0x55453c};
        int color = colors[new Random().nextInt(colors.length)];
        this.setColor((color >> 16)/255f, (color >> 8 & 255)/255f, (color & 255)/255f);
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet)
        {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double x, double y, double z, double vX, double vY, double vZ, RandomSource randomSource)
        {
            return new SporeParticles(clientLevel, this.spriteSet, x, y, z, vX, vY, vZ);
        }
    }
}
