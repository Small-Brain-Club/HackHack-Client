package me.vp.HackHack.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class HackHackLogger
{
    public static void log(String text)
    {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(TextFormatting.RED + "HackHack: " + TextFormatting.RESET + text));
    }
}
