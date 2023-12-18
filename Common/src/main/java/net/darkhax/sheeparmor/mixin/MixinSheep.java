package net.darkhax.sheeparmor.mixin;

import net.darkhax.sheeparmor.SheepArmorCommon;
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
public class MixinSheep {

    @Inject(method = "setSheared(Z)V", at = @At("RETURN"))
    private void onSheepSheared(boolean isSheared, CallbackInfo cbi) {

        SheepArmorCommon.onSheepUpdated((Sheep) (Object) this);
    }

    @Inject(method = "finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/world/entity/SpawnGroupData;", at = @At("RETURN"))
    private void onSheepSpawn(ServerLevelAccessor server, DifficultyInstance difficulty, MobSpawnType spawnType, SpawnGroupData data, CompoundTag tag, CallbackInfoReturnable<SpawnGroupData> cbi) {

        SheepArmorCommon.onSheepUpdated((Sheep) (Object) this);
    }
}