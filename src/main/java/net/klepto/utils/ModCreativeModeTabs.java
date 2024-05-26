package net.klepto.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModConfig.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModConfig.CREATIVE_TAB_IMAGE))
                .title(Component.translatable("creativetab.mod_tab"))
                .displayItems((pParameters, pOutput) -> {

                    for(RegistryObject<Item> item : ModConfig.TEXTURED_ITEMS) {
                        pOutput.accept(item.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.BLOCK_WITH_ITEM_STATES) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.DOORS) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.FENCE_BLOCKS) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.FENCE_GATE_BLOCKS) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.SLAB_BLOCKS) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.BUTTON_BLOCKS) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.PRESSURE_PLATE_BLOCKS) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.WALL_BLOCKS) {
                        pOutput.accept(block.get());
                    }

                    for(RegistryObject<Block> block : ModConfig.TRAP_DOORS) {
                        pOutput.accept(block.get());
                    }
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}