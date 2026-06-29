package nil.gtnhthings.data;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MIXER_RECIPES;

import java.util.function.Consumer;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import nil.gtnhthings.GTNHThings;
import nil.gtnhthings.machines.Multiblocks;

public class GTNHThingsRecipes {
    
    public static void register(Consumer<FinishedRecipe> provider) {
        registerControllerRecipes(provider);
        registerIngredientRecipes(provider);
        registerMachineRecipes(provider);
    }

    private static void registerControllerRecipes(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("steam_fuser"), Multiblocks.STEAM_FUSER.asStack(), 
        "BPB", "FTF", "BLB", 
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.pipeTinyFluid, GTMaterials.Bronze),
        'F', new ItemStack(Blocks.BLAST_FURNACE),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga),
        'L', new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.Bronze)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("steam_purifier"), Multiblocks.STEAM_PURIFIER.asStack(),
        "BPB", "RTR", "BPB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron),
        'R', new MaterialEntry(TagPrefix.rotor, GTMaterials.Tin),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("steam_blender"), Multiblocks.STEAM_BLENDER.asStack(),
        "BGB", "RTR", "BGB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'G', ChemicalHelper.get(TagPrefix.ring, GTNHThingsMaterials.Tumbaga),
        'R', ChemicalHelper.get(TagPrefix.rotor, GTNHThingsMaterials.Tumbaga),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("steam_squasher"), Multiblocks.STEAM_SQUASHER.asStack(),
        "BPB", "GTG", "BPB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', CustomTags.PISTONS,
        'G', ChemicalHelper.get(TagPrefix.gear, GTNHThingsMaterials.Tumbaga),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("steam_separator"), Multiblocks.STEAM_SEPARATOR.asStack(),
        "BPB", "GTG", "BPB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron),
        'G', ChemicalHelper.get(TagPrefix.gear, GTNHThingsMaterials.Tumbaga),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("steam_presser"), Multiblocks.STEAM_PRESSER.asStack(),
        "BPB", "PAP", "BTB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron),
        'A', new ItemStack(Blocks.ANVIL),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );
    }

    private static void registerIngredientRecipes(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("tumbaga_mix"), ChemicalHelper.get(TagPrefix.dust, GTNHThingsMaterials.TumbagaMix, 1),
        new MaterialEntry(TagPrefix.dust, GTMaterials.Gold), new MaterialEntry(TagPrefix.dust, GTMaterials.Gold), new MaterialEntry(TagPrefix.dust, GTMaterials.Copper)
        );

        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("tumbaga_dust"), ChemicalHelper.get(TagPrefix.dust, GTNHThingsMaterials.Tumbaga, 10),
        ChemicalHelper.get(TagPrefix.dust, GTNHThingsMaterials.TumbagaMix), ChemicalHelper.get(TagPrefix.dust, GTNHThingsMaterials.TumbagaMix), ChemicalHelper.get(TagPrefix.dust, GTNHThingsMaterials.TumbagaMix), 
        new MaterialEntry(TagPrefix.dust, GTMaterials.Gold));
    }

    private static void registerMachineRecipes(Consumer<FinishedRecipe> provider) {
        MIXER_RECIPES.recipeBuilder(GTNHThings.id("tumbaga_dust"))
            .inputItems(new MaterialEntry(TagPrefix.dust, GTMaterials.Gold), 7)
            .inputItems(new MaterialEntry(TagPrefix.dust, GTMaterials.Copper), 3)
            .circuitMeta(12)
            .outputItems(ChemicalHelper.get(TagPrefix.dust, GTNHThingsMaterials.Tumbaga, 10))
            .EUt(GTValues.VA[GTValues.LV]).duration(258)
            .save(provider);
    }
}
