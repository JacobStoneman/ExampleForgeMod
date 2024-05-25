package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CustomStairsBlock extends StairBlock {
    public RegistryObject<Block> baseBlock;

    public CustomStairsBlock(Supplier<BlockState> state, Properties pProperties, RegistryObject<Block> baseBlock) {
        super(state, pProperties);

        this.baseBlock = baseBlock;
    }
}