package me.oganesson.memory_clear;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class ClearCommand {
    public static void init() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("memoryclear").executes(context -> {
                        if (ModConfig.get().memoryClearCommand) {
                            context.getSource().sendFeedback(Text.translatable("message.memory_clear.start"), false);
                            System.gc();
                            try {
                                Thread.sleep(1200L);
                            } catch (InterruptedException e) {}
                            System.gc();
                            context.getSource().sendFeedback(Text.translatable("message.memory_clear.over"), false);
                        } else {
                            context.getSource().sendFeedback(Text.translatable("message.memory_clear.close"), false);
                        }
                        return 0;
                    })
            );
        });
    }
}
