package de.melanx.morevanillalib.core.modifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import de.melanx.morevanillalib.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class DoubleDropModifier extends LootModifier {


    public static final Codec<DoubleDropModifier> CODEC = RecordCodecBuilder.create(instance -> codecStart(instance).apply(instance, DoubleDropModifier::new));

    public DoubleDropModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);

        if (tool == null) {
            return generatedLoot;
        }

        if (FeatureConfig.DoubleDrop.enabledAll) {
            BlockState state = context.getParamOrNull(LootContextParams.BLOCK_STATE);

            if (state != null) {
                ServerLevel level = context.getLevel();
                if (tool.is(ModTags.Items.DIAMOND_TOOLS)) {
                    if (state.is(Tags.Blocks.ORES_DIAMOND)) {
                        if (FeatureConfig.DoubleDrop.Diamond.enabled && level.random.nextDouble() < FeatureConfig.DoubleDrop.Diamond.chance) {
                            ItemStack drop = new ItemStack(Items.DIAMOND);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (tool.is(ModTags.Items.COAL_TOOLS)) {
                    if (state.is(Tags.Blocks.ORES_COAL)) {
                        if (FeatureConfig.DoubleDrop.Coal.enabled && level.random.nextDouble() < FeatureConfig.DoubleDrop.Coal.chance) {
                            ItemStack drop = new ItemStack(Items.COAL);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (tool.is(ModTags.Items.EMERALD_TOOLS)) {
                    if (state.is(Tags.Blocks.ORES_EMERALD)) {
                        if (FeatureConfig.DoubleDrop.Emerald.enabled && level.random.nextDouble() < FeatureConfig.DoubleDrop.Emerald.chance) {
                            ItemStack drop = new ItemStack(Items.EMERALD);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (tool.is(ModTags.Items.LAPIS_TOOLS)) {
                    if (state.is(Tags.Blocks.ORES_LAPIS)) {
                        if (FeatureConfig.DoubleDrop.Lapis.enabled && level.random.nextDouble() < FeatureConfig.DoubleDrop.Lapis.chance) {
                            int i = level.random.nextInt(3);
                            ItemStack drop = new ItemStack(Items.LAPIS_LAZULI, i);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (tool.is(ModTags.Items.QUARTZ_TOOLS)) {
                    if (state.is(Tags.Blocks.ORES_QUARTZ)) {
                        if (FeatureConfig.DoubleDrop.Quartz.enabled && level.random.nextDouble() < FeatureConfig.DoubleDrop.Quartz.chance) {
                            ItemStack drop = new ItemStack(Items.QUARTZ);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (tool.is(ModTags.Items.REDSTONE_TOOLS)) {
                    if (state.is(Tags.Blocks.ORES_REDSTONE)) {
                        if (FeatureConfig.DoubleDrop.Redstone.enabled && level.random.nextDouble() < FeatureConfig.DoubleDrop.Redstone.chance) {
                            int i = level.random.nextInt(3);
                            ItemStack drop = new ItemStack(Items.REDSTONE, i);
                            generatedLoot.add(drop);
                        }
                    }
                }
            }
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
