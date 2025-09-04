package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.server.networking;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = tagderofffenentr.MODID)
public class NetworkRegistrar {
    @SubscribeEvent
    public static void registerPackets(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
    }
}
