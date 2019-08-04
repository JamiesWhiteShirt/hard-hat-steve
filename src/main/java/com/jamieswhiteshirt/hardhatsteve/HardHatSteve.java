package com.jamieswhiteshirt.hardhatsteve;

import com.jamieswhiteshirt.hardhatsteve.common.item.HardHatSteveItems;
import com.jamieswhiteshirt.hardhatsteve.common.sound.HardHatSteveSoundEvents;
import net.fabricmc.api.ModInitializer;

public class HardHatSteve implements ModInitializer {
    @Override
    public void onInitialize() {
        HardHatSteveSoundEvents.init();
        HardHatSteveItems.init();
    }
}
