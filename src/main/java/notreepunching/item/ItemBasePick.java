/*
 *
 *  Part of the No Tree Punching Mod by alcatrazEscapee
 *  Work under Copyright. Licensed under the GPL-3.0.
 *  See the project LICENSE.md for more information.
 *
 */

package notreepunching.item;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import notreepunching.NoTreePunching;
import notreepunching.client.ModTabs;

public class ItemBasePick extends ItemPickaxe {

    public String name;

    ItemBasePick(ToolMaterial material, String name){

        super(material);
        this.name = name;
        register();
    }

    public void register(){
        ModItems.addItemToRegistry(this,name, ModTabs.TOOLS_TAB);
        NoTreePunching.proxy.addModelToRegistry(new ItemStack(this), this.getRegistryName(), "inventory");
    }

}