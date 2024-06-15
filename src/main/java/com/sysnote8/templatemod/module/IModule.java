package com.sysnote8.templatemod.module;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Set;

public interface IModule {
    @NotNull
    default Set<ResourceLocation> getDependencyUids() {
        return Collections.emptySet();
    }

    default void construction(FMLConstructionEvent event) {}

    default void preInit(FMLPreInitializationEvent event) {}

    default void init(FMLInitializationEvent event) {}

    default void postInit(FMLPostInitializationEvent event) {}

    default void load(FMLLoadEvent event) {}

    default void loadComplete(FMLLoadCompleteEvent event) {}

    default void serverAboutToStart(FMLServerAboutToStartEvent event) {}

    default void serverStarting(FMLServerStartingEvent event) {}

    default void serverStarted(FMLServerStartedEvent event) {}

    default void serverStopping(FMLServerStoppingEvent event) {}

    default void serverStopped(FMLServerStoppedEvent event) {}

    default void registerItems(RegistryEvent.Register<Item> event) {}
}
