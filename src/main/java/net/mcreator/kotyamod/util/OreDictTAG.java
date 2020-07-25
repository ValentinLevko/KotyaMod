
package net.mcreator.kotyamod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import net.mcreator.kotyamod.ElementsKotyaMod;

@ElementsKotyaMod.ModElement.Tag
public class OreDictTAG extends ElementsKotyaMod.ModElement {
	public OreDictTAG(ElementsKotyaMod instance) {
		super(instance, 1);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("tag", new ItemStack(Blocks.TNT, (int) (1)));
	}
}
