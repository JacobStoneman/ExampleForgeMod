package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.registries.RegistryObject;

public class CustomSlabBlock extends SlabBlock {
    public RegistryObject<Block> baseBlock;
    public RegistryObject<Block> doubleSlabBaseBlock;

    public CustomSlabBlock(Properties pProperties, RegistryObject<Block> doubleSlabBaseBlock, RegistryObject<Block> baseBlock) {
        super(pProperties);

        this.doubleSlabBaseBlock = doubleSlabBaseBlock;
        this.baseBlock = baseBlock;
    }
}
