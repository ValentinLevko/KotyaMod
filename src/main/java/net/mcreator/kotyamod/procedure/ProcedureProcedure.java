package net.mcreator.kotyamod.procedure;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.kotyamod.item.ItemCreativeFuelItem;
import net.mcreator.kotyamod.item.ItemCreativeFood;
import net.mcreator.kotyamod.ElementsKotyaMod;

@ElementsKotyaMod.ModElement.Tag
public class ProcedureProcedure extends ElementsKotyaMod.ModElement {
	public ProcedureProcedure(ElementsKotyaMod instance) {
		super(instance, 5);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Procedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Procedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Procedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Procedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Procedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (true) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).addExperienceLevel((int) 1000);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemCreativeFuelItem.block, (int) (1));
				_setstack.setCount(64);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemCreativeFood.block, (int) (1));
				_setstack.setCount(64);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).capabilities.allowFlying = (true);
				((EntityPlayer) entity).sendPlayerAbilities();
			}
			if (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false)) {
				world.playSound((EntityPlayer) null, x, y, z,
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ambient.cave")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clear();
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).getFoodStats().setFoodLevel((int) 1);
				{
					MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new TextComponentString("i creative user, u loser u survival user XD"));
				}
				world.setWorldTime((int) 18000);
				if (!world.isRemote && world.getMinecraftServer() != null) {
					world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return world;
						}

						@Override
						public MinecraftServer getServer() {
							return world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return new BlockPos((int) x, (int) y, (int) z);
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(x, y, z);
						}
					}, "clear");
				}
				world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
			}
		}
	}

	@SubscribeEvent
	public void onCommand(CommandEvent event) {
		ICommandSender sender = event.getSender();
		Entity entity = sender.getCommandSenderEntity();
		if (entity != null) {
			int i = (int) sender.getPosition().getX();
			int j = (int) sender.getPosition().getY();
			int k = (int) sender.getPosition().getZ();
			String command = event.getCommand().getName();
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("command", command);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
