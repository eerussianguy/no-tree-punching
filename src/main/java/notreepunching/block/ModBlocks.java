package notreepunching.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import notreepunching.NoTreePunching;
import notreepunching.config.Config;
import notreepunching.registry.RegistryHandler;

public class ModBlocks {

    public static BlockRock looseRock;

    public static BlockCobble andesiteCobble;
    public static BlockCobble graniteCobble;
    public static BlockCobble dioriteCobble;

    public static BlockCobble marbleCobble;
    public static BlockCobble limestoneCobble;
    public static BlockCobble slateCobble;

    public static BlockFirepit firepit;
    public static BlockCharcoalPile charcoalPile;
    public static BlockForge forge;
    public static BlockWoodPile woodPile;

    public static void init(){
        looseRock = new BlockRock("loose_rock");

        if(Config.VanillaTweaks.STONE_DROPS_ROCKS) {
            andesiteCobble = new BlockCobble("andesite");
            graniteCobble = new BlockCobble("granite");
            dioriteCobble = new BlockCobble("diorite");
        }
        if(NoTreePunching.replaceQuarkStones){
            marbleCobble = new BlockCobble("marble");
            limestoneCobble = new BlockCobble("limestone");
        }
        if(NoTreePunching.replaceRusticStone){
            slateCobble = new BlockCobble("slate");
        }

        firepit = new BlockFirepit("firepit");
        charcoalPile = new BlockCharcoalPile("charcoal_pile");
        forge = new BlockForge("forge");
        woodPile = new BlockWoodPile("wood_pile");
    }

    public static void addBlockToRegistry(Block block, ItemBlock itemBlock, String name, boolean addToCreativeTab){
        block.setRegistryName(name);
        block.setUnlocalizedName(name);
        itemBlock.setRegistryName(name);

        if(addToCreativeTab) { block.setCreativeTab(NoTreePunching.NTP_Tab); }

        RegistryHandler.BLOCK_REGISTRY.add(block);
        RegistryHandler.ITEM_REGISTRY.add(itemBlock);
    }
}
