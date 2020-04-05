package de.melanx.morevanillalib;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class LibConfigHandler {

    public static final ForgeConfigSpec SERVER_CONFIG;
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

    static {
        init(SERVER_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
    }

    public static ForgeConfigSpec.IntValue extraDropChance;
    public static ForgeConfigSpec.IntValue extraDamageChance;
    public static ForgeConfigSpec.IntValue headDropChance;
    public static ForgeConfigSpec.IntValue damageByPaperToolsChance;

    public static ForgeConfigSpec.IntValue diamondDoubleDropChance;
    public static ForgeConfigSpec.IntValue coalDoubleDropChance;
    public static ForgeConfigSpec.IntValue emeraldDoubleDropChance;
    public static ForgeConfigSpec.IntValue lapisDoubleDropChance;
    public static ForgeConfigSpec.IntValue quartzDoubleDropChance;
    public static ForgeConfigSpec.IntValue redstoneDoubleDropChance;

    public static ForgeConfigSpec.BooleanValue extraDrop;
    public static ForgeConfigSpec.BooleanValue doubleDrop;
    public static ForgeConfigSpec.BooleanValue extraDamage;
    public static ForgeConfigSpec.BooleanValue headDrop;
    public static ForgeConfigSpec.BooleanValue damageByPaperTools;
    public static ForgeConfigSpec.BooleanValue autoSmelt;

    public static ForgeConfigSpec.BooleanValue diamondDoubleDrop;
    public static ForgeConfigSpec.BooleanValue coalDoubleDrop;
    public static ForgeConfigSpec.BooleanValue emeraldDoubleDrop;
    public static ForgeConfigSpec.BooleanValue lapisDoubleDrop;
    public static ForgeConfigSpec.BooleanValue quartzDoubleDrop;
    public static ForgeConfigSpec.BooleanValue redstoneDoubleDrop;

    public static ForgeConfigSpec.IntValue minPaperDamage;
    public static ForgeConfigSpec.IntValue maxPaperDamage;

    public static ForgeConfigSpec.IntValue boneDurability;
    public static ForgeConfigSpec.IntValue coalDurability;
    public static ForgeConfigSpec.IntValue emeraldDurability;
    public static ForgeConfigSpec.IntValue enderDurability;
    public static ForgeConfigSpec.IntValue fieryDurability;
    public static ForgeConfigSpec.IntValue glowstoneDurability;
    public static ForgeConfigSpec.IntValue lapisDurability;
    public static ForgeConfigSpec.IntValue netherDurability;
    public static ForgeConfigSpec.IntValue obsidianDurability;
    public static ForgeConfigSpec.IntValue paperDurability;
    public static ForgeConfigSpec.IntValue prismarineDurability;
    public static ForgeConfigSpec.IntValue quartzDurability;
    public static ForgeConfigSpec.IntValue redstoneDurability;
    public static ForgeConfigSpec.IntValue slimeDurability;

    public static ForgeConfigSpec.IntValue woodHarvestlevel;
    public static ForgeConfigSpec.IntValue stoneHarvestlevel;
    public static ForgeConfigSpec.IntValue ironHarvestlevel;
    public static ForgeConfigSpec.IntValue goldHarvestlevel;
    public static ForgeConfigSpec.IntValue diamondHarvestlevel;
    public static ForgeConfigSpec.IntValue boneHarvestlevel;
    public static ForgeConfigSpec.IntValue coalHarvestlevel;
    public static ForgeConfigSpec.IntValue emeraldHarvestlevel;
    public static ForgeConfigSpec.IntValue enderHarvestlevel;
    public static ForgeConfigSpec.IntValue fieryHarvestlevel;
    public static ForgeConfigSpec.IntValue glowstoneHarvestlevel;
    public static ForgeConfigSpec.IntValue lapisHarvestlevel;
    public static ForgeConfigSpec.IntValue netherHarvestlevel;
    public static ForgeConfigSpec.IntValue obsidianHarvestlevel;
    public static ForgeConfigSpec.IntValue paperHarvestlevel;
    public static ForgeConfigSpec.IntValue prismarineHarvestlevel;
    public static ForgeConfigSpec.IntValue quartzHarvestlevel;
    public static ForgeConfigSpec.IntValue redstoneHarvestlevel;
    public static ForgeConfigSpec.IntValue slimeHarvestlevel;

    public static ForgeConfigSpec.DoubleValue woodMiningSpeed;
    public static ForgeConfigSpec.DoubleValue stoneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue ironMiningSpeed;
    public static ForgeConfigSpec.DoubleValue goldMiningSpeed;
    public static ForgeConfigSpec.DoubleValue diamondMiningSpeed;
    public static ForgeConfigSpec.DoubleValue boneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue coalMiningSpeed;
    public static ForgeConfigSpec.DoubleValue emeraldMiningSpeed;
    public static ForgeConfigSpec.DoubleValue enderMiningSpeed;
    public static ForgeConfigSpec.DoubleValue fieryMiningSpeed;
    public static ForgeConfigSpec.DoubleValue glowstoneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue lapisMiningSpeed;
    public static ForgeConfigSpec.DoubleValue netherMiningSpeed;
    public static ForgeConfigSpec.DoubleValue obsidianMiningSpeed;
    public static ForgeConfigSpec.DoubleValue paperMiningSpeed;
    public static ForgeConfigSpec.DoubleValue prismarineMiningSpeed;
    public static ForgeConfigSpec.DoubleValue quartzMiningSpeed;
    public static ForgeConfigSpec.DoubleValue redstoneMiningSpeed;
    public static ForgeConfigSpec.DoubleValue slimeMiningSpeed;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("features");
        extraDrop = builder.comment("If set true, tools may drop an item when they'll be used.")
                .define("extraDrop", true);
        doubleDrop = builder.comment("If set to true the corresponding ore of the tool drops an additional resource.")
                .define("doubleDrop", true);
        extraDamage = builder.comment("If set true, bone axe and sword make extra damage against special mobs.")
                .define("extraDamage", true);
        headDrop = builder.comment("If set true, (wither) skeletons will drop their head with a defined chance if killed with bone axe or sword.")
                .define("headDrop", true);
        damageByPaperTools = builder.comment("If set to true paper tools may hurt you.")
                .define("damageByPaperTools", true);
        autoSmelt = builder.comment("If set true, using Fiery tools to mine blocks will smelt them.")
                .define("autoSmelt", true);

            builder.push("doubleDropBool");
            diamondDoubleDrop = builder.comment("Diamond available for hammers/excavators").define("diamond",true);
            coalDoubleDrop = builder.define("coal", true);
            emeraldDoubleDrop = builder.define("emerald", true);
            lapisDoubleDrop = builder.define("lapis", true);
            quartzDoubleDrop = builder.define("quartz", true);
            redstoneDoubleDrop = builder.define("redstone", true);
            builder.pop();

        builder.pop();

        builder.push("chances");
            builder.push("extraDropValue");
            extraDropChance = builder.comment("Sets the chance of an extra drop when using a tool. [Default 5 = 0.5%]")
                    .defineInRange("extraDrop", 5, 0, 1000);
            extraDamageChance = builder.comment("Sets the chance of extra damage when using bone axe or sword on a (wither) skeleton. [Default 200 = 20%]")
                    .defineInRange("extraDamage", 200, 0, 1000);
            headDropChance = builder.comment("Sets the chance of an head drop when using bone axe or sword. [Default 50 = 5%]")
                    .defineInRange("headDrop", 50, 0, 1000);
            damageByPaperToolsChance = builder.comment("Sets the chance to take an half heart damage if using paper tools. [Default 100 = 10%]")
                    .defineInRange("damageByPaperTools", 100, 0, Integer.MAX_VALUE);
            builder.pop();

            builder.push("doubleDropValue").comment("The chance for dropping an additional resource of their corresponding ore. [Default 500 = 50%]");
            diamondDoubleDropChance = builder.comment("Default 1 = 0.1%").defineInRange("diamond", 1, 0, 1000);
            coalDoubleDropChance = builder.defineInRange("coal", 500, 0, 1000);
            emeraldDoubleDropChance = builder.comment("Default 1 = 0.1%").defineInRange("emerald", 1, 0, 1000);
            lapisDoubleDropChance = builder.defineInRange("lapis", 500, 0, 1000);
            quartzDoubleDropChance = builder.defineInRange("quartz", 500, 0, 1000);
            redstoneDoubleDropChance = builder.defineInRange("redstone", 500, 0, 1000);
            builder.pop();
        builder.pop();

        builder.push("amounts");
        minPaperDamage = builder.comment("The minimum amount of damage. Default: 1 = 0.5 hearts")
                .defineInRange("minPaperDamage", 1, 0, Integer.MAX_VALUE);
        maxPaperDamage = builder.comment("The maximum amount of damage. Default: 5 = 2.5 hearts")
                .defineInRange("maxPaperDamage", 5, 0, Integer.MAX_VALUE);

            builder.push("harvestlevels").comment("The harvestlevel of the tools (0 = wood; 1 = stone; 2 = iron; 3 = diamond; 4 = higher)");
            woodHarvestlevel = builder.defineInRange("wood", 0, 0, 4);
            stoneHarvestlevel = builder.defineInRange("stone", 1, 0, 4);
            ironHarvestlevel = builder.defineInRange("iron", 2, 0, 4);
            goldHarvestlevel = builder.defineInRange("gold", 0, 0, 4);
            diamondHarvestlevel = builder.defineInRange("diamond", 3, 0, 4);
            boneHarvestlevel = builder.defineInRange("bone", 1, 0, 4);
            coalHarvestlevel = builder.defineInRange("coal", 1, 0, 4);
            emeraldHarvestlevel = builder.defineInRange("emerald", 3, 0, 4);
            enderHarvestlevel = builder.defineInRange("ender", 3, 0, 4);
            fieryHarvestlevel = builder.defineInRange("fiery", 3, 0, 4);
            glowstoneHarvestlevel = builder.defineInRange("glowstone", 2, 0, 4);
            lapisHarvestlevel = builder.defineInRange("lapis", 2, 0, 4);
            netherHarvestlevel = builder.defineInRange("nether", 1, 0, 4);
            obsidianHarvestlevel = builder.defineInRange("obsidian", 4, 0, 4);
            paperHarvestlevel = builder.defineInRange("paper", 0, 0, 4);
            prismarineHarvestlevel = builder.defineInRange("prismarine", 3, 0, 4);
            quartzHarvestlevel = builder.defineInRange("quartz", 2, 0, 4);
            redstoneHarvestlevel = builder.defineInRange("redstone", 2, 0, 4);
            slimeHarvestlevel = builder.defineInRange("slime", 2, 0, 4);
            builder.pop();

            builder.push("durabilities").comment("The durability of the tools");
            boneDurability = builder.defineInRange("bone", 206, 1, Integer.MAX_VALUE);
            coalDurability = builder.defineInRange("coal", 155, 1, Integer.MAX_VALUE);
            emeraldDurability = builder.defineInRange("emerald", 1859, 1, Integer.MAX_VALUE);
            enderDurability = builder.defineInRange("ender", 1859, 1, Integer.MAX_VALUE);
            fieryDurability = builder.defineInRange("fiery", 750, 1, Integer.MAX_VALUE);
            glowstoneDurability = builder.defineInRange("glowstone", 193, 1, Integer.MAX_VALUE);
            lapisDurability = builder.defineInRange("lapis", 193, 1, Integer.MAX_VALUE);
            netherDurability = builder.defineInRange("nether", 280, 1, Integer.MAX_VALUE);
            obsidianDurability = builder.defineInRange("obsidian", 1337 * 2, 1, Integer.MAX_VALUE);
            paperDurability = builder.defineInRange("paper", 13, 1, Integer.MAX_VALUE);
            prismarineDurability = builder.defineInRange("prismarine", 750, 1, Integer.MAX_VALUE);
            quartzDurability = builder.defineInRange("quartz", 155, 1, Integer.MAX_VALUE);
            redstoneDurability = builder.defineInRange("redstone", 193, 1, Integer.MAX_VALUE);
            slimeDurability = builder.defineInRange("slime", 1500, 1, Integer.MAX_VALUE);
            builder.pop();

            builder.push("miningspeed").comment("The mining speed of the tools. Will be devided by 3.5 for hammers/excavators.");
            woodMiningSpeed = builder.defineInRange("wood", 2.0, 0, Integer.MAX_VALUE);
            stoneMiningSpeed = builder.defineInRange("stone", 4.0, 0, Integer.MAX_VALUE);
            ironMiningSpeed = builder.defineInRange("iron", 6.0, 0, Integer.MAX_VALUE);
            goldMiningSpeed = builder.defineInRange("gold", 11.0, 0, Integer.MAX_VALUE);
            diamondMiningSpeed = builder.defineInRange("diamond", 8.0, 0, Integer.MAX_VALUE);
            boneMiningSpeed = builder.defineInRange("bone", 4.9, 0, Integer.MAX_VALUE);
            coalMiningSpeed = builder.defineInRange("coal", 4.9, 0, Integer.MAX_VALUE);
            emeraldMiningSpeed = builder.defineInRange("emerald", 8.2, 0, Integer.MAX_VALUE);
            enderMiningSpeed = builder.defineInRange("ender", 5.7, 0, Integer.MAX_VALUE);
            fieryMiningSpeed = builder.defineInRange("fiery", 7.0, 0, Integer.MAX_VALUE);
            glowstoneMiningSpeed = builder.defineInRange("glowstone", 5.0, 0, Integer.MAX_VALUE);
            lapisMiningSpeed = builder.defineInRange("lapis", 6.2, 0, Integer.MAX_VALUE);
            netherMiningSpeed = builder.defineInRange("nether", 4.9, 0, Integer.MAX_VALUE);
            obsidianMiningSpeed = builder.defineInRange("obsidian", 8.2, 0, Integer.MAX_VALUE);
            paperMiningSpeed = builder.defineInRange("paper", 1.8, 0, Integer.MAX_VALUE);
            prismarineMiningSpeed = builder.defineInRange("prismarine", 7.0, 0, Integer.MAX_VALUE);
            quartzMiningSpeed = builder.defineInRange("quartz", 4.9, 0, Integer.MAX_VALUE);
            redstoneMiningSpeed = builder.defineInRange("redstone", 6.2, 0, Integer.MAX_VALUE);
            slimeMiningSpeed = builder.defineInRange("slime", 6.2, 0, Integer.MAX_VALUE);
            builder.pop();

        builder.pop();

    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        MoreVanillaLib.LOGGER.debug("Loading config file {}", path);

        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

        configData.load();

        spec.setConfig(configData);
    }

}
