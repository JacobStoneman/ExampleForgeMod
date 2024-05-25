package net.klepto.utils.custom.blocks;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CustomDoorBlock extends DoorBlock {
    public String bottomTexLoc;
    public String topTexLoc;
    public String renderType;

    public CustomDoorBlock(Properties pProperties, BlockSetType pType, String bottomTexLoc, String topTexLoc, String renderType) {
        super(pProperties, pType);

        this.bottomTexLoc = bottomTexLoc;
        this.topTexLoc = topTexLoc;
        this.renderType = renderType;
    }
}
