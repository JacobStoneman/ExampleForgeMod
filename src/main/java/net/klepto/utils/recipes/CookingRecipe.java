package net.klepto.utils.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class CookingRecipe extends Recipe {

    public CookingMethod cookingMethod;
    public List<ItemLike> itemLikes;
    public float xp;
    public int cookingTime;
    public String group;

    public CookingRecipe(CookingMethod cookingType, List<ItemLike> itemLikes, RecipeCategory recipeCategory, ItemLike result, float xp, int cookingTime, String group) {
        super(recipeCategory, result);

        this.cookingMethod = cookingType;
        this.itemLikes = itemLikes;
        this.xp = xp;
        this.cookingTime = cookingTime;
        this.group = group;
    }
}