package net.charalofromage.blocopolismod.util;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEED_BRONZE_TOOL = createTag("need_bronze_tool");
        public static final TagKey<Block> INCORRECT_FOR_BRONZE_TOOL = createTag("incorrect_for_bronze_tool");

        public static final TagKey<Block> NEED_LEAD_TOOL = createTag("need_lead_tool");
        public static final TagKey<Block> INCORRECT_FOR_LEAD_TOOL = createTag("incorrect_for_lead_tool");

        public static final TagKey<Block> NEED_SILVER_TOOL = createTag("need_silver_tool");
        public static final TagKey<Block> INCORRECT_FOR_SILVER_TOOL = createTag("incorrect_for_silver_tool");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BlocopolisMod.MOD_ID, name));
        }

        public static class Items {

            private static TagKey<Item> createTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(BlocopolisMod.MOD_ID, name));
            }
        }

    }
}
