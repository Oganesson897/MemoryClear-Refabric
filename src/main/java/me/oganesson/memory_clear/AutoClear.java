package me.oganesson.memory_clear;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class AutoClear {
    static int i = 0;
    public static void init() {
        ServerTickEvents.START_WORLD_TICK.register(world -> {
            if (i < ModConfig.get().autoMemoryClearTime * 1200) {
                i++;
            }
            if (i >= ModConfig.get().autoMemoryClearTime * 6) {
                i = 0;
                if (ModConfig.get().autoMemoryClear) {
                    System.gc();
                    try {
                        Thread.sleep(1200L);
                    } catch (InterruptedException e) {
                    }
                    System.gc();
                }
            }
        });
    }
}
