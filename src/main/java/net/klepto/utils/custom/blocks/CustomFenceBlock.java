package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraftforge.registries.RegistryObject;

public class CustomFenceBlock extends FenceBlock {
    public RegistryObject<Block> baseBlock;

    public CustomFenceBlock(Properties p_53302_, RegistryObject<Block> baseBlock) {
        super(p_53302_);

        this.baseBlock = baseBlock;
    }
}