package com.sysnote8.advancedhpca.tile;

import com.sysnote8.advancedhpca.api.util.AHUtil;
import com.sysnote8.advancedhpca.tile.hpca.HPCAComputeTile;
import com.sysnote8.advancedhpca.tile.hpca.HPCACoolerTile;
import gregtech.api.GTValues;

import java.util.Locale;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class AHMetaTileEntities {
    public static HPCAComputeTile HPCA_COMPUTE_LUV, HPCA_COMPUTE_ZPM, HPCA_COMPUTE_UV, HPCA_COMPUTE_UHV, HPCA_COMPUTE_UEV;
    public static HPCACoolerTile HPCA_COOLER_LUV, HPCA_COOLER_ZPM, HPCA_COOLER_UV, HPCA_COOLER_UHV, HPCA_COOLER_UEV, HPCA_COOLER_UIV;
    public static HPCAComputeTile[] computeTiles;
    public static HPCACoolerTile[] coolerTiles;
    public static void init() {
        // HPCA Compute 11101 ~ 11120
        HPCA_COMPUTE_LUV = registerHPCACompute(GTValues.LuV);
        HPCA_COMPUTE_ZPM = registerHPCACompute(GTValues.ZPM);
        HPCA_COMPUTE_UV = registerHPCACompute(GTValues.UV);
        HPCA_COMPUTE_UHV = registerHPCACompute(GTValues.UHV);
        HPCA_COMPUTE_UEV = registerHPCACompute(GTValues.UEV);
        computeTiles = new HPCAComputeTile[]{HPCA_COMPUTE_LUV, HPCA_COMPUTE_ZPM, HPCA_COMPUTE_UV, HPCA_COMPUTE_UHV, HPCA_COMPUTE_UEV};

        // HPCA Cooler 11121 ~ 11140
        HPCA_COOLER_LUV = registerHPCACooler(GTValues.LuV);
        HPCA_COOLER_ZPM = registerHPCACooler(GTValues.ZPM);
        HPCA_COOLER_UV = registerHPCACooler(GTValues.UV);
        HPCA_COOLER_UHV = registerHPCACooler(GTValues.UHV);
        HPCA_COOLER_UEV = registerHPCACooler(GTValues.UEV);
        HPCA_COOLER_UIV = registerHPCACooler(GTValues.UIV);
        coolerTiles = new HPCACoolerTile[]{HPCA_COOLER_LUV, HPCA_COOLER_ZPM, HPCA_COOLER_UV, HPCA_COOLER_UHV, HPCA_COOLER_UEV, HPCA_COOLER_UIV};
    }

    private static final String BASE_ID_HPCA_COMPUTE = "hpca_compute_";
    private static final String BASE_ID_HPCA_COOLER = "hpca_cooler_";
    private static HPCAComputeTile registerHPCACompute(int voltageIndex) {
        return registerMetaTileEntity(11101 + voltageIndex, new HPCAComputeTile(AHUtil.ahId(BASE_ID_HPCA_COMPUTE + GTValues.VN[voltageIndex].toLowerCase(Locale.ROOT)), voltageIndex));
    }
    private static HPCACoolerTile registerHPCACooler(int voltageIndex) {
        return registerMetaTileEntity(11121 + voltageIndex, new HPCACoolerTile(AHUtil.ahId(BASE_ID_HPCA_COOLER + GTValues.VN[voltageIndex].toLowerCase(Locale.ROOT)), voltageIndex));
    }
}
