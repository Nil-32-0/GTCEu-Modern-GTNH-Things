package nil.gtnhthings.machines.multiblocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class GTNHSteamParallelMultiblockMachine extends SteamParallelMultiblockMachine {
    private final int tier;
    public int getTier() {
        return tier;
    }

    public GTNHSteamParallelMultiblockMachine(IMachineBlockEntity holder, Object... args) {
        this(holder, 1);
    }

    public GTNHSteamParallelMultiblockMachine(IMachineBlockEntity holder, int tier) {
        super(holder);
        this.tier = tier;
    }

    public static ModifierFunction recipeModifier(MetaMachine machine, GTRecipe recipe) {
        if (!(machine instanceof SteamParallelMultiblockMachine steamMachine)) {
            return RecipeModifier.nullWrongType(GTNHSteamParallelMultiblockMachine.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > GTValues.LV) return ModifierFunction.NULL;

        // Operates at 125% speed, so duration = 0.8 * base
        // EUt = 0.625 * parallels * base EUt, up to max of 32 EUt
        long eut = recipe.getInputEUt().getTotalEU();
        int parallelAmount = ParallelLogic.getParallelAmount(machine, recipe, steamMachine.getMaxParallels());
        double eutMultiplier = (eut * 0.625 * parallelAmount <= 32) ? (0.625 * parallelAmount) : (32 / eut);
        int steamSpeedPenalty = 2;
        if (machine instanceof GTNHSteamParallelMultiblockMachine gtnhMachine) {
            steamSpeedPenalty /= Math.pow(2, gtnhMachine.getTier()-1);
            eutMultiplier *= Math.pow(2, gtnhMachine.getTier()-1);
        }
        return ModifierFunction.builder()
            .inputModifier(ContentModifier.multiplier(parallelAmount))
            .outputModifier(ContentModifier.multiplier(parallelAmount))
            .durationMultiplier(0.8 * steamSpeedPenalty)
            .eutMultiplier(eutMultiplier)
            .parallels(parallelAmount)
            .build();
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        
    }

    public static int[] getTiers() {
        return new int[] {1, 2};
    }

    public static String getSteamPrefix(int tier) {
        return switch(tier) {
            case 1 -> "bronze";
            case 2 -> "steel";
            default -> "bronze";
        };
    }

    public static String getSteamTierName(int tier) {
        return switch(tier) {
            case 1 -> "Bronze";
            case 2 -> "Steel";
            default -> "Bronze";
        };
    }

    public static ResourceLocation getBaseTexture(int tier) {
        return switch(tier) {
            case 1 -> GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks");
            case 2 -> GTCEu.id("block/casings/solid/machine_casing_solid_steel");
            default -> GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks");
        };
    }

    public static Block getCasingBlock(int tier) {
        return switch(tier) {
            case 1 -> GTBlocks.CASING_BRONZE_BRICKS.get();
            case 2 -> GTBlocks.CASING_STEEL_SOLID.get();
            default -> GTBlocks.CASING_BRONZE_BRICKS.get();
        };
    }

    public static Block getGearBlock(int tier) {
        return switch(tier) {
            case 1 -> GTBlocks.CASING_BRONZE_GEARBOX.get();
            case 2 -> GTBlocks.CASING_STEEL_GEARBOX.get();
            default -> GTBlocks.CASING_BRONZE_GEARBOX.get();
        };
    }

    public static Block getPipeBlock(int tier) {
        return switch(tier) {
            case 1 -> GTBlocks.CASING_BRONZE_PIPE.get();
            case 2 -> GTBlocks.CASING_STEEL_PIPE.get();
            default -> GTBlocks.CASING_BRONZE_PIPE.get();
        };
    }

    public static Block getFirebox(int tier) {
        return switch(tier) {
            case 1 -> GTBlocks.FIREBOX_BRONZE.get();
            case 2 -> GTBlocks.FIREBOX_STEEL.get();
            default -> GTBlocks.FIREBOX_BRONZE.get();
        };
    }

    public static Material getMaterial(int tier) {
        return switch(tier) {
            case 1 -> GTMaterials.Bronze;
            case 2 -> GTMaterials.Steel;
            default -> GTMaterials.Bronze;
        };
    }
}
