package nil.gtnhthings;

import java.util.function.Consumer;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.data.recipes.FinishedRecipe;
import nil.gtnhthings.data.GTNHThingsRecipes;

@GTAddon
public class GTNHThingsDatagen implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return GTNHThingsRegistration.REGISTRATE;
    }

    @Override
    public void initializeAddon() {
        GTNHThings.LOGGER.info("GTNH Things addon has loaded!");
    }

    @Override
    public String addonModId() {
        return GTNHThings.MODID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        GTNHThingsRecipes.register(provider);
    }
    
}
