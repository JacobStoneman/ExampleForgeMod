package net.klepto.utils.datagen;

import net.klepto.utils.ModConfig;
import net.klepto.utils.custom.blocks.CustomButtonBlock;
import net.klepto.utils.custom.blocks.CustomFenceBlock;
import net.klepto.utils.custom.blocks.CustomWallBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelGenerator extends ItemModelProvider {

    public ModItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModConfig.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(RegistryObject<Item> texturedModItem : ModConfig.TEXTURED_ITEMS) {
            texturedItem(texturedModItem);
        }

        for(RegistryObject<Block> doorBlock : ModConfig.DOORS) {
            texturedBlockItem(doorBlock);
        }

        for(RegistryObject<Block> trapDoorBlock : ModConfig.TRAP_DOORS) {
            trapdoorItem(trapDoorBlock);
        }

        for(RegistryObject<Block> fenceBlock : ModConfig.FENCE_BLOCKS) {
            fenceItem(fenceBlock, ((CustomFenceBlock)fenceBlock.get()).baseBlock);
        }

        for(RegistryObject<Block> fenceGateBlock : ModConfig.FENCE_GATE_BLOCKS) {
            nonCubeSimpleBlockItem(fenceGateBlock);
        }

        for(RegistryObject<Block> buttonBlock : ModConfig.BUTTON_BLOCKS) {
            buttonItem(buttonBlock, ((CustomButtonBlock) buttonBlock.get()).baseBlock);
        }

        for(RegistryObject<Block> stairBlock : ModConfig.STAIR_BLOCKS) {
            nonCubeSimpleBlockItem(stairBlock);
        }

        for(RegistryObject<Block> slabBlock : ModConfig.SLAB_BLOCKS) {
            nonCubeSimpleBlockItem(slabBlock);
        }

        for(RegistryObject<Block> pressurePlateBlock : ModConfig.PRESSURE_PLATE_BLOCKS) {
            nonCubeSimpleBlockItem(pressurePlateBlock);
        }

        for(RegistryObject<Block> wallBlock : ModConfig.WALL_BLOCKS) {
            wallItem(wallBlock, ((CustomWallBlock) wallBlock.get()).baseBlock);
        }
    }

    private ItemModelBuilder texturedItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                    .texture("layer0", new ResourceLocation(ModConfig.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder texturedBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModConfig.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void nonCubeSimpleBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ModConfig.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ModConfig.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ModConfig.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(ModConfig.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}