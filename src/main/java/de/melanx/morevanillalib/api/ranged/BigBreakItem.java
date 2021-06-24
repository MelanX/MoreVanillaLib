package de.melanx.morevanillalib.api.ranged;

import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.api.BaseToolItem;
import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

public class BigBreakItem extends BaseToolItem {
    private final IConfigurableTier toolMaterial;
    private final Set<Material> effectiveOnMaterial;

    public BigBreakItem(IConfigurableTier toolMaterial, Set<Material> effectiveOnMaterial, ToolType toolType) {
        super(toolMaterial, new Item.Properties().group(ItemGroup.TOOLS).addToolType(toolType, toolMaterial.getHarvestLevel()));
        this.toolMaterial = toolMaterial;
        this.effectiveOnMaterial = effectiveOnMaterial;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        int radius = 1;
        if (player.isCrouching()) {
            radius = 0;
        }

        float originHardness = world.getBlockState(pos).getBlockHardness(world, pos);

        // only do a 3x3 break if the player's tool is effective on the block they are breaking
        // this makes it so breaking gravel doesn't break nearby stone
        if (player.getHeldItemMainhand().canHarvestBlock(world.getBlockState(pos))) {
            BlockBreaker.breakInRadius(world, player, radius, pos, (breakState) -> {
                double hardness = breakState.getBlockHardness(world, pos);
                boolean isEffective = player.getHeldItemMainhand().canHarvestBlock(breakState);
                boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
                return isEffective && verifyHardness;
            });
        }

        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && state.getBlockHardness(world, pos) != 0.0F) {
            if (this.getToolMaterial() == BigBreakMaterials.PAPER && FeatureConfig.PaperDamage.enabled && world.rand.nextDouble() < FeatureConfig.PaperDamage.chance) {
                ToolUtil.paperDamage(entityLiving);
            }
        }

        return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return effectiveOnMaterial.contains(state.getMaterial()) ? this.efficiency : super.getDestroySpeed(stack, state);
    }

    @Override
    public int getBurnTime(@Nonnull ItemStack stack) {
        if (this.getToolMaterial() == BigBreakMaterials.WOODEN) {
            return 400;
        }

        return 0;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (FeatureConfig.vanillaOnly) {
            if (((BigBreakMaterials) this.getTier()).isVanilla()) {
                addItem(group, items);
            }
        } else {
            addItem(group, items);
        }
    }

    private void addItem(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.TOOLS || group == ItemGroup.SEARCH) {
            ItemStack item = new ItemStack(this);
            items.add(item);
        }
    }

    @Override
    public void addInformation(@Nonnull ItemStack stack, @Nullable World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        if (!this.toolMaterial.isVanilla() && FeatureConfig.vanillaOnly) {
            tooltip.add(new TranslationTextComponent("tooltip." + MoreVanillaLib.getInstance().modid + ".disabled_item").mergeStyle(TextFormatting.DARK_RED));
        } else {
            super.addInformation(stack, world, tooltip, flag);
        }
    }
}