package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries;

import java.util.function.Supplier;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.nbt.PlayerNBT;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DataAttachments {
    // data attachments for the player for quest progress
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, tagderofffenentr.MODID);

    // serialize via INBTSerializable
    private static final Supplier<AttachmentType<PlayerNBT>> HANDLER = ATTACHMENT_TYPES.register(
        "quest_data",
        () -> AttachmentType.builder(() -> new PlayerNBT()).build()
    );

    public static void register(IEventBus bus) {
        ATTACHMENT_TYPES.register(bus);
    }
}