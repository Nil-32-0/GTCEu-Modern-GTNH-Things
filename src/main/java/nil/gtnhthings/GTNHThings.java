package nil.gtnhthings;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nil.gtnhthings.data.GTNHThingsMaterials;
import nil.gtnhthings.machines.Multiblocks;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GTNHThings.MODID)
public class GTNHThings
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gtnhthings";
    public static final Logger LOGGER = LogUtils.getLogger();

    private static final ResourceLocation TEMPLATE_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID, "");
    public static MaterialRegistry MATERIAL_REGISTRY;

    public GTNHThings(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        GTNHThingsRegistration.REGISTRATE.registerRegistrate();

        modEventBus.register(this);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);

        System.out.println("Beginning stuff for GTNHThings");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        Multiblocks.init();
    }

    @SubscribeEvent
    public void registerMaterialsRegistry(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(MODID);
    }
    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        GTNHThingsMaterials.init();
    }

    public static ResourceLocation id(String path) {
        if (path.isBlank()) {
            return TEMPLATE_LOCATION;
        }

        int i = path.indexOf(':');
        if (i > 0) {
            return ResourceLocation.parse(path);
        } else if (i == 0) {
            path = path.substring(i + 1);
        }
        // only convert it to camel_case if it has any uppercase to begin with
        if (FormattingUtil.hasUpperCase(path)) {
            path = FormattingUtil.toLowerCaseUnderscore(path);
        }
        return TEMPLATE_LOCATION.withPath(path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
