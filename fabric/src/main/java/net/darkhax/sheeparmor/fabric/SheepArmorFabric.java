package net.darkhax.sheeparmor.fabric;

import net.darkhax.sheeparmor.common.SheepArmor;
import net.fabricmc.api.ModInitializer;

public class SheepArmorFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        SheepArmor.init();
    }
}