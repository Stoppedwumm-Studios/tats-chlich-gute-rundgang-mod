package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.blocks.decorations;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.blocks.coreblocks.FacingBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class SchultaschenRegal extends FacingBlock {
    public static final BooleanProperty FILLED = BooleanProperty.create("filled");

    public SchultaschenRegal(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(FILLED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder); // keep FACING
        builder.add(FILLED); // add FILLED
    }
}
