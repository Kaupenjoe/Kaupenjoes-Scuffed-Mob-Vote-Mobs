package net.kaupenjoe.scuffedmobs.entity.custom;

import net.kaupenjoe.scuffedmobs.entity.ai.CrabWaveGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class CrabEntity extends Animal {
    public static final EntityDataAccessor<Boolean> WAVING =
            SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.BOOLEAN);

    public static final EntityDataAccessor<Boolean> RAVING =
            SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationState idleState = new AnimationState();
    public int idleTimeout = 0;

    public AnimationState wavingState = new AnimationState();

    public AnimationState raveState = new AnimationState();

    @javax.annotation.Nullable
    private BlockPos jukebox;

    public CrabEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new CrabWaveGoal(this, Player.class, 10f));
    }

    @Override
    public void setRecordPlayingNearby(BlockPos pJukebox, boolean pPartyParrot) {
        this.entityData.set(RAVING, pPartyParrot);
    }

    private void setupAnimationStates() {
        wavingState.animateWhen(this.entityData.get(WAVING), this.tickCount);
        raveState.animateWhen(this.entityData.get(RAVING), this.tickCount);

        if (this.idleTimeout <= 0) {
            this.idleTimeout = this.random.nextInt(40) + 80;
            this.idleState.start(this.tickCount);
        } else {
            --this.idleTimeout;
        }
    }

    public void aiStep() {
        if (this.jukebox == null || !this.jukebox.closerToCenterThan(this.position(), 3.46D) ||
                !this.level().getBlockState(this.jukebox).is(Blocks.JUKEBOX)) {
            // this.entityData.set(RAVING, false);
            this.jukebox = null;
        }

        super.aiStep();
    }

    public static AttributeSupplier.Builder createLivingAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 20f)
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 1f);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    public void setWaving(boolean wave) {
        this.entityData.set(WAVING, wave);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WAVING, false);
        this.entityData.define(RAVING, false);
    }
}
