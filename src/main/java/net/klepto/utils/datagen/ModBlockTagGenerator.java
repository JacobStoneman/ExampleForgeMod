package net.klepto.utils.datagen;

import net.klepto.testmod.block.ModBlocks;
import net.klepto.utils.tags.CustomBlockTag;
import net.klepto.utils.ModConfig;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ModConfig.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for(CustomBlockTag customTag : ModConfig.BLOCK_TAGS) {
            this.tag(customTag.tagKey).add(customTag.blocks).addTags(customTag.groups);
        }

        //TODO: Remove dependency on mod files
        this.tag(BlockTags.FENCES).add(ModBlocks.SAPPHIRE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.SAPPHIRE_WALL.get());
    }
}