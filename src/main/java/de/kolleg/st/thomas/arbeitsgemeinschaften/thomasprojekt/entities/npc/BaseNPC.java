package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.entities.npc;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.modstorage.QuestStorage;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.web.BasicBrowser;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;

public class BaseNPC extends PathfinderMob {

    public BaseNPC(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        // Make the NPC immune to gravity (falling) and water pushing
        this.setNoGravity(true);
    }

    /**
     * Defines the attributes for the NPC, such as health and speed.
     * Required for any mob.
     */
    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    /**
     * Registers the AI goals for the NPC.
     * Lower priority numbers are executed first.
     */
    @Override
    protected void registerGoals() {
        super.registerGoals();
        // Priority 8: Look at players within 8 blocks
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        // Priority 9: Look around randomly when idle
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
    }

    /**
     * Handles all incoming damage.
     * Allows damage only from /kill or a player in creative mode.
     */
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if ((source.getEntity() instanceof Player player && player.isCreative()) || source.getMsgId().equals("genericKill")) {
            return super.hurt(source, amount);
        }
        return false;
    }

    /**
     * Handles right-click interactions from players.
     */
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        // Logic should only run on the server side to prevent bugs.
        if (this.level().isClientSide()) {
            // Send a simple message to the player who clicked.
            // You can expand this logic with 'instanceof' checks for different NPC types.
            if (this instanceof BTEntity) {
                Minecraft.getInstance().setScreen(new BasicBrowser("https://hallo.kst-vechta.de"));
            }

            if (this instanceof TeacherEntity) {
                player.sendSystemMessage(Component.literal("<Herr xyz> Hallo, ich bin ein Lehrer!"));
                player.sendSystemMessage(Component.literal("<Herr xyz> Finde heraus, was ich unterrichte!"));
                QuestStorage.currentBannerTextString = "Finde heraus, was xyz unterrichtet!";
                QuestStorage.questRunning = true;
            }
        }
        // Return SUCCESS to confirm the interaction was handled.
        return InteractionResult.SUCCESS;
    }

    // --- IMMOBILITY METHODS ---

    /**
     * Prevents the entity from being pushed by other entities (players, mobs).
     */
    @Override
    public boolean isPushable() {
        return false;
    }

    /**
     * A more robust way to prevent being pushed by other entities.
     */
    @Override
    protected void doPush(Entity entity) {
        // Intentionally do nothing to cancel the push.
    }

    /**
     * Prevents the entity from being moved by pistons.
     */
    @Override
    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }
}