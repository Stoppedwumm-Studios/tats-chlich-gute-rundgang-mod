package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.screens;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.modstorage.QuestStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;


@EventBusSubscriber(modid = tagderofffenentr.MODID, value = Dist.CLIENT)
public class Banner {
    @SubscribeEvent
    public static void renderBanner(RenderGuiLayerEvent.Post event) {
        // We will render after the boss bar layer to ensure our banner is on top
        if (event.getName().equals(VanillaGuiLayers.BOSS_OVERLAY) && QuestStorage.questRunning) {
            Minecraft minecraft = Minecraft.getInstance();
            GuiGraphics guiGraphics = event.getGuiGraphics();
            Font font = minecraft.font;
            
            // Your custom text
            Component bannerText = Component.literal(QuestStorage.currentBannerTextString);

            int screenWidth = minecraft.getWindow().getGuiScaledWidth();
            int screenHeight = minecraft.getWindow().getGuiScaledHeight();

            // --- Banner Positioning and Styling ---
            int bannerHeight = 20;
            int backgroundColor = 0x80000000; // Semi-transparent black
            int textColor = 0xFFFFFF; // White

            // Draw the background rectangle for the banner
            guiGraphics.fill(0, 0, screenWidth, bannerHeight, backgroundColor);

            // Calculate text position to center it within the banner
            int textWidth = font.width(bannerText);
            int textX = (screenWidth - textWidth) / 2;
            int textY = (bannerHeight - font.lineHeight) / 2;

            // Draw the text
            guiGraphics.drawString(font, bannerText, textX, textY, textColor, true);
        }
    }
}
