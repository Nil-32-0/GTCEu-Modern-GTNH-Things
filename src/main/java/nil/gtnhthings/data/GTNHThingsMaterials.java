package nil.gtnhthings.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import nil.gtnhthings.GTNHThings;

public class GTNHThingsMaterials {
    public static void init() {}

    public static Material TumbagaMix = new Material.Builder(GTNHThings.id("tumbaga_mix"))
        .dust()
        .components(GTMaterials.Gold, 2, GTMaterials.Copper, 1)
        .color(0xF7914D).iconSet(MaterialIconSet.DULL)
        .buildAndRegister();

    public static Material Tumbaga = new Material.Builder(GTNHThings.id("tumbaga"))
        .ingot()
        .components(GTMaterials.Gold, 7, GTMaterials.Copper, 3)
        .color(0xF0A70D).iconSet(MaterialIconSet.SHINY)
        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_FRAME)
        .buildAndRegister();
}
