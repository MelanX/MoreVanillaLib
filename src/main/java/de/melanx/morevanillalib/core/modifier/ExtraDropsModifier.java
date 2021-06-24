package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.config.FeatureConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

import javax.annotation.Nonnull;
import java.util.List;

public class ExtraDropsModifier extends GlowstoneToolModifier {

    public ExtraDropsModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        ItemStack tool = context.get(LootParameters.TOOL);
        if (tool == null) {
            Entity killer = context.get(LootParameters.KILLER_ENTITY);
            if (killer instanceof LivingEntity) {
                tool = ((LivingEntity) killer).getHeldItemMainhand();
            }
        }
        if (tool != null && tool.getItem() instanceof ToolItem && FeatureConfig.ExtraDrop.enabled && context.getRandom().nextDouble() < FeatureConfig.ExtraDrop.chance) {
            Ingredient repairMaterial = ((ToolItem) tool.getItem()).getTier().getRepairMaterial();
            generatedLoot.add(repairMaterial.getMatchingStacks()[0].copy());
        }

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<ExtraDropsModifier> {

        @Override
        public ExtraDropsModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditions) {
            return new ExtraDropsModifier(conditions);
        }

        @Override
        public JsonObject write(ExtraDropsModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
