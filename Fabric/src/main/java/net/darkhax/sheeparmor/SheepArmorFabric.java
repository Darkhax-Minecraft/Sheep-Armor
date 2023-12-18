package net.darkhax.sheeparmor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class SheepArmorFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        SheepArmorCommon.init(FabricLoader.getInstance().getConfigDir().resolve(Constants.MOD_ID + ".json").toFile());
    }
}