package net.ascens.ripple.block;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.item.RItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.KelpPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ripple.MOD_ID);

    public static final DeferredBlock<Block> BULL_KELP = registerBlock("bull_kelp",
            () -> new KelpBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP)));
    public static final DeferredBlock<Block> BULL_KELP_PLANT = registerBlock("bull_kelp_plant",
            () -> new KelpPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP_PLANT)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        RItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
