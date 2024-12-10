package net.darkhax.sheeparmor.common.impl;

import net.darkhax.bookshelf.common.api.function.CachedSupplier;
import net.darkhax.pricklemc.common.api.config.ConfigManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Sheep;

import java.util.function.Supplier;

public class SheepArmor {

    public static final String MOD_ID = "sheeparmor";
    private static final ResourceLocation ARMOR_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "bonus_armor");
    private static final Config CONFIG = ConfigManager.load(MOD_ID, new Config());
    private static final Supplier<AttributeModifier> BONUS_ARMOR = CachedSupplier.cache(() -> new AttributeModifier(ARMOR_ID, CONFIG.bonus_armor, AttributeModifier.Operation.ADD_VALUE));

    public static void init() {
    }

    public static void updateSheep(Sheep sheep) {
        final AttributeInstance armorAttribute = sheep.getAttribute(Attributes.ARMOR);
        if (armorAttribute != null) {
            armorAttribute.removeModifier(ARMOR_ID);
            if (CONFIG.enabled && !sheep.isSheared()) {
                armorAttribute.addTransientModifier(BONUS_ARMOR.get());
            }
        }
    }
}