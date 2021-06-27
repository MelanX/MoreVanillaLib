package de.melanx.morevanillalib.api;

import com.google.common.collect.ImmutableSet;
import de.melanx.morevanillalib.api.normal.ToolMaterials;
import de.melanx.morevanillalib.api.ranged.BigBreakMaterials;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import de.melanx.morevanillalib.util.ComponentUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseToolItem extends ToolItem {

    protected final IConfigurableTier toolMaterial;

    public BaseToolItem(IConfigurableTier tier, Properties properties) {
        super(0, tier.getAttackSpeed(), tier, ImmutableSet.of(), properties);
        this.toolMaterial = tier;
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        if (this.toolMaterial == BigBreakMaterials.WOODEN) {
            return 400;
        }

        return 0;
    }


    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if (FeatureConfig.vanillaOnly) {
            if (this.toolMaterial.isVanilla() || this.toolMaterial instanceof ToolMaterials) {
                super.fillItemCategory(group, items);
            }
        } else {
            super.fillItemCategory(group, items);
        }
    }

    public IConfigurableTier getToolMaterial() {
        return this.toolMaterial;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.KNOCKBACK && ModTags.Items.SLIME_TOOLS.contains(stack.getItem())) {
            return false;
        }

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World level, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (!this.toolMaterial.isVanilla() && FeatureConfig.vanillaOnly && !(this.toolMaterial instanceof ToolMaterials)) {
            tooltip.add(ComponentUtil.getTooltip("disabled_item").withStyle(TextFormatting.DARK_RED));
        } else {
            if (Screen.hasShiftDown()) {
                tooltip.add(ComponentUtil.getTooltip("durability", this.toolMaterial.getUses()).withStyle(TextFormatting.GRAY));
                tooltip.add(ComponentUtil.getTooltip("harvest_level", this.toolMaterial.getLevel()).withStyle(TextFormatting.GRAY));
                tooltip.add(ComponentUtil.getTooltip("repairing_item", this.toolMaterial.getRepairIngredient().getItems()[0].getItem().getDescription().getString()).withStyle(TextFormatting.GRAY));
            } else {
                tooltip.add(ComponentUtil.getTooltip("more_information").withStyle(TextFormatting.ITALIC, TextFormatting.GRAY));
            }
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
