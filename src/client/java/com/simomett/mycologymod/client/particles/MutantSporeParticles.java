package com.simomett.mycologymod.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MutantSporeParticles extends SporeParticles
{
    protected MutantSporeParticles(ClientLevel level, SpriteSet spriteSet, double x, double y, double z, double vX, double vY, double vZ)
    {
        super(level, spriteSet, x, y, z, vX, vY, vZ);
        int [] colors = {0x55453c, 0x6e5a4d, 0x55453c, 0x6e5a4d, 0x55453c, 0xfff100};
        int color = colors[new Random().nextInt(colors.length)];
        this.setColor((color >> 16)/255f, (color >> 8 & 255)/255f, (color & 255)/255f);
    }

    public static class Provider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet)
        {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double x, double y, double z, double vX, double vY, double vZ, RandomSource randomSource) {
            return new MutantSporeParticles(clientLevel, this.spriteSet, x, y, z, vX, vY, vZ);
        }
    }
}
