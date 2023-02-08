package me.oganesson.memory_clear;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class MemoryClear implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoClear.init();
        ClearCommand.init();
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
    }
}
