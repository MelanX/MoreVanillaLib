package de.melanx.morevanillalib;

import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;
import org.moddingx.libx.config.Group;
import org.moddingx.libx.config.validate.DoubleRange;
import org.moddingx.libx.config.validate.FloatRange;

@RegisterConfig(value = "features")
public class FeatureConfig {

    @Config("Should fiery tools automatically smelt blocks while mining?")
    public static boolean autoSmelt = true;

    @Config("Should glowstone tools always drop 4 glowstone dust when breaking glowstone blocks? (excluded by silk touch)")
    public static boolean glowstoneDrops = true;

    @Group
    public static class ExtraDrop {

        @Config("Should tools drop corresponding materials when being used?")
        public static boolean enabled = true;

        @Config("Chance (1 = 100%, 0 = 0%)")
        @DoubleRange(min = 0)
        public static double chance = 0.0005;
    }

    @Group
    public static class ExtraDamage {

        @Config({"Should some tools deal extra damage against some mobs?",
                "Bone tools -> (Wither) Skeletons",
                "Ender tools -> Enderman and Endermite",
                "Fiery tools -> Magma Cubes",
                "Prismarine tools -> Guardians",
                "Slime tools -> Slime Cubes"})
        public static boolean enabled = true;

        @Config("Value to multiply with dealt damage.")
        @DoubleRange(min = 0, max = 10.0)
        public static double maxMultiplier = 2.5;

        @Config("Chance (1 = 100%, 0 = 0%)")
        @DoubleRange(min = 0, max = 1)
        public static double chance = 0.2;
    }

    @Group
    public static class HeadDrop {

        @Config("Should (wither) skeletons drop their head if killed with bone axe or sword?")
        public static boolean enabled = true;

        @Config("Chance (1 = 100%, 0 = 0%)")
        @DoubleRange(min = 0, max = 1)
        public static double chance = 0.05;
    }

    @Group
    public static class PaperDamage {

        @Config("Should paper tools hurt you when using?")
        public static boolean enabled = true;

        @Config("Chance (1 = 100%, 0 = 0%)")
        @DoubleRange(min = 0, max = 1)
        public static double chance = 0.1;

        @Config("Minimum damage amount. 1 = 0.5 hearts")
        @FloatRange(min = 0)
        public static float minDamage = 0.5F;

        @Config("Maximum damage amount. 5 = 2.5 hearts")
        @FloatRange(min = 0)
        public static float maxDamage = 2.5F;
    }

    @Group
    public static class DoubleDrop {

        @Config({"Should ores drop more materials when mined with corresponding tool?",
                "This is to disable all values. If enabled, you can toggle each resource at you wish.",
                "Example: Coal Ore mined with Coal Pickaxe drops more than 1 coal."})
        public static boolean enabledAll = true;

        @Group
        public static class Diamond {

            @Config
            public static boolean enabled = true;

            @Config("Chance (1 = 100%, 0 = 0%)")
            @DoubleRange(min = 0, max = 1)
            public static double chance = 0.001;
        }

        @Group
        public static class Coal {

            @Config
            public static boolean enabled = true;

            @Config("Chance (1 = 100%, 0 = 0%)")
            @DoubleRange(min = 0, max = 1)
            public static double chance = 0.2;
        }

        @Group
        public static class Emerald {

            @Config
            public static boolean enabled = true;

            @Config("Chance (1 = 100%, 0 = 0%)")
            @DoubleRange(min = 0, max = 1)
            public static double chance = 0.001;
        }

        @Group
        public static class Lapis {

            @Config
            public static boolean enabled = true;

            @Config("Chance (1 = 100%, 0 = 0%)")
            @DoubleRange(min = 0, max = 1)
            public static double chance = 0.2;
        }

        @Group
        public static class Quartz {

            @Config
            public static boolean enabled = true;

            @Config("Chance (1 = 100%, 0 = 0%)")
            @DoubleRange(min = 0, max = 1)
            public static double chance = 0.2;
        }

        @Group
        public static class Redstone {

            @Config
            public static boolean enabled = true;

            @Config("Chance (1 = 100%, 0 = 0%)")
            @DoubleRange(min = 0, max = 1)
            public static double chance = 0.2;
        }
    }
}
