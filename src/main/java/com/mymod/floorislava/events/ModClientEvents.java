package com.mymod.floorislava.events;

import com.mymod.floorislava.FloorisLava;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FloorisLava.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

	@SubscribeEvent
	public static void onJumpSetLava(LivingEvent.LivingJumpEvent event) {
		LivingEntity player = event.getEntityLiving();
		World world = player.getEntityWorld();
		
		world.addParticle(ParticleTypes.EXPLOSION, player.lastTickPosX, player.lastTickPosY, player.lastTickPosZ, 1.0D, 0.0D, 0.0D);
		world.setBlockState(player.func_233580_cy_().add(0, -1, 0), Blocks.LAVA.getDefaultState());
	}
}
