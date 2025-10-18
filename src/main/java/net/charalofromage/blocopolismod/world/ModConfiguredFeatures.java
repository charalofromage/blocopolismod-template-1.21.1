package net.charalofromage.blocopolismod.world;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.StrongholdGenerator;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> BRONZE_ORE_KEY = registryKey("bronze_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registryKey("silver_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registryKey("lead_ore_key");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> bronzelist =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.BRONZE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.DEEPSLATE_BRONZE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> silverlist =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.SILVER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> leadlist =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.LEAD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.DEEPSLATE_LEAD_ORE.getDefaultState()));

register(context, SILVER_ORE_KEY, Feature.ORE, new OreFeatureConfig(silverlist, 3));
register(context, LEAD_ORE_KEY, Feature.ORE, new OreFeatureConfig(leadlist, 4));
register(context, BRONZE_ORE_KEY, Feature.ORE, new OreFeatureConfig(bronzelist, 5));

    }



    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name){
     return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BlocopolisMod.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
