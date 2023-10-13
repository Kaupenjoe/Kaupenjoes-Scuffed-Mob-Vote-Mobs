package net.kaupenjoe.scuffedmobs.entity.ai;

import net.kaupenjoe.scuffedmobs.entity.custom.CrabEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;

public class CrabWaveGoal extends LookAtPlayerGoal {
    CrabEntity crab;

    public CrabWaveGoal(Mob pMob, Class<? extends LivingEntity> pLookAtType, float pLookDistance) {
        super(pMob, pLookAtType, pLookDistance);
        crab = ((CrabEntity) pMob);
    }

    public void tick() {
        super.tick();

        if (this.lookAt.isAlive()) {
            this.crab.setWaving(true);
        }
    }

    @Override
    public void stop() {
        super.stop();
        this.crab.setWaving(false);
    }
}
