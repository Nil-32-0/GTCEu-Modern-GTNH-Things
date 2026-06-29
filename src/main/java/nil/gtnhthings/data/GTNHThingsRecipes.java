package nil.gtnhthings.data;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MIXER_RECIPES;

import java.util.function.Consumer;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
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
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_grinder_from_bronze"), Multiblocks.STEEL_STEAM_GRINDER.asStack(), GTMultiMachines.STEAM_GRINDER.asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_grinder_to_bronze"), GTMultiMachines.STEAM_GRINDER.asStack(), Multiblocks.STEEL_STEAM_GRINDER.asStack());

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("bronze_steam_fuser"), Multiblocks.STEAM_FUSER[0].asStack(), 
        "BPB", "FTF", "BLB", 
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.pipeTinyFluid, GTMaterials.Bronze),
        'F', new ItemStack(Blocks.BLAST_FURNACE),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga),
        'L', new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.Bronze)
        );
        
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_fuser_from_bronze"), Multiblocks.STEAM_FUSER[1].asStack(), Multiblocks.STEAM_FUSER[0].asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_fuser_to_bronze"), Multiblocks.STEAM_FUSER[0].asStack(), Multiblocks.STEAM_FUSER[1].asStack());

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("bronze_steam_purifier"), Multiblocks.STEAM_PURIFIER[0].asStack(),
        "BPB", "RTR", "BPB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron),
        'R', new MaterialEntry(TagPrefix.rotor, GTMaterials.Tin),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );
        
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_purifier_from_bronze"), Multiblocks.STEAM_PURIFIER[1].asStack(), Multiblocks.STEAM_PURIFIER[0].asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_purifier_to_bronze"), Multiblocks.STEAM_PURIFIER[0].asStack(), Multiblocks.STEAM_PURIFIER[1].asStack());

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("bronze_steam_blender"), Multiblocks.STEAM_BLENDER[0].asStack(),
        "BGB", "RTR", "BGB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'G', ChemicalHelper.get(TagPrefix.ring, GTNHThingsMaterials.Tumbaga),
        'R', ChemicalHelper.get(TagPrefix.rotor, GTNHThingsMaterials.Tumbaga),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );
        
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_blender_from_bronze"), Multiblocks.STEAM_BLENDER[1].asStack(), Multiblocks.STEAM_BLENDER[0].asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_blender_to_bronze"), Multiblocks.STEAM_BLENDER[0].asStack(), Multiblocks.STEAM_BLENDER[1].asStack());

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("bronze_steam_squasher"), Multiblocks.STEAM_SQUASHER[0].asStack(),
        "BPB", "GTG", "BPB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', CustomTags.PISTONS,
        'G', ChemicalHelper.get(TagPrefix.gear, GTNHThingsMaterials.Tumbaga),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );
        
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_squasher_from_bronze"), Multiblocks.STEAM_SQUASHER[1].asStack(), Multiblocks.STEAM_SQUASHER[0].asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_squasher_to_bronze"), Multiblocks.STEAM_SQUASHER[0].asStack(), Multiblocks.STEAM_SQUASHER[1].asStack());

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("bronze_steam_separator"), Multiblocks.STEAM_SEPARATOR[0].asStack(),
        "BPB", "GTG", "BPB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron),
        'G', ChemicalHelper.get(TagPrefix.gear, GTNHThingsMaterials.Tumbaga),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );
        
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_separator_from_bronze"), Multiblocks.STEAM_SEPARATOR[1].asStack(), Multiblocks.STEAM_SEPARATOR[0].asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_separator_to_bronze"), Multiblocks.STEAM_SEPARATOR[0].asStack(), Multiblocks.STEAM_SEPARATOR[1].asStack());

        VanillaRecipeHelper.addShapedRecipe(provider, GTNHThings.id("bronze_steam_presser"), Multiblocks.STEAM_PRESSER[0].asStack(),
        "BPB", "PAP", "BTB",
        'B', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
        'P', new MaterialEntry(TagPrefix.plate, GTMaterials.WroughtIron),
        'A', new ItemStack(Blocks.ANVIL),
        'T', ChemicalHelper.get(TagPrefix.frameGt, GTNHThingsMaterials.Tumbaga)
        );

        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_presser_from_bronze"), Multiblocks.STEAM_PRESSER[1].asStack(), Multiblocks.STEAM_PRESSER[0].asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider, GTNHThings.id("steel_steam_presser_to_bronze"), Multiblocks.STEAM_PRESSER[0].asStack(), Multiblocks.STEAM_PRESSER[1].asStack());
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
