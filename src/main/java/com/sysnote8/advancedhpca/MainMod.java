package com.sysnote8.advancedhpca;

import com.sysnote8.advancedhpca.api.util.AHLog;
import com.sysnote8.advancedhpca.recipe.hpca.HPCARecipe;
import com.sysnote8.advancedhpca.tile.AHMetaTileEntities;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
        modid = Tags.MODID,
        version = Tags.VERSION,
        name = Tags.MODNAME,
        dependencies = "required-after:gregtech"
)
@Mod.EventBusSubscriber
public class MainMod {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        AHLog.logger.info(Tags.MODNAME + " was pre-initialized!");
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void registerRecipesNormal(RegistryEvent.Register<IRecipe> event) {
        AHMetaTileEntities.init();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void registerRecipesLowest(RegistryEvent.Register<IRecipe> event) {
        HPCARecipe.init();
    }
}
