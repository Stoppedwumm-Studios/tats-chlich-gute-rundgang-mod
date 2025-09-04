package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.server.networking.payloads;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record QuestMessage(String questId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<QuestMessage> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(tagderofffenentr.MODID, "quest"));

    public static final StreamCodec<ByteBuf, QuestMessage> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.STRING_UTF8,
        QuestMessage::questId,
        QuestMessage::new
    );
    
    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
