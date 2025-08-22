package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = tagderofffenentr.MODID, value = Dist.CLIENT)
public class Keybind {
    public static KeyMapping OPEN_BROWSER;

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        OPEN_BROWSER = new KeyMapping(
                "mco.account.privacy.info",   // translation key
                InputConstants.Type.KEYSYM,
                InputConstants.KEY_B,            // default key: B
                "key.categories.gameplay"      // category
        );
        event.register(OPEN_BROWSER);
    }
}
