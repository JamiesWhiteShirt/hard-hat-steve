package com.jamieswhiteshirt.hardhatsteve.mixin.client;

import com.jamieswhiteshirt.hardhatsteve.common.entity.attribute.HardHatSteveEntityAttributes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Shadow @Final private MinecraftClient client;

    @ModifyConstant(
        method = "getReachDistance()F",
        constant = {
            @Constant(
                floatValue = 5.0F
            ),
            @Constant(
                floatValue = 4.5F
            )
        }
    )
    float modifyReachDistance(float value) {
        PlayerEntity player = client.player;
        // if (player == null) return value;
        return value + (float) player.getAttributeInstance(HardHatSteveEntityAttributes.REACH).getValue();
    }
}
