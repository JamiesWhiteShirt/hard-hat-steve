package com.jamieswhiteshirt.hardhatsteve.mixin;

import com.jamieswhiteshirt.hardhatsteve.common.entity.attribute.HardHatSteveEntityAttributes;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(
        method = "initAttributes()V",
        at = @At("TAIL")
    )
    private void initAttributes(CallbackInfo ci) {
        ((LivingEntity) (Object) this).getAttributeContainer().register(HardHatSteveEntityAttributes.REACH);
    }
}
