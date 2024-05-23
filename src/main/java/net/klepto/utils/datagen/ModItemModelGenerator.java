package net.klepto.utils.datagen;

import net.klepto.utils.ModConfig;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelGenerator extends ItemModelProvider {

    public ModItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModConfig.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(RegistryObject<Item> simpleModItem : ModConfig.SIMPLE_ITEMS) {
            simpleItem(simpleModItem);
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                    .texture("layer0", new ResourceLocation(ModConfig.MOD_ID, "item/" + item.getId().getPath()));
    }
}