package me.jellysquid.mods.lithium.common.world.blockview;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.CollisionView;
import net.minecraft.world.border.WorldBorder;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public record SingleBlockBlockView(BlockState state, BlockPos blockPos) implements BlockView, CollisionView {
    public static SingleBlockBlockView of(BlockState blockState, BlockPos blockPos) {
        return new SingleBlockBlockView(blockState, blockPos.toImmutable());
    }

    @Override
    public BlockState getBlockState(BlockPos pos) {
        if (pos.equals(this.blockPos())) {
            return this.state();
        }
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public FluidState getFluidState(BlockPos pos) {
        if (pos.equals(this.blockPos())) {
            return this.state().getFluidState();
        }
        throw SingleBlockViewException.INSTANCE;
    }

    @Nullable
    @Override
    public BlockEntity getBlockEntity(BlockPos pos) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public int getHeight() {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public int getBottomY() {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public WorldBorder getWorldBorder() {
        throw SingleBlockViewException.INSTANCE;
    }

    @Nullable
    @Override
    public BlockView getChunkAsView(int chunkX, int chunkZ) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public boolean canPlace(BlockState state, BlockPos pos, ShapeContext context) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public boolean isSpaceEmpty(Box box) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public boolean isSpaceEmpty(Entity entity) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public boolean isSpaceEmpty(@Nullable Entity entity, Box box) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public Stream<VoxelShape> getEntityCollisions(@Nullable Entity entity, Box box, Predicate<Entity> predicate) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public Stream<VoxelShape> getCollisions(@Nullable Entity entity, Box box, Predicate<Entity> predicate) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public Stream<VoxelShape> getBlockCollisions(@Nullable Entity entity, Box box, BiPredicate<BlockState, BlockPos> predicate) {
        throw SingleBlockViewException.INSTANCE;
    }

    @Override
    public Optional<Vec3d> findClosestCollision(@Nullable Entity entity, VoxelShape shape, Vec3d target, double x, double y, double z) {
        throw SingleBlockViewException.INSTANCE;
    }

    public static class SingleBlockViewException extends RuntimeException {

        public static final SingleBlockViewException INSTANCE = new SingleBlockViewException();

        private SingleBlockViewException() {
            this.setStackTrace(new StackTraceElement[0]);
        }

        @Override
        public synchronized Throwable fillInStackTrace() {
            this.setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }
}
