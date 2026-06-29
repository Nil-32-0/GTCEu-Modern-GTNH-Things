package nil.gtnhthings;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.minecraft.world.item.CreativeModeTab;

import nil.gtnhthings.machines.Multiblocks;

public class GTNHThingsCreativeTab {
    public static RegistryEntry<CreativeModeTab> MAIN = GTNHThingsRegistration.REGISTRATE.defaultCreativeTab("main",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main", GTNHThingsRegistration.REGISTRATE))
                            .icon(() -> Multiblocks.STEAM_FUSER[0].asStack())
                            .title(GTNHThingsRegistration.REGISTRATE.addLang("itemGroup", GTNHThings.id("main"), "GTNH Things"))
                            .build())
            .register();
}
