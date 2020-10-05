package me.vp.HackHack.module.modules;

import me.vp.HackHack.ui.AdvancedText;
import me.vp.HackHack.ui.TextWindow;
import me.vp.HackHack.module.Category;
import me.vp.HackHack.module.Module;
import me.vp.HackHack.Settings.SettingBase;
import me.vp.HackHack.Settings.SettingSlider;
import me.vp.HackHack.Settings.SettingToggle;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

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
        this.getWindows().get(0).addText(new AdvancedText("Hey " + this.mc.player.getDisplayName() + " :^)", shadow, color));
    }
}
