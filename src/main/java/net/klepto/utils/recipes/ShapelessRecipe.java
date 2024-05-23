package net.klepto.utils.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.ItemLike;

public class ShapelessRecipe extends Recipe {

    public int count;
    public ItemLike requires;
    public ItemLike unlockedBy;

    public ShapelessRecipe(RecipeCategory recipeCategory, ItemLike result, int count, ItemLike requires, ItemLike unlockedBy) {
        super(recipeCategory, result);

        this.count = count;
        this.requires = requires;
        this.unlockedBy = unlockedBy;
    }
}
