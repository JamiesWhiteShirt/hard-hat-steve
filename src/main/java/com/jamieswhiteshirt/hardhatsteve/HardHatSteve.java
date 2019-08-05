package com.jamieswhiteshirt.hardhatsteve;

import com.jamieswhiteshirt.hardhatsteve.common.item.HardHatSteveItems;
import com.jamieswhiteshirt.hardhatsteve.common.sound.HardHatSteveSoundEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class HardHatSteve implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("hard-hat-steve");

    public static float reachModifier = 0.5F;

    @Override
    public void onInitialize() {
        HardHatSteveSoundEvents.init();
        HardHatSteveItems.init();

        Properties configuration = new Properties();
        configuration.setProperty("reachModifier", String.valueOf(reachModifier));
        File configurationFile = new File(FabricLoader.getInstance().getConfigDirectory(), "hard-hat-steve.properties");

        if (configurationFile.exists()) {
            try (InputStream in = new FileInputStream(configurationFile)) {
                configuration.load(in);
                LOGGER.info("Loaded configuration file \"" + configurationFile + "\"");
            } catch (IOException e) {
                LOGGER.error("Could not read configuration file \"" + configurationFile + "\"", e);
            }
        } else {
            try (OutputStream out = new FileOutputStream(configurationFile)) {
                configuration.store(out, "Hard Hat Steve configuration");
                LOGGER.info("Generated configuration file \"" + configurationFile + "\"");
            } catch (IOException e) {
                LOGGER.error("Could not write configuration file \"" + configurationFile + "\"", e);
            }
        }

        String relativeSpawnRateString = configuration.getProperty("reachModifier");
        try {
            reachModifier = Float.parseFloat(relativeSpawnRateString);
        } catch (NumberFormatException e) {
            LOGGER.error("Error processing configuration file \"" + configurationFile + "\".");
            LOGGER.error("Expected configuration value for reachModifier to be a number, found \"" + relativeSpawnRateString + "\".");
            LOGGER.error("Using default value \"" + reachModifier + "\" instead.");
        }
    }
}
