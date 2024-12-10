package net.darkhax.sheeparmor.common.mixin;

import net.darkhax.sheeparmor.common.impl.SheepArmor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Sheep;
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

    @Inject(method = "finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;", at = @At("RETURN"))
    private void onSheepSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, SpawnGroupData groupData, CallbackInfoReturnable<SpawnGroupData> cir) {
        SheepArmor.updateSheep((Sheep) (Object) this);
    }
}