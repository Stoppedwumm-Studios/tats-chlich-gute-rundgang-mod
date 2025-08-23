package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc.BTEntity;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc.TeacherEntity;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.tagderofffenentr;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, tagderofffenentr.MODID);

    // Register the "BT" NPC
    public static final Supplier<EntityType<BTEntity>> BT_NPC = ENTITIES.register("bt",
            () -> EntityType.Builder.of(BTEntity::new, MobCategory.MISC)
                    .sized(1.0f, 1.0f)
                    .build("bt"));

    // Register a new "Teacher" NPC
    public static final Supplier<EntityType<TeacherEntity>> TEACHER_NPC = ENTITIES.register("teacher_npc",
            () -> EntityType.Builder.of(TeacherEntity::new, MobCategory.MISC)
                    .sized(0.9f, 1.9f) // Maybe the teacher is a different size
                    .build("teacher_npc"));


    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}