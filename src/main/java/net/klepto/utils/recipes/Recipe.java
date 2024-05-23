package net.klepto.utils.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.ItemLike;

public abstract class Recipe {
    public RecipeCategory recipeCategory;
    public ItemLike result;

    public Recipe(RecipeCategory recipeCategory, ItemLike result) {
        this.recipeCategory = recipeCategory;
        this.result = result;
    }
}