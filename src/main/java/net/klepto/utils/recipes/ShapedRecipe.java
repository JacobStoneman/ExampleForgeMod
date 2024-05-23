package net.klepto.utils.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class ShapedRecipe extends Recipe{

    public int count;
    public ItemLike unlockedBy;
    public String recipeTop;
    public String recipeMiddle;
    public String recipeBottom;
    public List<RecipeDefinition> recipeDefinitions; //TODO: Needs to work with other types of definitions

    public ShapedRecipe(RecipeCategory recipeCategory, ItemLike result, int count, ItemLike unlockedBy, String recipeTop, String recipeMiddle, String recipeBottom, List<RecipeDefinition> recipeDefinitions) {
        super(recipeCategory, result);

        this.count = count;
        this.unlockedBy = unlockedBy;
        this.recipeTop = recipeTop;
        this.recipeMiddle = recipeMiddle;
        this.recipeBottom = recipeBottom;
        this.recipeDefinitions = recipeDefinitions;
    }
}
