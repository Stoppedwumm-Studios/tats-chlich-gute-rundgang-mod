package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt;

// --- CHANGED/ADDED IMPORTS ---
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc.BaseNPC;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.renderer.GenericNPCRenderer; // Use the new generic renderer
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries.Blocks;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries.Entities;
import net.minecraft.resources.ResourceLocation; // Needed for textures
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(tagderofffenentr.MODID)
public class tagderofffenentr {
    public static final String MODID = "tagderofffenentuer";
    public static final Logger LOGGER = LogUtils.getLogger();

    public tagderofffenentr(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        Blocks.register(modEventBus);
        Entities.register(modEventBus); // <-- CHANGED from Entities to ModEntities

        LOGGER.info("Registered Blocks and Items");
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        modEventBus.addListener(this::onEntityAttributeCreation);
        modEventBus.addListener(this::onRegisterRenderers);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // ...
    }

    // --- UPDATED METHOD ---
    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        // Now we register attributes for every NPC defined in ModEntities.
        // They all share the same attributes from BaseNPC.
        event.put(Entities.BT_NPC.get(), BaseNPC.createAttributes().build());
        // Add a line here for any new NPC, for example:
        event.put(Entities.TEACHER_NPC.get(), BaseNPC.createAttributes().build());
    }

    // --- UPDATED METHOD ---
    private void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        // Define the textures for each NPC
        ResourceLocation btTexture = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/bt.png");
        ResourceLocation teacherTexture = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/teacher.png");

        // Register a renderer for our BT NPC, telling it which texture to use
        event.registerEntityRenderer(Entities.BT_NPC.get(),
                context -> new GenericNPCRenderer(context, btTexture));

        // Register a renderer for the Teacher NPC example
        event.registerEntityRenderer(Entities.TEACHER_NPC.get(),
                 context -> new GenericNPCRenderer(context, teacherTexture));
    }
}