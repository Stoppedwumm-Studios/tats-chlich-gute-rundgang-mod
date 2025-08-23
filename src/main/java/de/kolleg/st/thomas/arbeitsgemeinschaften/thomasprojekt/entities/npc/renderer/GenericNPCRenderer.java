package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.renderer;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc.BaseNPC;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc.model.BaseNPCModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

// This renderer can work for any entity that extends BaseNPC
public class GenericNPCRenderer extends MobRenderer<BaseNPC, BaseNPCModel> {

    private final ResourceLocation texture;

    // We add a ResourceLocation to the constructor
    public GenericNPCRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new BaseNPCModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.texture = texture;
    }

    @Override
    public ResourceLocation getTextureLocation(BaseNPC entity) {
        // Now it returns the texture that was provided when it was created
        return this.texture;
    }
}