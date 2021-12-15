package com.ThaddeusHalifax.WendigoMod.tools;
import com.ThaddeusHalifax.WendigoMod.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public enum FlayersTools implements IItemTier
{

    // TODO: make it so you don't have to use the example technovision did in his tutorial for item material
    // https://nekoyue.github.io/ForgeJavaDocs-NG/javadoc/1.16.5/net/minecraft/item/crafting/Ingredient.html
    // https://forums.minecraftforge.net/topic/101268-1165-custom-armor-model-not-working-extra-stuff-being-rendered/
    FLAYERS_TOOLS_OBSIDIAN(2, 350, 6, 2.25F, 13, () ->
    {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", "obsidian"));
        return Ingredient.of(item);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    FlayersTools(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
    {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {

        return repairMaterial.get();
    }
}
