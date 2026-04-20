package net.darkhax.sheeparmor.common.mixin;

import net.darkhax.sheeparmor.common.SheepArmor;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public abstract class MixinSheep {

    @Inject(method = "setSheared(Z)V", at = @At("RETURN"))
    private void onSheepSheared(boolean isSheared, CallbackInfo cbi) {
        SheepArmor.updateSheep((Sheep) (Object) this);
    }

    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void onSheepSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, SpawnGroupData groupData, CallbackInfoReturnable<SpawnGroupData> cir) {
        SheepArmor.updateSheep((Sheep) (Object) this);
    }
}