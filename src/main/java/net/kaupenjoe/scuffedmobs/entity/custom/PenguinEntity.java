package net.kaupenjoe.scuffedmobs.entity.custom;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PenguinEntity extends Animal {
    public AnimationState idleState = new AnimationState();
    public int idleTimeout = 0;

    public List<Boat> previousBoats = new ArrayList<>();

    public PenguinEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 10f));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.1f));
    }

    private void setupAnimationStates() {
        if (this.idleTimeout <= 0) {
            this.idleTimeout = this.random.nextInt(40) + 80;
            this.idleState.start(this.tickCount);
        } else {
            --this.idleTimeout;
        }
    }

    public static AttributeSupplier.Builder createLivingAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 20f)
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.25f);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        if(hasPlayerRiddenBoatInRange(this.blockPosition())) {
            increaseBoatSpeed();
        } else {
            if(!previousBoats.isEmpty()) {
                for (Boat boat : previousBoats) {
                    boat.setDeltaMovement(boat.getDeltaMovement().scale(0.5f));
                }
            }
        }
    }

    private boolean hasPlayerRiddenBoatInRange(BlockPos pos) {
        previousBoats = this.level().getEntities(EntityType.BOAT, new AABB(pos).inflate(16), Boat::isVehicle);

        return previousBoats.stream().anyMatch(boat -> boat.isVehicle());
    }

    private void increaseBoatSpeed() {
        this.level().getEntities(EntityType.BOAT,
                new AABB(this.blockPosition()).inflate(16), Boat::isVehicle).stream()
                .forEach(boat -> {
                    ScuffedMobsMod.LOGGER.info(String.valueOf(boat.getControllingPassenger().getDeltaMovement()));
                    ScuffedMobsMod.LOGGER.info(String.valueOf(boat.getDeltaMovement()));
                    boat.getControllingPassenger().setDeltaMovement(boat.getControllingPassenger().getDeltaMovement().scale(10f));
                    ScuffedMobsMod.LOGGER.info(String.valueOf(boat.getDeltaMovement()));
                });
    }
}
