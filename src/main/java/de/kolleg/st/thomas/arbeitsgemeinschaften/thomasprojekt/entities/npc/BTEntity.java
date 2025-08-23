package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

// This class represents a specific type of NPC. It's simple because
// all the complex logic is in the BaseNPC class it extends.
public class BTEntity extends BaseNPC {
    public BTEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
}