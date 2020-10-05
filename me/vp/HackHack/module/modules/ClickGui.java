package me.vp.HackHack.module.modules;

import me.vp.HackHack.ui.HackHackGui;
import me.vp.HackHack.module.Category;
import me.vp.HackHack.module.Module;

import java.util.List;

public class ClickGui extends Module
{
    public static HackHackGui clickGui = new HackHackGui(mc);

    public ClickGui()
    {
        super("ClickGui", 0, Category.RENDER, "Clickgui", null);
    }

    public void onEnable()
    {
        this.mc.displayGuiScreen(clickGui);
        this.setToggled(false);
    }
}
