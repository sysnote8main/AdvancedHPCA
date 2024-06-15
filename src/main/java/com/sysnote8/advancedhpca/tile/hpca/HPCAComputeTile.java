package com.sysnote8.advancedhpca.tile.hpca;

import gregtech.api.GTValues;
import gregtech.api.capability.IHPCAComputationProvider;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.common.metatileentities.multi.multiblockpart.hpca.MetaTileEntityHPCAComponent;
import net.minecraft.util.ResourceLocation;

public class HPCAComputeTile extends MetaTileEntityHPCAComponent implements IHPCAComputationProvider {
    private final int voltageIndex;
    public HPCAComputeTile(ResourceLocation metaTileEntityId, int voltageIndex) {
        super(metaTileEntityId);
        if(GTValues.EV > voltageIndex || voltageIndex > GTValues.MAX-2) throw new IndexOutOfBoundsException("This number is over the voltage range.");
        this.voltageIndex = voltageIndex;
    }

    @Override
    public int getCWUPerTick() {
        return this.isDamaged() ? 0 : (int) Math.pow(4, voltageIndex-3);
    }

    @Override
    public int getCoolingPerTick() {
        return (int) Math.pow(2, voltageIndex-3);
    }

    @Override
    public boolean isAdvanced() {
        return true; // TODO self-implementation now extends class
    }

    @Override
    public SimpleOverlayRenderer getFrontOverlay() {
        if (this.isDamaged()) {
            return Textures.HPCA_ADVANCED_DAMAGED_OVERLAY;
        } else {
            return Textures.HPCA_ADVANCED_COMPUTATION_OVERLAY;
        }
    }

    @Override
    public int getUpkeepEUt() {
        return GTValues.VA[voltageIndex];
    }

    @Override
    public int getMaxEUt() {
        return GTValues.VA[voltageIndex+2];
    }

    @Override
    public boolean canBeDamaged() {
        return true;
    }

    @Override
    public TextureArea getComponentIcon() {
        if (this.isDamaged()) {
            return GuiTextures.HPCA_ICON_DAMAGED_ADVANCED_COMPUTATION_COMPONENT;
        } else {
            return GuiTextures.HPCA_ICON_ADVANCED_COMPUTATION_COMPONENT;
        }
    }

    @Override
    public SimpleOverlayRenderer getFrontActiveOverlay() {
        if (this.isDamaged()) {
            return Textures.HPCA_ADVANCED_DAMAGED_ACTIVE_OVERLAY;
        } else {
            return Textures.HPCA_ADVANCED_COMPUTATION_ACTIVE_OVERLAY;
        }
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new HPCAComputeTile(this.metaTileEntityId, this.voltageIndex);
    }
}
