package net.klepto.utils.custom.blocks;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraftforge.registries.RegistryObject;

public class OreBlock extends DropExperienceBlock {

    public RegistryObject<Item> oreDrop;
    public IntProvider dropRange;

    public OreBlock(Properties pProperties, RegistryObject<Item> _oreDrop, IntProvider pXpRange, IntProvider _dropRange) {
        super(pProperties, pXpRange);
        this.oreDrop = _oreDrop;
        this.dropRange = _dropRange;
    }
}
