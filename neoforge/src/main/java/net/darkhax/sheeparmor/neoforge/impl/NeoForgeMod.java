package net.darkhax.sheeparmor.neoforge.impl;

import net.darkhax.sheeparmor.common.impl.SheepArmor;
import net.neoforged.fml.common.Mod;

@Mod(SheepArmor.MOD_ID)
public class NeoForgeMod {

    public NeoForgeMod() {
        SheepArmor.init();
    }
}