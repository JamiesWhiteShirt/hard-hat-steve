package com.jamieswhiteshirt.hardhatsteve.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.hardhatsteve.HardHatSteve;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

public class BuildersApparelItem extends DyeableArmorItem {
    private static final UUID[] MODIFIERS = new UUID[]{
        UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
        UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
        UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
        UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")
    };
    private final int defaultColor;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public BuildersApparelItem(ArmorMaterial armorMaterial_1, EquipmentSlot equipmentSlot_1, int defaultColor, Settings item$Settings_1) {
        super(armorMaterial_1, equipmentSlot_1, item$Settings_1);
        this.defaultColor = defaultColor;
        this.attributeModifiers = ImmutableMultimap.of(ReachEntityAttributes.REACH, new EntityAttributeModifier(MODIFIERS[slot.getEntitySlotId()], "Reach modifier", HardHatSteve.reachModifier, EntityAttributeModifier.Operation.ADDITION));
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundTag_1 = stack.getSubTag("display");
        return compoundTag_1 != null && compoundTag_1.contains("color", NbtType.NUMBER) ? compoundTag_1.getInt("color") : defaultColor;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == this.slot ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }
}
