package net.darkhax.sheeparmor.forge.impl;

import net.darkhax.sheeparmor.common.impl.SheepArmor;
import net.minecraftforge.fml.common.Mod;

@Mod(SheepArmor.MOD_ID)
public class ForgeMod {

    public ForgeMod() {
        SheepArmor.init();
    }
}