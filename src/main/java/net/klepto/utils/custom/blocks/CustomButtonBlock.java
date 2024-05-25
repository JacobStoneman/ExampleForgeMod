package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

public class CustomButtonBlock extends ButtonBlock {
    public RegistryObject<Block> baseBlock;

    public CustomButtonBlock(Properties pProperties, BlockSetType pType, int pTicksToStayPressed, boolean pArrowsCanPress, RegistryObject<Block> baseBlock) {
        super(pProperties, pType, pTicksToStayPressed, pArrowsCanPress);

        this.baseBlock = baseBlock;
    }
}
