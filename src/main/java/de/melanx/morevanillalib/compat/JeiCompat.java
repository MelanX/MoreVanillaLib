package de.melanx.morevanillalib.compat;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.api.BigBreakMaterials;
import de.melanx.morevanillalib.data.ModTags;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class JeiCompat implements IModPlugin {
    public static final ResourceLocation PLUGIN_UID = new ResourceLocation(MoreVanillaLib.MODID, "plugin/main");

    private static void addInfoPage(IRecipeRegistration reg, Collection<Item> items, String name) {
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, key);
    }

    public static void addValueInfoPage(IRecipeRegistration reg, Item item, String name, Object... values) {
        Collection<Item> items = Collections.singletonList(item);
        addValueInfoPage(reg, items, name, values);
    }

    private static void addValueInfoPage(IRecipeRegistration reg, Collection<Item> items, String name, Object... values) {
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, I18n.format(key, values));
    }

    private static String getDescKey(ResourceLocation name) {
        return "jei." + name.getNamespace() + "." + name.getPath() + ".desc";
    }

    private static Item getItemFromIngredient(Ingredient ingredient) {
        return ingredient.getMatchingStacks()[0].getItem();
    }

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        addValueInfoPage(registration, ModTags.Items.WOOD_TOOLS.func_230236_b_(), "wood_tools",
                ItemTier.WOOD.getMaxUses(),
                ItemTier.WOOD.getMaxUses() * 5,
                LibConfigHandler.woodHarvestlevel.get(),
                getItemFromIngredient(ItemTier.WOOD.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.STONE_TOOLS.func_230236_b_(), "stone_tools",
                ItemTier.STONE.getMaxUses(),
                ItemTier.STONE.getMaxUses() * 5,
                LibConfigHandler.stoneHarvestlevel.get(),
                getItemFromIngredient(ItemTier.STONE.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.IRON_TOOLS.func_230236_b_(), "iron_tools",
                ItemTier.IRON.getMaxUses(),
                ItemTier.IRON.getMaxUses() * 5,
                LibConfigHandler.ironHarvestlevel.get(),
                getItemFromIngredient(ItemTier.IRON.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.GOLD_TOOLS.func_230236_b_(), "gold_tools",
                ItemTier.GOLD.getMaxUses(),
                ItemTier.GOLD.getMaxUses() * 5,
                LibConfigHandler.goldHarvestlevel.get(),
                getItemFromIngredient(ItemTier.GOLD.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.DIAMOND_TOOLS.func_230236_b_(), "diamond_tools",
                ItemTier.DIAMOND.getMaxUses(),
                ItemTier.DIAMOND.getMaxUses() * 5,
                LibConfigHandler.diamondHarvestlevel.get(),
                getItemFromIngredient(ItemTier.DIAMOND.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.NETHERITE_TOOLS.func_230236_b_(), "netherite_tools",
                ItemTier.NETHERITE.getMaxUses(),
                ItemTier.NETHERITE.getMaxUses() * 5,
                LibConfigHandler.netheriteHarvestlevel.get(),
                getItemFromIngredient(ItemTier.NETHERITE.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.func_230236_b_(), "bone_tools",
                LibConfigHandler.boneDurability.get(),
                LibConfigHandler.boneDurability.get() * 5,
                LibConfigHandler.boneHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.BONE.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.COAL_TOOLS.func_230236_b_(), "coal_tools",
                LibConfigHandler.coalDurability.get(),
                LibConfigHandler.coalDurability.get() * 5,
                LibConfigHandler.coalHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.COAL.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.EMERALD_TOOLS.func_230236_b_(), "emerald_tools",
                LibConfigHandler.emeraldDurability.get(),
                LibConfigHandler.emeraldDurability.get() * 5,
                LibConfigHandler.emeraldHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.EMERALD.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.ENDER_TOOLS.func_230236_b_(), "ender_tools",
                LibConfigHandler.enderDurability.get(),
                LibConfigHandler.enderDurability.get() * 5,
                LibConfigHandler.enderHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.ENDER.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.FIERY_TOOLS.func_230236_b_(), "fiery_tools",
                LibConfigHandler.fieryDurability.get(),
                LibConfigHandler.fieryDurability.get() * 5,
                LibConfigHandler.fieryHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.FIERY.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.GLOWSTONE_TOOLS.func_230236_b_(), "glowstone_tools",
                LibConfigHandler.glowstoneDurability.get(),
                LibConfigHandler.glowstoneDurability.get() * 5,
                LibConfigHandler.glowstoneHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.GLOWSTONE.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.LAPIS_TOOLS.func_230236_b_(), "lapis_tools",
                LibConfigHandler.lapisDurability.get(),
                LibConfigHandler.lapisDurability.get() * 5,
                LibConfigHandler.lapisHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.LAPIS.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.NETHER_TOOLS.func_230236_b_(), "nether_tools",
                LibConfigHandler.netherDurability.get(),
                LibConfigHandler.netherDurability.get() * 5,
                LibConfigHandler.netherHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.NETHER.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.OBSIDIAN_TOOLS.func_230236_b_(), "obsidian_tools",
                LibConfigHandler.obsidianDurability.get(),
                LibConfigHandler.obsidianDurability.get() * 5,
                LibConfigHandler.obsidianHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.OBSIDIAN.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.PAPER_TOOLS.func_230236_b_(), "paper_tools",
                LibConfigHandler.paperDurability.get(),
                LibConfigHandler.paperDurability.get() * 5,
                LibConfigHandler.paperHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.PAPER.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.PRISMARINE_TOOLS.func_230236_b_(), "prismarine_tools",
                LibConfigHandler.prismarineDurability.get(),
                LibConfigHandler.prismarineDurability.get() * 5,
                LibConfigHandler.prismarineHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.PRISMARINE.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.QUARTZ_TOOLS.func_230236_b_(), "quartz_tools",
                LibConfigHandler.quartzDurability.get(),
                LibConfigHandler.quartzDurability.get() * 5,
                LibConfigHandler.quartzHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.QUARTZ.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.REDSTONE_TOOLS.func_230236_b_(), "redstone_tools",
                LibConfigHandler.redstoneDurability.get(),
                LibConfigHandler.redstoneDurability.get() * 5,
                LibConfigHandler.redstoneHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.REDSTONE.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.SLIME_TOOLS.func_230236_b_(), "slime_tools",
                LibConfigHandler.slimeDurability.get(),
                LibConfigHandler.slimeDurability.get() * 5,
                LibConfigHandler.slimeHarvestlevel.get(),
                getItemFromIngredient(BigBreakMaterials.SLIME.getRepairMaterial()).getName().getString());

        if (LibConfigHandler.extraDrop.get())
            addValueInfoPage(registration, ModTags.Items.ALL_TOOLS.func_230236_b_(), "extra_drop", (double) LibConfigHandler.extraDropChance.get() / 10);

        if (LibConfigHandler.extraDamage.get()) {
            double extraDamageChance = (double) LibConfigHandler.extraDamageChance.get() / 10;
            addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.func_230236_b_(), "bone_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.ENDER_TOOLS.func_230236_b_(), "ender_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.FIERY_TOOLS.func_230236_b_(), "fiery_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.PRISMARINE_TOOLS.func_230236_b_(), "prismarine_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.SLIME_TOOLS.func_230236_b_(), "slime_damage", extraDamageChance);
        }

        if (LibConfigHandler.headDrop.get()) {
            addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.func_230236_b_(), "bone_heads",
                    (double) LibConfigHandler.headDropChance.get() / 10);
        }

        if (LibConfigHandler.damageByPaperTools.get()) {
            addValueInfoPage(registration, ModTags.Items.PAPER_TOOLS.func_230236_b_(), "paper_damage",
                    (double) LibConfigHandler.damageByPaperToolsChance.get() / 10,
                    (double) LibConfigHandler.minPaperDamage.get() / 2,
                    (double) LibConfigHandler.maxPaperDamage.get() / 2);
        }

        if (LibConfigHandler.autoSmelt.get()) {
            addInfoPage(registration, ModTags.Items.FIERY_TOOLS.func_230236_b_(), "fiery_smelt");
        }

        if (LibConfigHandler.glowstoneDrops.get()) {
            addInfoPage(registration, ModTags.Items.GLOWSTONE_TOOLS.func_230236_b_(), "glowstone_drops");
        }
    }
}
