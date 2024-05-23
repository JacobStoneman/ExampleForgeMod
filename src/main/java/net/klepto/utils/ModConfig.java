package net.klepto.utils;

import net.klepto.testmod.block.ModBlocks;
import net.klepto.testmod.item.ModItems;
import net.klepto.utils.recipes.*;
import net.klepto.utils.tags.CustomBlockTag;
import net.klepto.utils.tags.ModTags;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfig {
    //Mod id must match id in gradle properties
    public static final String MOD_ID = "test_mod";

    //Link to the mods blocks register
    public static DeferredRegister<Block> KNOWN_BLOCKS = ModBlocks.BLOCKS;

    ///ITEM/BLOCK GENERATION
    //Generates data for simple items
    public static List<RegistryObject<Item>> SIMPLE_ITEMS = List.of(
            ModItems.SAPPHIRE,
            ModItems.RAW_SAPPHIRE,
            ModItems.METAL_DETECTOR,
            ModItems.PINE_CONE,
            ModItems.STRAWBERRY
    );

    //Generates data for simple blocks
    public static List<RegistryObject<Block>> BLOCK_WITH_ITEM_STATES = List.of(
            ModBlocks.SAPPHIRE_BLOCK,
            ModBlocks.RAW_SAPPHIRE_BLOCK,
            ModBlocks.SAPPHIRE_ORE,
            ModBlocks.SOUND_BLOCK
    );

    ///LOOT TABLES
    //Generates loot tables for blocks that drop self
    public static List<RegistryObject<Block>> BLOCK_DROP_SELF_TABLES = List.of(
            ModBlocks.SAPPHIRE_BLOCK,
            ModBlocks.RAW_SAPPHIRE_BLOCK,
            ModBlocks.SOUND_BLOCK
    );

    //Generates loot tables for ore blocks
    public static List<RegistryObject<Block>> ORE_BLOCK_TABLES = List.of(
            ModBlocks.SAPPHIRE_ORE
    );

    ///TAG GENERATION
    //Generates block tags from defined custom tags
    public static List<CustomBlockTag> BLOCK_TAGS = List.of(
            new CustomBlockTag(BlockTags.NEEDS_IRON_TOOL, List.of(
                    ModBlocks.SAPPHIRE_ORE.get(),
                    ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                    ModBlocks.SAPPHIRE_BLOCK.get()
            )),

            new CustomBlockTag(BlockTags.MINEABLE_WITH_PICKAXE, List.of(
                    ModBlocks.SAPPHIRE_ORE.get(),
                    ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                    ModBlocks.SAPPHIRE_BLOCK.get()
            )),

            new CustomBlockTag(ModTags.Blocks.METAL_DETECTOR_VALUABLES,
                List.of(
                    ModBlocks.SAPPHIRE_ORE.get()
                ),
                List.of(
                    Tags.Blocks.ORES
                )
            )
    );

    ///RECIPE GENERATION
    //Generates recipe data from defined shapeless recipes
    public static List<ShapelessRecipe> SHAPELESS_RECIPES = List.of(
            new ShapelessRecipe(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9, ModBlocks.SAPPHIRE_BLOCK.get(), ModBlocks.SAPPHIRE_BLOCK.get()),
            new ShapelessRecipe(RecipeCategory.MISC, ModItems.RAW_SAPPHIRE.get(), 9, ModBlocks.RAW_SAPPHIRE_BLOCK.get(), ModBlocks.RAW_SAPPHIRE_BLOCK.get())
    );

    //Generates recipe data from defined shaped recipes
    public static List<ShapedRecipe> SHAPED_RECIPES = List.of(
            new ShapedRecipe(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get(), 1, ModItems.SAPPHIRE.get(),
                "SSS",
                "SSS",
                "SSS",
                List.of(
                    new RecipeDefinition('S', ModItems.SAPPHIRE.get())
                )),

            new ShapedRecipe(RecipeCategory.MISC, ModBlocks.RAW_SAPPHIRE_BLOCK.get(), 1, ModItems.RAW_SAPPHIRE.get(),
                    "SSS",
                    "SSS",
                    "SSS",
                    List.of(
                            new RecipeDefinition('S', ModItems.RAW_SAPPHIRE.get())
                    ))
    );

    //Generates recipe data from defined cooking recipes
    public static List<CookingRecipe> COOKING_RECIPES = List.of(
            new CookingRecipe(CookingMethod.BLASTING, List.of(ModItems.RAW_SAPPHIRE.get()), RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire"),
            new CookingRecipe(CookingMethod.SMELTING, List.of(ModItems.RAW_SAPPHIRE.get()), RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire")
    );
}