
package net.mcreator.kotyamod.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.kotyamod.item.ItemCreativeFuelItem;
import net.mcreator.kotyamod.ElementsKotyaMod;

@ElementsKotyaMod.ModElement.Tag
public class FuelCreativeFuel extends ElementsKotyaMod.ModElement {
	public FuelCreativeFuel(ElementsKotyaMod instance) {
		super(instance, 3);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(ItemCreativeFuelItem.block, (int) (1)).getItem())
			return 1000000;
		return 0;
	}
}
