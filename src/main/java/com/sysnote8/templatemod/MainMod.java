package com.sysnote8.templatemod;

import com.sysnote8.templatemod.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Tags.MODID,
        version = Tags.VERSION,
        name = Tags.MODNAME,
        dependencies = ""
)
@Mod.EventBusSubscriber
public class MainMod {
    @SidedProxy(serverSide = Tags.PROXY_SERVER, clientSide = Tags.PROXY_CLIENT)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        proxy.onConstruction(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        proxy.preInit(event);
    }
}
