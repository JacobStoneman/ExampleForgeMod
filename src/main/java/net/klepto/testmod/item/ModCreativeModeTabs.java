package net.klepto.testmod.item;

import net.klepto.testmod.block.ModBlocks;
import net.klepto.utils.ModConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModConfig.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                .title(Component.translatable("creativetab.test_tab"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.SAPPHIRE.get());
                    pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                    pOutput.accept(ModItems.STRAWBERRY.get());
                    pOutput.accept(ModItems.PINE_CONE.get());
                    pOutput.accept(ModItems.METAL_DETECTOR.get());

                    pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                    pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                    pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                    pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
