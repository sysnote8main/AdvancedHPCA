package com.sysnote8.advancedhpca.api.util;

import com.sysnote8.advancedhpca.Tags;
import net.minecraft.util.ResourceLocation;

public class AHUtil {
    public static ResourceLocation ahId(String path) {
        return new ResourceLocation(Tags.MODID, path);
    }
}
