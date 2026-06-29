package nil.gtnhthings.mixin.multiblocks;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Bronze;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.utils.memoization.GTMemoizer;

import nil.gtnhthings.machines.multiblocks.GTNHSteamParallelMultiblockMachine;

@Mixin(GTMultiMachines.class)
public class RegistrationMixin {
    @Inject(method = "init", at = @At("RETURN"), remap = false)
    private static void init(CallbackInfo info) {
        GTMultiMachines.STEAM_GRINDER.setPatternFactory(GTMemoizer.memoize(() -> FactoryBlockPattern.start()
            .aisle("XXX", "FXF", "FXF", "#X#")
            .aisle("XXX", "X#X", "X#X", "XGX")
            .aisle("XXX", "FSF", "FXF", "#H#")
            .where('S', Predicates.controller(blocks(GTMultiMachines.STEAM_GRINDER.getBlock())))
            .where('#', Predicates.any())
            .where('F', frames(Bronze))
            .where('G', blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
            .where('H', Predicates.abilities(PartAbility.STEAM))
            .where('X', blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(14)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
            .build()
        ));

        GTMultiMachines.STEAM_GRINDER.setRecipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier);
    }
}
