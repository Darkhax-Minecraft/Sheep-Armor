package net.darkhax.sheeparmor.fabric.impl;

import net.darkhax.sheeparmor.common.impl.SheepArmor;
import net.fabricmc.api.ModInitializer;

public class FabricMod implements ModInitializer {

    @Override
    public void onInitialize() {
        SheepArmor.init();
    }
}