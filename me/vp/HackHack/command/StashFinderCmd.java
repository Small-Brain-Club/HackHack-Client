package me.vp.HackHack.command;

import me.vp.HackHack.module.ModuleManager;
import me.vp.HackHack.module.modules.StashFinder;
import me.vp.HackHack.utils.HackHackLogger;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.ChunkPos;
import net.minecraftforge.client.IClientCommand;

import java.util.Objects;

public class StashFinderCmd extends CommandBase implements IClientCommand
{
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message)
    {
        return false;
    }

    public String getName()
    {
        return "stashfinder";
    }

    public String getUsage(ICommandSender sender)
    {
        return null;
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args)
    {
        if (args.length != 2)
        {
            HackHackLogger.log("Invalid number of arguments, use /stashfinder x z");
        } else
        {
            try
            {
                ((StashFinder) Objects.requireNonNull(ModuleManager.getModuleByName("StashFinder"))).startChunk = new ChunkPos(Integer.parseInt(args[0]) >> 4, Integer.parseInt(args[1]) >> 4);
                HackHackLogger.log("Set stashfinder start to: " + args[0] + ", " + args[1]);
            } catch (Exception e)
            {
                HackHackLogger.log("wrong, /stashfinder x z");
            }
        }
    }

    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }
}
