package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

// This NPC also gets all the same logic from BaseNPC.
public class TeacherEntity extends BaseNPC {
    public TeacherEntity(EntityType<? extends BaseNPC> type, Level level) {
        super(type, level);
    }
}