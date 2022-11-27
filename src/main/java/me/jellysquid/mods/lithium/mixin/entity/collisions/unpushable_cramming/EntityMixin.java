package me.jellysquid.mods.lithium.mixin.entity.collisions.unpushable_cramming;

import me.jellysquid.mods.lithium.common.entity.pushable.BlockCachingEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin implements BlockCachingEntity {
    @Shadow
    public World world;

    @Shadow
    public abstract BlockPos getBlockPos();

    @Unique
    private @Nullable BlockState blockStateAtPos;

    @Inject(
            method = "setPos(DDD)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/BlockPos;<init>(III)V"
            )
    )
    private void onPositionChanged(double x, double y, double z, CallbackInfo ci) {
        this.blockStateAtPos = null;
        this.lithiumOnBlockCacheDeleted();
    }

    @Inject(
            method = "baseTick()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/Entity;hasVehicle()Z",
                    ordinal = 0,
                    shift = At.Shift.BEFORE
            )
    )
    private void onBaseTick(CallbackInfo ci) {
        this.blockStateAtPos = null;
        this.lithiumOnBlockCacheDeleted();
    }

    @Inject(
            method = "getBlockStateAtPos()Lnet/minecraft/block/BlockState;",
            at = @At("HEAD")
    )
    private void onBlockCached(CallbackInfoReturnable<BlockState> cir) {
        if (this.blockStateAtPos == null) {
            this.blockStateAtPos = this.world.getBlockState(this.getBlockPos());
            this.lithiumOnBlockCacheSet(this.blockStateAtPos);
        }
    }

    @Override
    public BlockState getCachedFeetBlockState() {
        return this.blockStateAtPos;
    }
}
