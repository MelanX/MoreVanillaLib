package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.BlockLootProviderBase;
import io.github.noeppi_noeppi.libx.mod.ModX;
import net.minecraft.data.DataGenerator;

@Datagen
public class LootTableProvider extends BlockLootProviderBase {
    public LootTableProvider(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.drops(ModContent.cleanEndStone, this.item());
    }
}
