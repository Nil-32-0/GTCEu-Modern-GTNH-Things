package nil.gtnhthings.machines;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blockTag;
import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_BRICKS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_GEARBOX;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_PIPE;
import static com.gregtechceu.gtceu.common.data.GTBlocks.FIREBOX_BRONZE;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;

import net.minecraftforge.common.Tags.Blocks;
import nil.gtnhthings.GTNHThings;
import nil.gtnhthings.GTNHThingsCreativeTab;
import nil.gtnhthings.GTNHThingsRegistration;

public class Multiblocks {
    static {
        GTNHThingsRegistration.REGISTRATE.creativeModeTab(() -> GTNHThingsCreativeTab.MAIN);
    }

    public static final MultiblockMachineDefinition STEAM_FUSER = GTNHThingsRegistration.REGISTRATE
        .multiblock("steam_fuser", SteamParallelMultiblockMachine::new)
        .rotationState(RotationState.ALL)
        .appearanceBlock(CASING_BRONZE_BRICKS)
        .recipeTypes(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
        .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
        .addOutputLimit(ItemRecipeCapability.CAP, 1)
        .pattern(definition -> FactoryBlockPattern.start()
            .aisle("XXX", "XXX", "XXX")
            .aisle("XXX", "GPG", "XXX")
            .aisle("XXX", "GPG", "XXX")
            .aisle("XXX", "XCX", "XXX")
            .where('P', blocks(CASING_BRONZE_PIPE.get()))
            .where('C', Predicates.controller(blocks(definition.getBlock())))
            .where('G', blockTag(Blocks.GLASS))
            .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(16)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
            .build())
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), 
            GTNHThings.id("block/multiblock/steam_fuser"))
        .register();

    public static final MultiblockMachineDefinition STEAM_PURIFIER = GTNHThingsRegistration.REGISTRATE
        .multiblock("steam_purifier", SteamParallelMultiblockMachine::new)
        .rotationState(RotationState.ALL)
        .appearanceBlock(CASING_BRONZE_BRICKS)
        .recipeTypes(GTRecipeTypes.ORE_WASHER_RECIPES)
        .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
        .addOutputLimit(ItemRecipeCapability.CAP, 1)
        .pattern(definition -> FactoryBlockPattern.start()
            .aisle("####XXXXX", "####XGGGX", "####XGGGX", "#####XXX#", "#########", "#########")
            .aisle("XXX#XBBBX", "XXX#GWWWG", "XXX#G###G", "####X###X", "#########", "#########")
            .aisle("XXX#XBXBX", "XXX#GWPWG", "XXX#G#P#G", "#P##X#P#X", "#P####P##", "#PPPPPP##")
            .aisle("XXX#XBBBX", "XCX#GWWWG", "XXX#G###G", "####X###X", "#########", "#########")
            .aisle("####XXXXX", "####XGGGX", "####XGGGX", "#####XXX#", "#########", "#########")
            .where('#', Predicates.air())
            .where('P', blocks(CASING_BRONZE_PIPE.get()))
            .where('B', blocks(CASING_BRONZE_GEARBOX.get()))
            .where('C', Predicates.controller(blocks(definition.getBlock())))
            .where('W', blocks(net.minecraft.world.level.block.Blocks.WATER))
            .where('G', blockTag(Blocks.GLASS))
            .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(55)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
            .build())
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), 
            GTNHThings.id("block/multiblock/steam_purifier"))
        .register();

    public static final MultiblockMachineDefinition STEAM_BLENDER = GTNHThingsRegistration.REGISTRATE
        .multiblock("steam_blender", SteamParallelMultiblockMachine::new)
        .rotationState(RotationState.ALL)
        .appearanceBlock(CASING_BRONZE_BRICKS)
        .recipeTypes(GTRecipeTypes.MIXER_RECIPES)
        .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
        .addOutputLimit(ItemRecipeCapability.CAP, 1)
        .pattern(definition -> FactoryBlockPattern.start()
            .aisle("#XXX#", "#XXX#", "##X##", "#####")
            .aisle("XXXXX", "X#F#X", "#####", "##X##")
            .aisle("XXXXX", "XFGFX", "X#P#X", "#XGX#")
            .aisle("XXXXX", "X#F#X", "#####", "##X##")
            .aisle("#XXX#", "#XCX#", "##X##", "#####")
            .where('#', Predicates.air())
            .where('P', blocks(CASING_BRONZE_PIPE.get()))
            .where('G', blocks(CASING_BRONZE_GEARBOX.get()))
            .where('F', frames(GTMaterials.Bronze))
            .where('C', Predicates.controller(blocks(definition.getBlock())))
            .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(25)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
            .build())
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), 
            GTNHThings.id("block/multiblock/steam_blender"))
        .register();

    public static final MultiblockMachineDefinition STEAM_SQUASHER = GTNHThingsRegistration.REGISTRATE
        .multiblock("steam_squasher", SteamParallelMultiblockMachine::new)
        .rotationState(RotationState.ALL)
        .appearanceBlock(CASING_BRONZE_BRICKS)
        .recipeTypes(GTRecipeTypes.COMPRESSOR_RECIPES)
        .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
        .addOutputLimit(ItemRecipeCapability.CAP, 1)
        .pattern(definition -> FactoryBlockPattern.start()
            .aisle("XXX", "XXX", "XXX")
            .aisle("XXX", "###", "###")
            .aisle("XXX", "III", "III")
            .aisle("XXX", "#P#", "###")
            .aisle("XXX", "#P#", "###")
            .aisle("XXX", "XXX", "XXX")
            .aisle("PPP", "PCP", "PPP")
            .where('#', Predicates.air())
            .where('I', blocks(net.minecraft.world.level.block.Blocks.IRON_BLOCK))
            .where('P', blocks(CASING_BRONZE_PIPE.get()))
            .where('C', Predicates.controller(blocks(definition.getBlock())))
            .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(14)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
            .build())
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), 
            GTNHThings.id("block/multiblock/steam_squasher"))
        .register();

    public static final MultiblockMachineDefinition STEAM_SEPARATOR = GTNHThingsRegistration.REGISTRATE
        .multiblock("steam_separator", SteamParallelMultiblockMachine::new)
        .rotationState(RotationState.ALL)
        .appearanceBlock(CASING_BRONZE_BRICKS)
        .recipeTypes(GTRecipeTypes.CENTRIFUGE_RECIPES)
        .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
        .addOutputLimit(ItemRecipeCapability.CAP, 1)
        .pattern(definition -> FactoryBlockPattern.start()
            .aisle("#XXX#", "#XXX#", "##X##", "#####", "#XXX#")
            .aisle("XXXXX", "XXGXX", "#XPX#", "#XGX#", "XXXXX")
            .aisle("XXXXX", "XGFGX", "XPFPX", "#GFG#", "XXXXX")
            .aisle("XXXXX", "XXGXX", "#XPX#", "#XGX#", "XXXXX")
            .aisle("#XXX#", "#XCX#", "##X##", "#####", "#XXX#")
            .where('#', Predicates.air())
            .where('G', blocks(CASING_BRONZE_GEARBOX.get()))
            .where('P', blocks(CASING_BRONZE_PIPE.get()))
            .where('F', blocks(FIREBOX_BRONZE.get()))
            .where('C', Predicates.controller(blocks(definition.getBlock())))
            .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(60)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
            .build())
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), 
            GTNHThings.id("block/multiblock/steam_separator"))
        .register();

    public static final MultiblockMachineDefinition STEAM_PRESSER = GTNHThingsRegistration.REGISTRATE
        .multiblock("steam_presser", SteamParallelMultiblockMachine::new)
        .rotationState(RotationState.ALL)
        .appearanceBlock(CASING_BRONZE_BRICKS)
        .recipeTypes(GTRecipeTypes.FORGE_HAMMER_RECIPES)
        .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
        .addOutputLimit(ItemRecipeCapability.CAP, 1)
        .pattern(definition -> FactoryBlockPattern.start()
            .aisle("#XXX#", "#####", "#####", "#####", "#####", "#####", "#####")
            .aisle("XXXXX", "#XXX#", "#####", "#####", "#####", "##X##", "#####")
            .aisle("XXXXX", "XX#XX", "X###X", "X#I#X", "X#I#X", "XXPXX", "##P##")
            .aisle("XXXXX", "#XCX#", "#####", "#####", "#####", "##X##", "#####")
            .aisle("#XXX#", "#####", "#####", "#####", "#####", "#####", "#####")
            .where('#', Predicates.air())
            .where('P', blocks(CASING_BRONZE_PIPE.get()))
            .where('I', blocks(net.minecraft.world.level.block.Blocks.IRON_BLOCK))
            .where('C', Predicates.controller(blocks(definition.getBlock())))
            .where('X', blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(35)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
            .build())
        .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), 
            GTNHThings.id("block/multiblock/steam_presser"))
        .register();

    public static void init() {

    }
}