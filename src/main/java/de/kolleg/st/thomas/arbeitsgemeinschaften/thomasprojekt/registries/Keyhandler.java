package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.web.BasicBrowser;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import com.cinemamod.mcef.example.ExampleScreen;

@EventBusSubscriber(modid = tagderofffenentr.MODID, value = Dist.CLIENT)
public class Keyhandler {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        // check key presses
        if (Keybind.OPEN_BROWSER.consumeClick()) {
            Minecraft.getInstance().setScreen(new BasicBrowser("https://adventure.kst-vechta.de/"));
        }
    }
}

