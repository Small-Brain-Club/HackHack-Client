package com.hackhack.module.modules;

import java.util.List;

import com.hackhack.gui.NewRuhamaGui;
import com.hackhack.module.Category;
import com.hackhack.module.Module;

public class ClickGui extends Module
{
    public static NewRuhamaGui clickGui = new NewRuhamaGui();

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
