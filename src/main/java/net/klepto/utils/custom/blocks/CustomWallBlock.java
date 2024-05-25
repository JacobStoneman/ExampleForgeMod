package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.registries.RegistryObject;

public class CustomWallBlock extends WallBlock {
    public RegistryObject<Block> baseBlock;

    public CustomWallBlock(Properties pProperties, RegistryObject<Block> baseBlock) {
        super(pProperties);

        this.baseBlock = baseBlock;
    }
}