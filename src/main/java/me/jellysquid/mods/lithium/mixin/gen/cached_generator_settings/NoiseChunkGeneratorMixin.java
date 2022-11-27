package me.jellysquid.mods.lithium.mixin.gen.cached_generator_settings;

import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(NoiseChunkGenerator.class)
public class NoiseChunkGeneratorMixin {
    private int cachedSeaLevel;

    /**
     * Use cached sea level instead of retrieving from the registry every time.
     * This method is called for every block in the chunk so this will save a lot of registry lookups.
     *
     * @author SuperCoder79
     * @reason avoid registry lookup
     */
    @Overwrite
    public int getSeaLevel() {
        return this.cachedSeaLevel;
    }

    /**
     * Initialize the cache early in the ctor to avoid potential future problems with uninitialized usages
     */
    @Inject(
            method = "<init>(Lnet/minecraft/world/biome/source/BiomeSource;Lnet/minecraft/world/biome/source/BiomeSource;JLjava/util/function/Supplier;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/chunk/ChunkGeneratorSettings;getGenerationShapeConfig()Lnet/minecraft/world/gen/chunk/GenerationShapeConfig;",
                    shift = At.Shift.BEFORE
            )
    )
    private void hookConstructor(BiomeSource populationSource, BiomeSource biomeSource, long seed, Supplier<ChunkGeneratorSettings> settings, CallbackInfo ci) {
        this.cachedSeaLevel = settings.get().getSeaLevel();
    }
}