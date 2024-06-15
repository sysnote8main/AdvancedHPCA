package com.sysnote8.advancedhpca.tile.hpca;

import gregtech.api.GTValues;
import gregtech.api.capability.IHPCACoolantProvider;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.common.metatileentities.multi.multiblockpart.hpca.MetaTileEntityHPCAComponent;
import net.minecraft.util.ResourceLocation;

public class HPCACoolerTile extends MetaTileEntityHPCAComponent implements IHPCACoolantProvider {

    private final int voltageIndex;
    public HPCACoolerTile(ResourceLocation metaTileEntityId, int voltageIndex) {
        super(metaTileEntityId);
        if(GTValues.EV > voltageIndex || voltageIndex > GTValues.MAX) throw new IndexOutOfBoundsException("This number is over the voltage range.");
        this.voltageIndex = voltageIndex;
    }

    @Override
    public int getCoolingAmount() {
        return (int) Math.pow(2, voltageIndex - 4);
    }

    @Override
    public boolean isActiveCooler() {
        return true;
    }

    @Override
    public int getMaxCoolantPerTick() {
        return 16; // TODO needs to check
    }

    @Override
    public boolean isAdvanced() {
        return true;
    }

    @Override
    public SimpleOverlayRenderer getFrontOverlay() {
        return Textures.HPCA_ACTIVE_COOLER_OVERLAY;
    }

    @Override
    public int getUpkeepEUt() {
        return GTValues.VA[voltageIndex];
    }

    @Override
    public boolean canBeDamaged() {
        return false;
    }

    @Override
    public TextureArea getComponentIcon() {
        return GuiTextures.HPCA_ICON_ACTIVE_COOLER_COMPONENT;
    }

    @Override
    public SimpleOverlayRenderer getFrontActiveOverlay() {
        return Textures.HPCA_ACTIVE_COOLER_ACTIVE_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new HPCACoolerTile(this.metaTileEntityId, this.voltageIndex);
    }
}
