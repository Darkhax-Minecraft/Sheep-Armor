package net.darkhax.sheeparmor;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Constants.MOD_ID)
public class SheepArmorForge {

    public SheepArmorForge() {

        SheepArmorCommon.init(FMLPaths.CONFIGDIR.get().resolve(Constants.MOD_ID + ".json").toFile());
    }
}