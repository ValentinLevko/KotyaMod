
package net.mcreator.kotyamod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.kotyamod.ElementsKotyaMod;

@ElementsKotyaMod.ModElement.Tag
public class RecipeRecipe extends ElementsKotyaMod.ModElement {
	public RecipeRecipe(ElementsKotyaMod instance) {
		super(instance, 7);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.SLIME_BALL, (int) (1)), new ItemStack(Items.SLIME_BALL, (int) (10)), 256F);
	}
}
