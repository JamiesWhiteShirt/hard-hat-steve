package com.jamieswhiteshirt.hardhatsteve.mixin.client;

import com.jamieswhiteshirt.hardhatsteve.common.entity.attribute.HardHatSteveEntityAttributes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final private MinecraftClient client;

    @ModifyConstant(
        method = "updateTargetedEntity(F)V",
        constant = @Constant(
            doubleValue = 6.0D
        )
    )
    private double modifyReachDistance(double value) {
        return value + client.player.getAttributeInstance(HardHatSteveEntityAttributes.REACH).getValue();
    }
}
