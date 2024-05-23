package net.klepto.utils.recipes;

import net.minecraft.world.level.ItemLike;

public class RecipeDefinition {
    public Character character;
    public ItemLike itemLike;

    public RecipeDefinition(Character character, ItemLike itemLike) {
        this.character = character;
        this.itemLike = itemLike;
    }
}
