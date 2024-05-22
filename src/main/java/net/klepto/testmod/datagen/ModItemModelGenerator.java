package net.klepto.testmod.datagen;

import net.klepto.testmod.TestMod;
import net.klepto.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelGenerator extends ItemModelProvider {

    public ModItemModelGenerator(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(TestMod.MOD_ID, ModItems.SAPPHIRE);
        simpleItem(TestMod.MOD_ID, ModItems.RAW_SAPPHIRE);
        simpleItem(TestMod.MOD_ID, ModItems.METAL_DETECTOR);
        simpleItem(TestMod.MOD_ID, ModItems.PINE_CONE);
        simpleItem(TestMod.MOD_ID, ModItems.STRAWBERRY);
    }

    private ItemModelBuilder simpleItem(String modId, RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                    .texture("layer0", new ResourceLocation(modId, "item/" + item.getId().getPath()));
    }
}
