package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc.model;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc.BaseNPC;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;

// We extend PlayerModel to get a humanoid shape for free.
public class BaseNPCModel extends PlayerModel<BaseNPC> {

    public BaseNPCModel(ModelPart root) {
        super(root, false); // 'false' for the slim "Alex" model, 'true' for "Steve"
    }
}