package net.klepto.utils.tags;

import net.klepto.utils.ModConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag(ModConfig.MOD_ID,"metal_detector_valuables");

        private static TagKey<Block> tag(String modId, String name) {
            return BlockTags.create(new ResourceLocation(modId, name));
        }
    }

    public static class Items {

        private static TagKey<Block> tag(String modId, String name) {
            return BlockTags.create(new ResourceLocation(modId, name));
        }
    }
}
