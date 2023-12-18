package net.darkhax.sheeparmor;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Sheep;

import java.io.File;

public class SheepArmorCommon {

    private static Config config;

    public static void init(File configFile) {

        config = Config.load(configFile);
    }

    public static void onSheepUpdated(Sheep sheep) {

        sheep.getAttribute(Attributes.ARMOR).removeModifier(Constants.ARMOR_UUID);

        if (config != null && config.isFeatureEnabled() && !sheep.isSheared()) {

            sheep.getAttribute(Attributes.ARMOR).addPermanentModifier(config.getArmorBonusModifier());
        }
    }
}