package net.klepto.utils.datagen;

import net.klepto.utils.ModConfig;
import net.klepto.utils.custom.blocks.*;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateGenerator extends BlockStateProvider {
    public ModBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ModConfig.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(RegistryObject<Block> blockWithItemState : ModConfig.BLOCK_WITH_ITEM_STATES) {
            blockWithItem(blockWithItemState);
        }

        for(RegistryObject<Block> doorBlock : ModConfig.DOORS) {
            CustomDoorBlock door = (CustomDoorBlock) doorBlock.get();
            doorBlockWithRenderType(door, modLoc(door.bottomTexLoc), modLoc(door.topTexLoc), door.renderType);
        }

        for(RegistryObject<Block> trapDoorBlock : ModConfig.TRAP_DOORS) {
            CustomTrapDoorBlock trapDoor = (CustomTrapDoorBlock) trapDoorBlock.get();
            trapdoorBlockWithRenderType(trapDoor, modLoc(trapDoor.texLoc), trapDoor.orientable, trapDoor.renderType);
        }

        for(RegistryObject<Block> fenceBlock : ModConfig.FENCE_BLOCKS) {
            fenceBlock(((FenceBlock) fenceBlock.get()), blockTexture(((CustomFenceBlock)fenceBlock.get()).baseBlock.get()));
        }

        for(RegistryObject<Block> fenceGateBlock : ModConfig.FENCE_GATE_BLOCKS) {
            fenceGateBlock(((FenceGateBlock) fenceGateBlock.get()), blockTexture(((CustomFenceGateBlock)fenceGateBlock.get()).baseBlock.get()));
        }

        for(RegistryObject<Block> stairBlock : ModConfig.STAIR_BLOCKS) {
            stairsBlock((StairBlock) stairBlock.get(), blockTexture(((CustomStairsBlock)stairBlock.get()).baseBlock.get()));
        }

        for(RegistryObject<Block> slabBlock : ModConfig.SLAB_BLOCKS) {
            CustomSlabBlock slab = (CustomSlabBlock)slabBlock.get();
            slabBlock(slab, blockTexture(slab.baseBlock.get()), blockTexture(slab.doubleSlabBaseBlock.get()));
        }

        for(RegistryObject<Block> buttonBlock : ModConfig.BUTTON_BLOCKS) {
            buttonBlock((ButtonBlock) buttonBlock.get(), blockTexture(((CustomButtonBlock)buttonBlock.get()).baseBlock.get()));
        }

        for(RegistryObject<Block> pressurePlateBlock : ModConfig.PRESSURE_PLATE_BLOCKS) {
            pressurePlateBlock((PressurePlateBlock) pressurePlateBlock.get(), blockTexture(((CustomPressurePlateBlock)pressurePlateBlock.get()).baseBlock.get()));
        }

        for(RegistryObject<Block> wallBlock : ModConfig.WALL_BLOCKS) {
            wallBlock((WallBlock) wallBlock.get(), blockTexture(((CustomWallBlock)wallBlock.get()).baseBlock.get()));
        }
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
