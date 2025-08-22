package de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.blocks.categories;

import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.blocks.coreblocks.FacingBlock;
import de.kolleg.st.thomas.arbeitsgemeinschaften.thomasprojekt.registries.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public class BuildingBlocks {
    public static DeferredBlock<Block> SCHULTASCHENREGAL;

    public static void register() {
        SCHULTASCHENREGAL = registerBlock("schultaschen_regal",
                () -> new FacingBlock(BlockBehaviour.Properties.of()
                        .destroyTime(-1.0F)
                        .explosionResistance(99999999999.99f)
                        .sound(SoundType.WOOD)
                        .lightLevel(state -> 7)
                        .noOcclusion()
                ));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> registeredBlock = Blocks.BLOCKS.register(name, block);
        Blocks.ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
        return registeredBlock;
    }
}
