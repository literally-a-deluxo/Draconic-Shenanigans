package com.awesoft.DraconicShenanigans;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brandon3055.brandonscore.BrandonsCore;
import com.brandon3055.draconicevolution.DraconicEvolution;
import com.brandon3055.draconicevolution.api.DraconicAPI;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod(DraconicShenanigans.MODID)
public class DraconicShenanigans {
	public static final String MODID = "draconicshenanigans";
	public static final String NAME = "Draconic Shenanigans";
	public static final String VERSION = "${mod_version}";
	public static final String MODID_PREFIX = MODID + ":";

	public static Logger logger = LogManager.getLogger(MODID);

	public DraconicShenanigans() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		runChecks();
		DraconicAPI.addModuleProvider(MODID);
		DSContent.init();
		DraconicShenanigansTab.register(eventBus);
	}

	@SuppressWarnings("deprecation")
	private static void runChecks() {
		if (ModList.get().isLoaded("draconicadditions")) {
			DraconicShenanigans.logger.log(Level.INFO, "Yo, what's good Brandon's Core?");
			BrandonsCore.LOGGER.log(Level.INFO, "Oh hey, Additions doing goo- Wait you're not Additions...");
			DraconicShenanigans.logger.log(Level.INFO, "Yeah i'm Shenanigans, people say we look similar");
			BrandonsCore.LOGGER.log(Level.INFO, "Look similar? You look like a clone of him!");
			DraconicShenanigans.logger.log(Level.INFO, "uh... okay, well have you seen additions?");
			BrandonsCore.LOGGER.log(Level.INFO, "Uh no not yet, I'll keep you updated");
			DraconicShenanigans.logger.log(Level.INFO, "Alright thanks!");
		}

		if (ModList.get().isLoaded("draconicevolution")) {
			DraconicShenanigans.logger.log(Level.INFO, "Yo, Brandon's Core! what's good?");
			BrandonsCore.LOGGER.log(Level.INFO, "Oh hey, doin good. just looking for DE.");
			DraconicShenanigans.logger.log(Level.INFO, "just saw them, should be the door behind me, speaking of finding mods, you seen curios?");
			if (ModList.get().isLoaded("curios")) {
				BrandonsCore.LOGGER.log(Level.INFO, "Yup, just go up and to the left a bit, cant miss it");
				DraconicShenanigans.logger.log(Level.INFO, "thanks fella, also be careful, DE seems a little.. unstable");
				BrandonsCore.LOGGER.log(Level.INFO, "Sure sure....");
			}
			else {
				BrandonsCore.LOGGER.log(Level.INFO, "Why should i know that?");
				DraconicEvolution.LOGGER.log(Level.WARN, "Calculating explosion ETA");
				BrandonsCore.LOGGER.log(Level.INFO, "DE? What are you, ahh... NO... NONONO! DONT DO THAT!!! STOP THIS NOW!");
				DraconicEvolution.LOGGER.log(Level.WARN, "**Explosion Imminent!!!**");
				DraconicShenanigans.logger.log(Level.ERROR, "Brandon, WHAT HAVE YOU DONE???");
				throw new Error("Curios is not loaded. It is required for Draconic Shenanigans to work.");
			}
		}
		else {
			DraconicShenanigans.logger.log(Level.INFO, "Yo what's good brandon's core? ya seen draconic evolution round' here?");
			BrandonsCore.LOGGER.log(Level.INFO, "No but at least we wont literally die from his explosions.");
			DraconicShenanigans.logger.log(Level.WARN, "wait fr, hes not here?");
			BrandonsCore.LOGGER.log(Level.INFO, "Nah, Not my problem.");
			DraconicShenanigans.logger.log(Level.ERROR, "But But.. I can't do my job if that fella isn't here");
			BrandonsCore.LOGGER.log(Level.INFO, "Sorry man cant help you there.");
			throw new Error("Draconic Evolution is not loaded. Kinda required for this mod ngl");
		}

	}
}
