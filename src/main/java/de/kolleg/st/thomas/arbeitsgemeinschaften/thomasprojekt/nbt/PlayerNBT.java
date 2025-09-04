package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.nbt;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;

/**
 * This class holds the custom quest data for a player.
 * It must implement INBTSerializable to handle saving and loading the data.
 */
public class PlayerNBT implements INBTSerializable<CompoundTag> {

    // A field to store some quest data, for example, the current quest stage.
    private int questStage;

    /**
     * A no-argument constructor is required by the AttachmentType.builder.
     * This initializes the data with default values.
     */
    public PlayerNBT() {
        this.questStage = 0; // Default starting value
    }

    // Getter method to access the quest stage
    public int getQuestStage() {
        return this.questStage;
    }

    // Setter method to modify the quest stage
    public void setQuestStage(int stage) {
        this.questStage = stage;
    }

    /**
     * This method is called when the player data is being saved.
     * The signature now includes a HolderLookup.Provider parameter.
     * @param registries The registry provider (can be ignored for simple data types).
     * @return A CompoundTag containing the serialized data.
     */
    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider registries) {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("quest_stage", this.questStage);
        return nbt;
    }

    /**
     * This method is called when the player data is being loaded.
     * The signature now includes a HolderLookup.Provider parameter.
     * @param registries The registry provider (can be ignored for simple data types).
     * @param nbt The CompoundTag containing the saved data.
     */
    @Override
    public void deserializeNBT(HolderLookup.Provider registries, CompoundTag nbt) {
        this.questStage = nbt.getInt("quest_stage");
    }
}