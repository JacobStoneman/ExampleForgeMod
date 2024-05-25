package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

public class CustomPressurePlateBlock extends PressurePlateBlock {
    public RegistryObject<Block> baseBlock;

    public CustomPressurePlateBlock(Sensitivity pSensitivity, Properties pProperties, BlockSetType pType, RegistryObject<Block> baseBlock) {
        super(pSensitivity, pProperties, pType);

        this.baseBlock = baseBlock;
    }
}
