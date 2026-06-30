package net.mornity.dappledup.client.particle;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;

@OnlyIn(Dist.CLIENT)
public class YellowPoplarLeafParticleParticle extends TextureSheetParticle {
	public static YellowPoplarLeafParticleParticleProvider provider(SpriteSet spriteSet) {
		return new YellowPoplarLeafParticleParticleProvider(spriteSet);
	}

	public static class YellowPoplarLeafParticleParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public YellowPoplarLeafParticleParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new YellowPoplarLeafParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;
    private static final float ACCELERATION_SCALE = 0.0025F;
    private static final int INITIAL_LIFETIME = 300;
    private static final int CURVE_ENDPOINT_TIME = 300;
    private static final float FALL_ACC = 0.25F;
    private static final float WIND_BIG = 2.0F;
    private float rotSpeed;
    private final float particleRandom;
    private final float spinAcceleration;

	protected YellowPoplarLeafParticleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
        this.rotSpeed = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
        this.particleRandom = this.random.nextFloat();
        this.spinAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
        this.lifetime = 300;
        this.gravity = 7.5E-4F;
        float f = this.random.nextBoolean() ? 0.05F : 0.075F;
        this.quadSize = f;
        this.setSize(f, f);
        this.friction = 1.0F;
		this.pickSprite(spriteSet);

	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        }

        if (!this.removed) {
            float f = (float)(300 - this.lifetime);
            float f1 = Math.min(f / 300.0F, 1.0F);
            double d0 = Math.cos(Math.toRadians((double)(this.particleRandom * 60.0F))) * 2.0 * Math.pow((double)f1, 1.25);
            double d1 = Math.sin(Math.toRadians((double)(this.particleRandom * 60.0F))) * 2.0 * Math.pow((double)f1, 1.25);
            this.xd += d0 * 0.0025F;
            this.zd += d1 * 0.0025F;
            this.yd = this.yd - (double)this.gravity;
            this.rotSpeed = this.rotSpeed + this.spinAcceleration / 20.0F;
            this.oRoll = this.roll;
            this.roll = this.roll + this.rotSpeed / 20.0F;
            this.move(this.xd, this.yd, this.zd);
            if (this.onGround || this.lifetime < 299 && (this.xd == 0.0 || this.zd == 0.0)) {
                this.remove();
            }

            if (!this.removed) {
                this.xd = this.xd * (double)this.friction;
                this.yd = this.yd * (double)this.friction;
                this.zd = this.zd * (double)this.friction;
            }
        }
    }
}