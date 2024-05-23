package net.klepto.utils.tags;


import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class CustomBlockTag {
    public TagKey<Block> tagKey;
    public Block[] blocks = new Block[0];
    public TagKey<Block>[] groups = new TagKey[0];

    public CustomBlockTag(TagKey<Block> blockTag, List<Block> itemTags) {
        this.tagKey = blockTag;
        this.blocks = itemTags.toArray(new Block[0]);
    }

    public CustomBlockTag(TagKey<Block> blockTag, List<Block> itemTags, List<TagKey<Block>> groupTags) {
        this.tagKey = blockTag;
        this.blocks = itemTags.toArray(new Block[0]);
        this.groups = groupTags.toArray(new TagKey[0]);
    }
}
