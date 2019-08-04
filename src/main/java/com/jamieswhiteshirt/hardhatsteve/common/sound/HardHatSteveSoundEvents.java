package com.jamieswhiteshirt.hardhatsteve.common.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HardHatSteveSoundEvents {
    public static final SoundEvent ITEM_ARMOR_EQUIP_BUILDERS_APPAREL = register("item.armor.equip_builders_apparel");

    private static SoundEvent register(String id) {
        Identifier identifier = new Identifier("hard-hat-steve", id);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }

    public static void init() { }
}
