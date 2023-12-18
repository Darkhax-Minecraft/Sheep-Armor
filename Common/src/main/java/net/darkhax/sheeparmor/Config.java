package net.darkhax.sheeparmor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Config {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

    @Expose
    public double bonusArmor = 3d;

    public static Config load(File configFile) {

        Config config = new Config();

        // Attempt to load existing config file
        if (configFile.exists()) {

            try (FileReader reader = new FileReader(configFile)) {

                config = GSON.fromJson(reader, Config.class);
                Constants.LOG.info("Loaded config file.");
            }

            catch (Exception e) {

                Constants.LOG.error("Could not read config file {}. Defaults will be used.", configFile.getAbsolutePath(), e);
            }
        }

        else {

            Constants.LOG.info("Creating a new config file at {}.", configFile.getAbsolutePath());
            configFile.getParentFile().mkdirs();
        }

        try (FileWriter writer = new FileWriter(configFile)) {

            GSON.toJson(config, writer);
            Constants.LOG.info("Saved config file.");
        }

        catch (Exception e) {

            Constants.LOG.error("Could not write config file '{}'!", configFile.getAbsolutePath(), e);
        }

        if (config.bonusArmor < 0) {

            Constants.LOG.warn("The bonus armor amount was set to {} which is a value less than 0. This feature has been disabled.", config.armorBonusModifier);
            config.bonusArmor = 0;
        }

        if (config.bonusArmor > 30) {

            Constants.LOG.warn("The bonus armor amount was set to {} which is a value above 30. The vanilla armor formula gives no benefit for having over 30 armor so this may not work as you intend. The mod will proceed with your configured value.", config.bonusArmor);
        }

        return config;
    }

    private AttributeModifier armorBonusModifier;

    public boolean isFeatureEnabled() {

        return this.bonusArmor > 0;
    }

    public AttributeModifier getArmorBonusModifier() {

        if (armorBonusModifier == null) {

            armorBonusModifier = new AttributeModifier(Constants.ARMOR_UUID, "Wool Armor Bonus", this.bonusArmor, AttributeModifier.Operation.ADDITION);
        }

        return armorBonusModifier;
    }
}