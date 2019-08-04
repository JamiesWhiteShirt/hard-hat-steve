package com.jamieswhiteshirt.hardhatsteve.mixin;

import com.jamieswhiteshirt.hardhatsteve.common.entity.attribute.HardHatSteveEntityAttributes;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {
    @ModifyConstant(
        method = "method_14263(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/server/network/packet/PlayerActionC2SPacket$Action;Lnet/minecraft/util/math/Direction;I)V",
        constant = @Constant(
            doubleValue = 36.0F
        )
    )
    private double modifyReachDistance(double value) {
        double baseReachDistance = Math.sqrt(value);
        double reachDistance = baseReachDistance + ((ServerPlayerInteractionManager) (Object) this).player.getAttributeInstance(HardHatSteveEntityAttributes.REACH).getValue();
        return reachDistance * reachDistance;
    }
}
