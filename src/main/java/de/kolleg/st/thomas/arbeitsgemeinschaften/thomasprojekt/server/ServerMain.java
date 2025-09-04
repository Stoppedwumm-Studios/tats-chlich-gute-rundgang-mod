package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.server;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@EventBusSubscriber(modid=tagderofffenentr.MODID, value = Dist.DEDICATED_SERVER)
public class ServerMain {
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        tagderofffenentr.LOGGER.info("Hello from the server side!");
    }

    
}