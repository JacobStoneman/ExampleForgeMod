package net.klepto.utils.datagen.loot;

import net.klepto.utils.ModConfig;
import net.klepto.utils.custom.blocks.OreBlock;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for(RegistryObject<Block> dropSelfBlock : ModConfig.BLOCK_DROP_SELF_TABLES) {
            this.dropSelf(dropSelfBlock.get());
        }

        for(RegistryObject<Block> oreBlockReg : ModConfig.ORE_BLOCK_TABLES) {
            OreBlock oreBlock = (OreBlock) oreBlockReg.get();
            this.add(oreBlock, block -> createOreDrops(oreBlock, oreBlock.oreDrop.get(), oreBlock.dropRange.getMinValue(), oreBlock.dropRange.getMaxValue()));
        }
    }

    protected LootTable.Builder createOreDrops(Block pBlock, Item item, int min, int max) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModConfig.KNOWN_BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
