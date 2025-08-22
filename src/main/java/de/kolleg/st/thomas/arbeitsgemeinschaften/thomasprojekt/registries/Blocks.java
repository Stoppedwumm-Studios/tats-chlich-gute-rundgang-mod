package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.blocks.categories.BuildingBlocks;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Blocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(tagderofffenentr.MODID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(tagderofffenentr.MODID);

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);

        // trigger initialization of sub-classes
        BuildingBlocks.register();
        //DecorationBlocks.register();
        //Ores.register();
    }
}
