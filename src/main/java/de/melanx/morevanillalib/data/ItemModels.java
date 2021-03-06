package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.core.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nonnull;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, String modid, ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : Registration.ITEMS.getEntries()) {
            if (item.get() instanceof BlockItem)
                generateBlockItem(item.get());
            else
                generateItem(item.get());
        }
    }

    private void generateBlockItem(Item block) {
        String path = block.getRegistryName().getPath();
        getBuilder(path)
                .parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
    }

    public void generateItem(Item item) {
        String path = item.getRegistryName().getPath();
        getBuilder(path).parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/" + path);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Item Models";
    }
}
