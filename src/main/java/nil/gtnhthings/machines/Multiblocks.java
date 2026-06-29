package nil.gtnhthings.machines;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blockTag;
import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.api.pattern.Predicates.frames;
import java.util.function.BiFunction;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;

import net.minecraftforge.common.Tags.Blocks;
import nil.gtnhthings.GTNHThings;
import nil.gtnhthings.GTNHThingsCreativeTab;
import nil.gtnhthings.GTNHThingsRegistration;
import nil.gtnhthings.machines.multiblocks.GTNHSteamParallelMultiblockMachine;

public class Multiblocks {
    static {
        GTNHThingsRegistration.REGISTRATE.creativeModeTab(() -> GTNHThingsCreativeTab.MAIN);
    }

    public static final MultiblockMachineDefinition[] STEAM_FUSER = registerSteamTieredMultis("steam_fuser", GTNHSteamParallelMultiblockMachine::new,
        (tier, builder) -> builder
            .rotationState(RotationState.ALL)
            .langValue("%s Steam Fuser".formatted(GTNHSteamParallelMultiblockMachine.getSteamTierName(tier)))
            .appearanceBlock(() -> GTNHSteamParallelMultiblockMachine.getCasingBlock(tier))
            .recipeTypes(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "GPG", "XXX")
                .aisle("XXX", "GPG", "XXX")
                .aisle("XXX", "XCX", "XXX")
                .where('P', blocks(GTNHSteamParallelMultiblockMachine.getPipeBlock(tier)))
                .where('C', Predicates.controller(blocks(definition.getBlock())))
                .where('G', blockTag(Blocks.GLASS))
                .where('X', blocks(GTNHSteamParallelMultiblockMachine.getCasingBlock(tier)).setMinGlobalLimited(16)
                    .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                .build())
            .workableCasingModel(GTNHSteamParallelMultiblockMachine.getBaseTexture(tier), 
                GTNHThings.id("block/multiblock/steam_fuser"))
            .register()
        );

    public static final MultiblockMachineDefinition[] STEAM_PURIFIER = registerSteamTieredMultis("steam_purifier", GTNHSteamParallelMultiblockMachine::new,
        (tier, builder) -> builder
            .rotationState(RotationState.ALL)
            .langValue("%s Steam Purifier".formatted(GTNHSteamParallelMultiblockMachine.getSteamTierName(tier)))
            .appearanceBlock(() -> GTNHSteamParallelMultiblockMachine.getCasingBlock(tier))
            .recipeTypes(GTRecipeTypes.ORE_WASHER_RECIPES)
            .recipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                .aisle("####XXXXX", "####XGGGX", "####XGGGX", "#####XXX#", "#########", "#########")
                .aisle("XXX#XBBBX", "XXX#GWWWG", "XXX#G###G", "####X###X", "#########", "#########")
                .aisle("XXX#XBXBX", "XXX#GWPWG", "XXX#G#P#G", "#P##X#P#X", "#P####P##", "#PPPPPP##")
                .aisle("XXX#XBBBX", "XCX#GWWWG", "XXX#G###G", "####X###X", "#########", "#########")
                .aisle("####XXXXX", "####XGGGX", "####XGGGX", "#####XXX#", "#########", "#########")
                .where('#', Predicates.any())
                .where('P', blocks(GTNHSteamParallelMultiblockMachine.getPipeBlock(tier)))
                .where('B', blocks(GTNHSteamParallelMultiblockMachine.getGearBlock(tier)))
                .where('C', Predicates.controller(blocks(definition.getBlock())))
                .where('W', blocks(net.minecraft.world.level.block.Blocks.WATER))
                .where('G', blockTag(Blocks.GLASS))
                .where('X', blocks(GTNHSteamParallelMultiblockMachine.getCasingBlock(tier)).setMinGlobalLimited(55)
                    .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
                .build())
            .workableCasingModel(GTNHSteamParallelMultiblockMachine.getBaseTexture(tier), 
                GTNHThings.id("block/multiblock/steam_purifier"))
            .register()
        );

    public static final MultiblockMachineDefinition[] STEAM_BLENDER = registerSteamTieredMultis("steam_blender", GTNHSteamParallelMultiblockMachine::new,
        (tier, builder) -> builder
            .rotationState(RotationState.ALL)
            .langValue("%s Steam Blender".formatted(GTNHSteamParallelMultiblockMachine.getSteamTierName(tier)))
            .appearanceBlock(() -> GTNHSteamParallelMultiblockMachine.getCasingBlock(tier))
            .recipeTypes(GTRecipeTypes.MIXER_RECIPES)
            .recipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                .aisle("#XXX#", "#XXX#", "##X##", "#####")
                .aisle("XXXXX", "X#F#X", "#####", "##X##")
                .aisle("XXXXX", "XFGFX", "X#P#X", "#XGX#")
                .aisle("XXXXX", "X#F#X", "#####", "##X##")
                .aisle("#XXX#", "#XCX#", "##X##", "#####")
                .where('#', Predicates.any())
                .where('P', blocks(GTNHSteamParallelMultiblockMachine.getPipeBlock(tier)))
                .where('G', blocks(GTNHSteamParallelMultiblockMachine.getGearBlock(tier)))
                .where('F', frames(GTNHSteamParallelMultiblockMachine.getMaterial(tier)))
                .where('C', Predicates.controller(blocks(definition.getBlock())))
                .where('X', blocks(GTNHSteamParallelMultiblockMachine.getCasingBlock(tier)).setMinGlobalLimited(25)
                    .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
                .build())
            .workableCasingModel(GTNHSteamParallelMultiblockMachine.getBaseTexture(tier), 
                GTNHThings.id("block/multiblock/steam_blender"))
            .register()
        );

    public static final MultiblockMachineDefinition[] STEAM_SQUASHER = registerSteamTieredMultis("steam_squasher", GTNHSteamParallelMultiblockMachine::new, 
        (tier, builder) -> builder
            .rotationState(RotationState.ALL)
            .langValue("%s Steam Squasher".formatted(GTNHSteamParallelMultiblockMachine.getSteamTierName(tier)))
            .appearanceBlock(() -> GTNHSteamParallelMultiblockMachine.getCasingBlock(tier))
            .recipeTypes(GTRecipeTypes.COMPRESSOR_RECIPES)
            .recipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "###", "###")
                .aisle("XXX", "III", "III")
                .aisle("XXX", "#P#", "###")
                .aisle("XXX", "#P#", "###")
                .aisle("XXX", "XXX", "XXX")
                .aisle("PPP", "PCP", "PPP")
                .where('#', Predicates.any())
                .where('I', blocks(net.minecraft.world.level.block.Blocks.IRON_BLOCK))
                .where('P', blocks(GTNHSteamParallelMultiblockMachine.getPipeBlock(tier)))
                .where('C', Predicates.controller(blocks(definition.getBlock())))
                .where('X', blocks(GTNHSteamParallelMultiblockMachine.getCasingBlock(tier)).setMinGlobalLimited(14)
                    .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
                .build())
            .workableCasingModel(GTNHSteamParallelMultiblockMachine.getBaseTexture(tier), 
                GTNHThings.id("block/multiblock/steam_squasher"))
            .register()
    );

    public static final MultiblockMachineDefinition[] STEAM_SEPARATOR = registerSteamTieredMultis("steam_separator", GTNHSteamParallelMultiblockMachine::new,
        (tier, builder) -> builder
            .rotationState(RotationState.ALL)
            .langValue("%s Steam Separator".formatted(GTNHSteamParallelMultiblockMachine.getSteamTierName(tier)))
            .appearanceBlock(() -> GTNHSteamParallelMultiblockMachine.getCasingBlock(tier))
            .recipeTypes(GTRecipeTypes.CENTRIFUGE_RECIPES)
            .recipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                .aisle("#XXX#", "#XXX#", "##X##", "#####", "#XXX#")
                .aisle("XXXXX", "XXGXX", "#XPX#", "#XGX#", "XXXXX")
                .aisle("XXXXX", "XGFGX", "XPFPX", "#GFG#", "XXXXX")
                .aisle("XXXXX", "XXGXX", "#XPX#", "#XGX#", "XXXXX")
                .aisle("#XXX#", "#XCX#", "##X##", "#####", "#XXX#")
                .where('#', Predicates.any())
                .where('G', blocks(GTNHSteamParallelMultiblockMachine.getGearBlock(tier)))
                .where('P', blocks(GTNHSteamParallelMultiblockMachine.getPipeBlock(tier)))
                .where('F', blocks(GTNHSteamParallelMultiblockMachine.getFirebox(tier)))
                .where('C', Predicates.controller(blocks(definition.getBlock())))
                .where('X', blocks(GTNHSteamParallelMultiblockMachine.getCasingBlock(tier)).setMinGlobalLimited(60)
                    .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1))
                    .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
                .build())
            .workableCasingModel(GTNHSteamParallelMultiblockMachine.getBaseTexture(tier), 
                GTNHThings.id("block/multiblock/steam_separator"))
            .register()
    );

    public static final MultiblockMachineDefinition[] STEAM_PRESSER = registerSteamTieredMultis("steam_presser", GTNHSteamParallelMultiblockMachine::new, 
        (tier, builder) -> builder
            .rotationState(RotationState.ALL)
            .langValue("%s Steam Presser".formatted(GTNHSteamParallelMultiblockMachine.getSteamTierName(tier)))
            .recipeType(GTRecipeTypes.FORGE_HAMMER_RECIPES)
            .recipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier, true)
            .appearanceBlock(() -> GTNHSteamParallelMultiblockMachine.getCasingBlock(tier))
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("#XXX#", "#####", "#####", "#####", "#####", "#####", "#####")
                    .aisle("XXXXX", "#XXX#", "#####", "#####", "#####", "##X##", "#####")
                    .aisle("XXXXX", "XX#XX", "X###X", "X#I#X", "X#I#X", "XXPXX", "##P##")
                    .aisle("XXXXX", "#XCX#", "#####", "#####", "#####", "##X##", "#####")
                    .aisle("#XXX#", "#####", "#####", "#####", "#####", "#####", "#####")
                    .where('#', Predicates.any())
                    .where('P', blocks(GTNHSteamParallelMultiblockMachine.getPipeBlock(tier)))
                    .where('I', blocks(net.minecraft.world.level.block.Blocks.IRON_BLOCK))
                    .where('C', Predicates.controller(blocks(definition.getBlock())))
                    .where('X', blocks(GTNHSteamParallelMultiblockMachine.getCasingBlock(tier)).setMinGlobalLimited(35)
                        .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                        .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                        .or(Predicates.abilities(PartAbility.STEAM).setPreviewCount(1)))
                    .build())
            .workableCasingModel(GTNHSteamParallelMultiblockMachine.getBaseTexture(tier), 
                GTNHThings.id("block/multiblock/steam_presser"))
            .register()
    );

    public static final MultiblockMachineDefinition STEEL_STEAM_GRINDER = GTNHThingsRegistration.REGISTRATE
        .multiblock("steel_steam_grinder", (holder) -> new GTNHSteamParallelMultiblockMachine(holder, 2))
        .rotationState(RotationState.ALL)
        .recipeType(GTRecipeTypes.MACERATOR_RECIPES)
        .recipeModifier(GTNHSteamParallelMultiblockMachine::recipeModifier, true)
        .appearanceBlock(() -> GTNHSteamParallelMultiblockMachine.getCasingBlock(2))
        .addOutputLimit(ItemRecipeCapability.CAP, 1)
        .pattern(definition -> FactoryBlockPattern.start()
            .aisle("XXX", "FXF", "FXF", "#X#")
            .aisle("XXX", "X#X", "X#X", "XGX")
            .aisle("XXX", "FSF", "FXF", "#H#")
            .where('S', Predicates.controller(blocks(definition.getBlock())))
            .where('#', Predicates.any())
            .where('F', frames(GTNHSteamParallelMultiblockMachine.getMaterial(2)))
            .where('G', blocks(GTNHSteamParallelMultiblockMachine.getGearBlock(2)))
            .where('H', Predicates.abilities(PartAbility.STEAM))
            .where('X', blocks(GTNHSteamParallelMultiblockMachine.getCasingBlock(2)).setMinGlobalLimited(14)
                .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
            .build())
        .workableCasingModel(GTNHSteamParallelMultiblockMachine.getBaseTexture(2), 
            GTCEu.id("block/multiblock/steam_grinder"))
        .register();

    public static void init() {}

    private static MultiblockMachineDefinition[] registerSteamTieredMultis(String name,
        BiFunction<IMachineBlockEntity, Integer, MultiblockControllerMachine> factory,
        BiFunction<Integer, MultiblockMachineBuilder<?, ?>, MultiblockMachineDefinition> builder) {
            int[] tiers = GTNHSteamParallelMultiblockMachine.getTiers();
            MultiblockMachineDefinition[] definitions = new MultiblockMachineDefinition[tiers.length];
            for (int tier : tiers) {
                var register = GTNHThingsRegistration.REGISTRATE
                    .multiblock(GTNHSteamParallelMultiblockMachine.getSteamPrefix(tier) + "_" + name, holder -> factory.apply(holder, tier));
                definitions[tier-1] = builder.apply(tier, register);
            }
            return definitions;
    }
}