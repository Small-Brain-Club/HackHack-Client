package com.hackhack.module.modules;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import com.hackhack.gui.AdvancedText;
import com.hackhack.gui.TextWindow;
import com.hackhack.module.Category;
import com.hackhack.module.Module;
import com.hackhack.settings.SettingBase;
import com.hackhack.settings.SettingSlider;
import com.hackhack.settings.SettingToggle;

public class Welcomer extends Module
{
    private static final List<SettingBase> settings = Arrays.asList(new SettingSlider(0.0D, 255.0D, 235.0D, 0, "Text R: "), new SettingSlider(0.0D, 255.0D, 235.0D, 0, "Text G: "), new SettingSlider(0.0D, 255.0D, 235.0D, 0, "Text B: "), new SettingToggle(false, "Shadow"));

    public Welcomer()
    {
        super("Welcomer", 0, Category.RENDER, "Welcomes you", settings);

        this.getWindows().add(new TextWindow(50, 12, "Welcomer"));
    }

    public void onOverlay()
    {
        boolean shadow = this.getSettings().get(3).toToggle().state;

        int color = (new Color((int) this.getSettings().get(0).toSlider().getValue(), (int) this.getSettings().get(1).toSlider().getValue(), (int) this.getSettings().get(2).toSlider().getValue())).getRGB();

        this.getWindows().get(0).clearText();
        this.getWindows().get(0).addText(new AdvancedText("Hello " + this.mc.player.getName() + " :^)", shadow, color));
    }
}
