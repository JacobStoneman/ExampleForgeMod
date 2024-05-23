package net.klepto.utils.datagen;

import net.klepto.utils.ModConfig;
import net.klepto.utils.recipes.CookingRecipe;
import net.klepto.utils.recipes.RecipeDefinition;
import net.klepto.utils.recipes.ShapedRecipe;
import net.klepto.utils.recipes.ShapelessRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public ModRecipeGenerator(PackOutput pOutput) {
        super(pOutput);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        for(CookingRecipe cookingRecipe : ModConfig.COOKING_RECIPES) {
            switch (cookingRecipe.cookingMethod) {
                case BLASTING -> oreBlasting(consumer, cookingRecipe.itemLikes, cookingRecipe.recipeCategory, cookingRecipe.result, cookingRecipe.xp, cookingRecipe.cookingTime, cookingRecipe.group);
                case SMELTING -> oreSmelting(consumer, cookingRecipe.itemLikes, cookingRecipe.recipeCategory, cookingRecipe.result, cookingRecipe.xp, cookingRecipe.cookingTime, cookingRecipe.group);
            }
        }

        for(ShapelessRecipe shapelessRecipe : ModConfig.SHAPELESS_RECIPES) {
            ShapelessRecipeBuilder.shapeless(shapelessRecipe.recipeCategory, shapelessRecipe.result, shapelessRecipe.count)
                    .requires(shapelessRecipe.requires)
                    .unlockedBy(getHasName(shapelessRecipe.unlockedBy), has(shapelessRecipe.unlockedBy))
                    .save(consumer);
        }

        for(ShapedRecipe shapedRecipe : ModConfig.SHAPED_RECIPES) {
            ShapedRecipeBuilder newRecipe = ShapedRecipeBuilder.shaped(shapedRecipe.recipeCategory, shapedRecipe.result).unlockedBy(getHasName(shapedRecipe.unlockedBy), has(shapedRecipe.unlockedBy))
                    .pattern(shapedRecipe.recipeTop)
                    .pattern(shapedRecipe.recipeMiddle)
                    .pattern(shapedRecipe.recipeBottom);

            for(RecipeDefinition definition : shapedRecipe.recipeDefinitions) {
                newRecipe.define(definition.character, definition.itemLike);
            }

            newRecipe.save(consumer);
        }
    }
}