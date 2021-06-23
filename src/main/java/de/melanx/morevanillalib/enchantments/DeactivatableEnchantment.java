package de.melanx.morevanillalib.enchantments;

import de.melanx.morevanillalib.config.FeatureConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class DeactivatableEnchantment extends Enchantment {

    protected DeactivatableEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    protected boolean canApplyTogether(@Nonnull Enchantment ench) {
        return FeatureConfig.enchantments && super.canApplyTogether(ench);
    }

    @Override
    public boolean canVillagerTrade() {
        return FeatureConfig.enchantments;
    }

    @Override
    public boolean canGenerateInLoot() {
        return FeatureConfig.enchantments;
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack) {
        return FeatureConfig.enchantments && super.canApplyAtEnchantingTable(stack);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return FeatureConfig.enchantments;
    }
}