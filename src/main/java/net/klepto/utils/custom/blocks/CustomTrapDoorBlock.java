package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CustomTrapDoorBlock extends TrapDoorBlock {
    public String texLoc;
    public boolean orientable;
    public String renderType;

    public CustomTrapDoorBlock(Properties pProperties, BlockSetType pType, String texLoc, Boolean orientable, String renderType) {
        super(pProperties, pType);

        this.texLoc = texLoc;
        this.orientable = orientable;
        this.renderType = renderType;
    }
}