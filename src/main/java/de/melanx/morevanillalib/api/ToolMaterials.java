package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ToolMaterials implements IItemTier {

    BONE(LibConfigHandler.boneDurability.get(), LibConfigHandler.boneMiningSpeed.get(), 2, LibConfigHandler.boneHarvestlevel.get(), 17, () -> Ingredient.fromTag(Tags.Items.BONES), Tags.Items.BONES),
    COAL(LibConfigHandler.coalDurability.get(), LibConfigHandler.coalMiningSpeed.get(), 2, LibConfigHandler.coalHarvestlevel.get(), 17, () -> Ingredient.fromTag(ModTags.Items.GEMS_COAL), ModTags.Items.GEMS_COAL),
    EMERALD(LibConfigHandler.emeraldDurability.get(), LibConfigHandler.emeraldMiningSpeed.get(), 4, LibConfigHandler.emeraldHarvestlevel.get(), 25, () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD), Tags.Items.GEMS_EMERALD),
    ENDER(LibConfigHandler.enderDurability.get(), LibConfigHandler.enderMiningSpeed.get(), 5, LibConfigHandler.enderHarvestlevel.get(), 10, () -> Ingredient.fromTag(Tags.Items.ENDER_PEARLS), Tags.Items.END_STONES),
    FIERY(LibConfigHandler.fieryDurability.get(), LibConfigHandler.fieryMiningSpeed.get(), 2, LibConfigHandler.fieryHarvestlevel.get(), 15, () -> Ingredient.fromTag(ModTags.Items.MAGMA_BLOCK), ModTags.Items.MAGMA_CREAM),
    GLOWSTONE(LibConfigHandler.glowstoneDurability.get(), LibConfigHandler.glowstoneMiningSpeed.get(), 2.5F, LibConfigHandler.glowstoneHarvestlevel.get(), 35, () -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE), Tags.Items.DUSTS_GLOWSTONE),
    LAPIS(LibConfigHandler.lapisDurability.get(), LibConfigHandler.lapisMiningSpeed.get(), 1.5F, LibConfigHandler.lapisHarvestlevel.get(), 20, () -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS), Tags.Items.GEMS_LAPIS),
    NETHER(LibConfigHandler.netherDurability.get(), LibConfigHandler.netherMiningSpeed.get(), 2, LibConfigHandler.netherHarvestlevel.get(), 66, () -> Ingredient.fromTag(ModTags.Items.NETHER_BRICKS), Tags.Items.NETHERRACK),
    OBSIDIAN(LibConfigHandler.obsidianDurability.get(), LibConfigHandler.obsidianMiningSpeed.get(), 2.5F, LibConfigHandler.obsidianHarvestlevel.get(), 15, () -> Ingredient.fromTag(Tags.Items.OBSIDIAN), ModTags.Items.DUSTS_OBSIDIAN),
    PAPER(LibConfigHandler.paperDurability.get(), LibConfigHandler.paperMiningSpeed.get(), 0, LibConfigHandler.paperHarvestlevel.get(), 17, () -> Ingredient.fromTag(ModTags.Items.PAPER), ModTags.Items.PAPER),
    PRISMARINE(LibConfigHandler.prismarineDurability.get(), LibConfigHandler.prismarineMiningSpeed.get(), 3, LibConfigHandler.prismarineHarvestlevel.get(), 20, () -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE), Tags.Items.DUSTS_PRISMARINE),
    QUARTZ(LibConfigHandler.quartzDurability.get(), LibConfigHandler.quartzMiningSpeed.get(), 2, LibConfigHandler.quartzHarvestlevel.get(), 18, () -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ), Tags.Items.GEMS_QUARTZ),
    REDSTONE(LibConfigHandler.redstoneDurability.get(), LibConfigHandler.redstoneMiningSpeed.get(), 1.5F, LibConfigHandler.redstoneHarvestlevel.get(), 20, () -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE), Tags.Items.DUSTS_REDSTONE),
    SLIME(LibConfigHandler.slimeDurability.get(), LibConfigHandler.slimeMiningSpeed.get(), 2, LibConfigHandler.slimeHarvestlevel.get(), 20, () -> Ingredient.fromTag(Tags.Items.SLIMEBALLS), Tags.Items.SLIMEBALLS);

    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final ITag.INamedTag<Item> ingredient;

    ToolMaterials(int durability, double efficiency, float attackDamage, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial, ITag.INamedTag<Item> ingredient) {
        this.durability = durability;
        this.efficiency = (float) efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = ingredient;
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    public ITag.INamedTag<Item> getIngredient() {
        return this.ingredient;
    }

}
