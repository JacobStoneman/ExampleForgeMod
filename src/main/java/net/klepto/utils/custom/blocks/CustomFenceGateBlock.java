package net.klepto.utils.custom.blocks;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraftforge.registries.RegistryObject;

public class CustomFenceGateBlock extends FenceGateBlock {
    public RegistryObject<Block> baseBlock;

    public CustomFenceGateBlock(Properties props, SoundEvent openSound, SoundEvent closeSound, RegistryObject<Block> baseBlock) {
        super(props, openSound, closeSound);

        this.baseBlock = baseBlock;
    }
}
