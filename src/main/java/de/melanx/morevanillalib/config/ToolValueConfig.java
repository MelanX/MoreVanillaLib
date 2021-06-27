package de.melanx.morevanillalib.config;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.api.ItemTier;
import de.melanx.morevanillalib.data.ModTags;
import io.github.noeppi_noeppi.libx.config.Config;
import io.github.noeppi_noeppi.libx.config.Group;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public class ToolValueConfig {

    @Group("This is be used by MoreVanillaTools")
    public static class NormalTools {

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier bone = RawToolMaterials.BONE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier coal = RawToolMaterials.COAL.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier emerald = RawToolMaterials.EMERALD.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier ender = RawToolMaterials.ENDER.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier fiery = RawToolMaterials.FIERY.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier glowstone = RawToolMaterials.GLOWSTONE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier lapis = RawToolMaterials.LAPIS.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier nether = RawToolMaterials.NETHER.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier obsidian = RawToolMaterials.OBSIDIAN.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier paper = RawToolMaterials.PAPER.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier prismarine = RawToolMaterials.PRISMARINE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier quartz = RawToolMaterials.QUARTZ.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier redstone = RawToolMaterials.REDSTONE.copy().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier slime = RawToolMaterials.SLIME.copy().build();
    }

    @Group("This is used by Vanilla AIOTs")
    public static class AIOTs {

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier bone = RawToolMaterials.BONE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier coal = RawToolMaterials.COAL.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier emerald = RawToolMaterials.EMERALD.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier ender = RawToolMaterials.ENDER.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier fiery = RawToolMaterials.FIERY.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier glowstone = RawToolMaterials.GLOWSTONE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier lapis = RawToolMaterials.LAPIS.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier nether = RawToolMaterials.NETHER.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier obsidian = RawToolMaterials.OBSIDIAN.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier paper = RawToolMaterials.PAPER.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier prismarine = RawToolMaterials.PRISMARINE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier quartz = RawToolMaterials.QUARTZ.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier redstone = RawToolMaterials.REDSTONE.copy().aiot().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier slime = RawToolMaterials.SLIME.copy().aiot().build();
    }

    @Group("This is used by Vanilla Hammers and Vanilla Excavators")
    public static class RangedTools {

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier bone = RawToolMaterials.BONE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier coal = RawToolMaterials.COAL.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier emerald = RawToolMaterials.EMERALD.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier ender = RawToolMaterials.ENDER.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier fiery = RawToolMaterials.FIERY.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier glowstone = RawToolMaterials.GLOWSTONE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier lapis = RawToolMaterials.LAPIS.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier nether = RawToolMaterials.NETHER.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier obsidian = RawToolMaterials.OBSIDIAN.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier paper = RawToolMaterials.PAPER.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier prismarine = RawToolMaterials.PRISMARINE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier quartz = RawToolMaterials.QUARTZ.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier redstone = RawToolMaterials.REDSTONE.copy().big().build();

        @Config(mapper = "morevanillalib:item_tier")
        public static IConfigurableTier slime = RawToolMaterials.SLIME.copy().big().build();
    }

    private static class RawToolMaterials {

        private static final ItemTier.Builder WOOD = ItemTier.builder()
                .durability(59)
                .speed(2F)
                .attackDamageBonus(3F)
                .attackSpeed(-2.5F)
                .harvestLevel(0)
                .enchantmentValue(15)
                .name("wood")
                .repairIngredient(() -> Ingredient.of(Items.AIR))
                .craftingIngredient(() -> Ingredient.of(Items.AIR));

        private static final ItemTier.Builder STONE = ItemTier.builder()
                .durability(131)
                .speed(4F)
                .attackDamageBonus(4F)
                .attackSpeed(-2.6F)
                .harvestLevel(1)
                .enchantmentValue(5)
                .name("stone")
                .repairIngredient(() -> Ingredient.of(Items.AIR))
                .craftingIngredient(() -> Ingredient.of(Items.AIR));

        private static final ItemTier.Builder IRON = ItemTier.builder()
                .durability(250)
                .speed(6F)
                .attackDamageBonus(5F)
                .attackSpeed(-2.8F)
                .harvestLevel(2)
                .enchantmentValue(14)
                .name("iron")
                .repairIngredient(() -> Ingredient.of(Items.AIR))
                .craftingIngredient(() -> Ingredient.of(Items.AIR));

        private static final ItemTier.Builder GOLD = ItemTier.builder()
                .durability(32)
                .speed(12F)
                .attackDamageBonus(5F)
                .attackSpeed(-2.5F)
                .harvestLevel(0)
                .enchantmentValue(22)
                .name("gold")
                .repairIngredient(() -> Ingredient.of(Items.AIR))
                .craftingIngredient(() -> Ingredient.of(Items.AIR));

        private static final ItemTier.Builder DIAMOND = ItemTier.builder()
                .durability(1561)
                .speed(8F)
                .attackDamageBonus(10F)
                .attackSpeed(-3F)
                .harvestLevel(3)
                .enchantmentValue(10)
                .name("diamond")
                .repairIngredient(() -> Ingredient.of(Items.AIR))
                .craftingIngredient(() -> Ingredient.of(Items.AIR));

        private static final ItemTier.Builder NETHERITE = ItemTier.builder()
                .durability(2031)
                .speed(9F)
                .attackDamageBonus(11F)
                .attackSpeed(-3.5F)
                .harvestLevel(4)
                .enchantmentValue(15).name("netherite").repairIngredient(() -> Ingredient.of(Items.AIR)).craftingIngredient(() -> Ingredient.of(Items.AIR));

        private static final ItemTier.Builder BONE = ItemTier.builder()
                .durability(176)
                .speed(3.9F)
                .attackDamageBonus(4F)
                .attackSpeed(-2F)
                .harvestLevel(0)
                .enchantmentValue(17)
                .name("bone")
                .repairIngredient(() -> Ingredient.of(Tags.Items.BONES))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.BONES));

        private static final ItemTier.Builder COAL = ItemTier.builder()
                .durability(145)
                .speed(3.9F)
                .attackDamageBonus(2F)
                .attackSpeed(-2.6F)
                .harvestLevel(0)
                .enchantmentValue(17)
                .name("coal")
                .repairIngredient(() -> Ingredient.of(Items.COAL))
                .craftingIngredient(() -> Ingredient.of(Items.COAL));

        private static final ItemTier.Builder EMERALD = ItemTier.builder()
                .durability(1171)
                .speed(8.2F)
                .attackDamageBonus(11F)
                .attackSpeed(-3F)
                .harvestLevel(2)
                .enchantmentValue(35)
                .name("emerald")
                .repairIngredient(() -> Ingredient.of(Tags.Items.GEMS_EMERALD))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.GEMS_EMERALD));

        private static final ItemTier.Builder ENDER = ItemTier.builder()
                .durability(666)
                .speed(3.7F)
                .attackDamageBonus(10F)
                .attackSpeed(-3.3F)
                .harvestLevel(2)
                .enchantmentValue(10)
                .name("ender")
                .repairIngredient(() -> Ingredient.of(Tags.Items.ENDER_PEARLS))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.END_STONES));

        private static final ItemTier.Builder FIERY = ItemTier.builder()
                .durability(127)
                .speed(4F)
                .attackDamageBonus(6F)
                .attackSpeed(-2.3F)
                .harvestLevel(1)
                .enchantmentValue(15)
                .name("fiery")
                .repairIngredient(() -> Ingredient.of(Items.MAGMA_BLOCK))
                .craftingIngredient(() -> Ingredient.of(Items.MAGMA_CREAM));

        private static final ItemTier.Builder GLOWSTONE = ItemTier.builder()
                .durability(123)
                .speed(3F)
                .attackDamageBonus(5F)
                .attackSpeed(-2.3F)
                .harvestLevel(1)
                .enchantmentValue(35)
                .name("glowstone")
                .repairIngredient(() -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE));

        private static final ItemTier.Builder LAPIS = ItemTier.builder()
                .durability(173)
                .speed(6.2F)
                .attackDamageBonus(3F)
                .attackSpeed(-2.5F)
                .harvestLevel(2)
                .enchantmentValue(20)
                .name("lapis")
                .repairIngredient(() -> Ingredient.of(Tags.Items.GEMS_LAPIS))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.GEMS_LAPIS));

        private static final ItemTier.Builder NETHER = ItemTier.builder()
                .durability(188)
                .speed(3.9F)
                .attackDamageBonus(4F)
                .attackSpeed(-2.1F)
                .harvestLevel(1)
                .enchantmentValue(66)
                .name("nether")
                .repairIngredient(() -> Ingredient.of(Items.NETHER_BRICKS))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.NETHERRACK));

        private static final ItemTier.Builder OBSIDIAN = ItemTier.builder()
                .durability(1337)
                .speed(4.7F)
                .attackDamageBonus(7F)
                .attackSpeed(-3.5F)
                .harvestLevel(3)
                .enchantmentValue(15)
                .name("obsidian")
                .repairIngredient(() -> Ingredient.of(Tags.Items.OBSIDIAN))
                .craftingIngredient(() -> Ingredient.of(ModTags.Items.DUSTS_OBSIDIAN));

        private static final ItemTier.Builder PAPER = ItemTier.builder()
                .durability(13)
                .speed(1.8F)
                .attackDamageBonus(0F)
                .attackSpeed(-3F)
                .harvestLevel(0)
                .enchantmentValue(17)
                .name("paper")
                .repairIngredient(() -> Ingredient.of(Items.PAPER))
                .craftingIngredient(() -> Ingredient.of(Items.PAPER));

        private static final ItemTier.Builder PRISMARINE = ItemTier.builder()
                .durability(225)
                .speed(6F)
                .attackDamageBonus(6F)
                .attackSpeed(-2.3F)
                .harvestLevel(2)
                .enchantmentValue(20)
                .name("prismarine")
                .repairIngredient(() -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE));

        private static final ItemTier.Builder QUARTZ = ItemTier.builder()
                .durability(117)
                .speed(3.9F)
                .attackDamageBonus(5F)
                .attackSpeed(-2F)
                .harvestLevel(1)
                .enchantmentValue(18)
                .name("quartz")
                .repairIngredient(() -> Ingredient.of(Tags.Items.GEMS_QUARTZ))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.GEMS_QUARTZ));

        private static final ItemTier.Builder REDSTONE = ItemTier.builder()
                .durability(173)
                .speed(6.2F)
                .attackDamageBonus(3F)
                .attackSpeed(-2.5F)
                .harvestLevel(2)
                .enchantmentValue(20)
                .name("redstone")
                .repairIngredient(() -> Ingredient.of(Tags.Items.DUSTS_REDSTONE))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.DUSTS_REDSTONE));

        private static final ItemTier.Builder SLIME = ItemTier.builder()
                .durability(123)
                .speed(5.2F)
                .attackDamageBonus(7F)
                .attackSpeed(-3F)
                .harvestLevel(1)
                .enchantmentValue(20)
                .name("slime")
                .repairIngredient(() -> Ingredient.of(Tags.Items.SLIMEBALLS))
                .craftingIngredient(() -> Ingredient.of(Tags.Items.SLIMEBALLS));
    }
}
