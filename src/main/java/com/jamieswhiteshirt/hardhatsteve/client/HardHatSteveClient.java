package com.jamieswhiteshirt.hardhatsteve.client;

import com.jamieswhiteshirt.hardhatsteve.common.item.HardHatSteveItems;
import com.jamieswhiteshirt.hardhatsteve.mixin.client.ArmorFeatureRendererAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.item.DyeableItem;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;

public class HardHatSteveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.ITEM.register(
            (stack, colorIndex) -> (colorIndex > 0 ? 0xFFFFFFFF : ((DyeableItem)stack.getItem()).getColor(stack)),
            HardHatSteveItems.HARD_HAT, HardHatSteveItems.SAFETY_VEST, HardHatSteveItems.CONTRACTOR_PANTS, HardHatSteveItems.STEEL_TOED_BOOTS
        );
        preRegisterArmorTextures(new Identifier("hard-hat-steve", "builders_apparel"), true);
    }

    private void preRegisterArmorTextures(Identifier name, boolean hasOverlay) {
        for (int layer = 1; layer <= 2; layer++) {
            preRegisterArmorTexture(name, layer, null);
            if (hasOverlay) {
                preRegisterArmorTexture(name, layer, "overlay");
            }
        }
    }

    private void preRegisterArmorTexture(Identifier name, int layer, @Nullable String extra) {
        String key = "textures/models/armor/" + name + "_layer_" + layer + (extra == null ? "" : "_" + extra) + ".png";
        Identifier value = new Identifier(name.getNamespace(), "textures/models/armor/" + name.getPath() + "_layer_" + layer + (extra == null ? "" : "_" + extra) + ".png");
        ArmorFeatureRendererAccessor.getArmorTextureCache().put(key, value);
    }
}
