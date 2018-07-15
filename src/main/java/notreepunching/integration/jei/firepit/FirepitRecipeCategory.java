/*
 *
 *  Part of the No Tree Punching Mod by alcatrazEscapee
 *  Work under Copyright. Licensed under the GPL-3.0.
 *  See the project LICENSE.md for more information.
 *
 */

package notreepunching.integration.jei.firepit;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import notreepunching.NoTreePunching;

import javax.annotation.Nonnull;

import static notreepunching.integration.jei.JEIPluginHelper.FIREPIT_UID;

public class FirepitRecipeCategory implements IRecipeCategory {

    private String localizedName;
    private final ResourceLocation LOC = new ResourceLocation(NoTreePunching.MODID, "textures/jei/firepit.png");
    private final IDrawable background;
    private final IDrawable icon;

    private final IDrawableAnimated animatedArrow;
    private final IDrawableAnimated animatedFlame;

    public FirepitRecipeCategory(IGuiHelper guiHelper){
        background = guiHelper.createDrawable(LOC,0,0,74,54);
        localizedName = NoTreePunching.proxy.localize("jei.category.firepit_recipe");
        icon = guiHelper.createDrawable(LOC,111,0,16,16);

        IDrawableStatic staticArrow = guiHelper.createDrawable(LOC, 88, 0, 16, 23);
        animatedArrow = guiHelper.createAnimatedDrawable(staticArrow, 200, IDrawableAnimated.StartDirection.LEFT, false);

        IDrawableStatic staticFlame = guiHelper.createDrawable(LOC, 74,0,14,13);
        animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
        if(!(recipeWrapper instanceof FirepitRecipeWrapper)) {
            return;
        }

        int index = 0;
        recipeLayout.getItemStacks().init(index, true, 0, 0);
        recipeLayout.getItemStacks().set(index, ingredients.getInputs(ItemStack.class).get(0));

        index++;
        recipeLayout.getItemStacks().init(index, false, 56, 0);
        recipeLayout.getItemStacks().set(index, ingredients.getOutputs(ItemStack.class).get(0));

    }


    @Nonnull
    @Override
    public String getUid() {
        return FIREPIT_UID;
    }

    @Nonnull
    @Override
    public String getTitle() {
        return localizedName;
    }

    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Nonnull
    @Override
    public String getModName() {
        return NoTreePunching.actualName;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        animatedArrow.draw(minecraft, 26, 1);
        animatedFlame.draw(minecraft, 30, 20);
    }
}