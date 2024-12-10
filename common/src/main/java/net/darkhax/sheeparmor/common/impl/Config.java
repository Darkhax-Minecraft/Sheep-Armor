package net.darkhax.sheeparmor.common.impl;

import net.darkhax.pricklemc.common.api.annotations.Value;

public class Config {

    @Value(comment = "Determines if the mod is enabled or not.")
    public boolean enabled = true;

    @Value(comment = "The amount of bonus armor to give sheep while they still have wool.")
    public int bonus_armor = 3;
}