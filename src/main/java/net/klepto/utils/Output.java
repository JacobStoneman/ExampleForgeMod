package net.klepto.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class Output {

    public static void systemMessage(Player player, String message) {
        player.sendSystemMessage(Component.literal(message));
    }

    public static String formatCoordinates(int x, int y, int z) {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}