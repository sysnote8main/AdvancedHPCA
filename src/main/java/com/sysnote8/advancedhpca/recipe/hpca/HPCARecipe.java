package com.sysnote8.advancedhpca.recipe.hpca;

import com.sysnote8.advancedhpca.tile.AHMetaTileEntities;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

import static gregtech.api.GTValues.UV;
import static gregtech.api.GTValues.VA;

public class HPCARecipe {
    public static void init() {
        Material[] materialTiers = new Material[]{MarkerMaterials.Tier.UHV, MarkerMaterials.Tier.UEV, MarkerMaterials.Tier.UIV, MarkerMaterials.Tier.UXV, MarkerMaterials.Tier.OpV, MarkerMaterials.Tier.MAX};
        MetaItem<?>.MetaValueItem[] fieldGenerators = new MetaItem.MetaValueItem[]{MetaItems.FIELD_GENERATOR_UV, MetaItems.FIELD_GENERATOR_UHV, MetaItems.FIELD_GENERATOR_UEV, MetaItems.FIELD_GENERATOR_UIV, MetaItems.FIELD_GENERATOR_UXV, MetaItems.FIELD_GENERATOR_OpV};
        for(int i = 0; i< AHMetaTileEntities.computeTiles.length; i++) {
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                    .input(i == 0 ? MetaTileEntities.HPCA_ADVANCED_COMPUTATION_COMPONENT : AHMetaTileEntities.computeTiles[i - 1])
                    .input(OrePrefix.circuit, materialTiers[i], 4)
                    .input(fieldGenerators[i])
                    .output(AHMetaTileEntities.computeTiles[i])
                    .duration(200).EUt(VA[i + UV])
                    .buildAndRegister();
        }
    }
}
