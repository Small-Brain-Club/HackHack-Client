package me.vp.HackHack.module.modules;

import me.vp.HackHack.ui.AdvancedText;
import me.vp.HackHack.ui.TextWindow;
import me.vp.HackHack.module.Category;
import me.vp.HackHack.module.Module;
import me.vp.HackHack.module.ModuleManager;
import me.vp.HackHack.Settings.SettingBase;
import me.vp.HackHack.Settings.SettingSlider;
import me.vp.HackHack.Settings.SettingToggle;
import net.minecraft.util.math.MathHelper;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Gui extends Module
{
    private static final List<SettingBase> settings = Arrays.asList(new SettingSlider(0.0D, 255.0D, 235.0D, 0, "HackHack R: "), new SettingSlider(0.0D, 255.0D, 235.0D, 0, "HackHack G: "), new SettingSlider(0.0D, 255.0D, 235.0D, 0, "Ruhama B: "), new SettingToggle(true, "RainbowList"), new SettingSlider(0.0D, 255.0D, 235.0D, 0, "List R: "), new SettingSlider(0.0D, 255.0D, 235.0D, 0, "List G: "), new SettingSlider(0.0D, 255.0D, 235.0D, 0, "List B: "));
    public static int arrayListEnd = 160;

    public Gui()
    {
        super("Gui", 0, Category.RENDER, "The Ingame HackHack gui", settings);

        this.getWindows().add(new TextWindow(2, 150, "Arraylist"));
    }

    public void onOverlay()
    {
        this.getWindows().get(0).clearText();

        int color = (new Color((int) this.getSettings().get(0).toSlider().getValue(), (int) this.getSettings().get(1).toSlider().getValue(), (int) this.getSettings().get(2).toSlider().getValue())).getRGB();
        String s = "HackHack 1.0";
        this.getWindows().get(0).addText(new AdvancedText(s, true, color));

        if (this.getSettings().get(3).toToggle().state)
        {
            int age = (int) (System.currentTimeMillis() / 20L % 510L);
            color = (new Color(255, MathHelper.clamp(age > 255 ? 510 - age : age, 0, 255), MathHelper.clamp(255 - (age > 255 ? 510 - age : age), 0, 255))).getRGB();
        } else
        {
            color = (new Color((int) this.getSettings().get(4).toSlider().getValue(), (int) this.getSettings().get(5).toSlider().getValue(), (int) this.getSettings().get(6).toSlider().getValue())).getRGB();
        }

        List<Module> arrayList = ModuleManager.getModules();

        arrayList.remove(this);

        arrayList.sort((a, b) -> Integer.compare(this.mc.fontRenderer.getStringWidth(b.getName()), this.mc.fontRenderer.getStringWidth(a.getName())));

        for (Module m : arrayList)
        {
            if (m.isToggled())
            {
                this.getWindows().get(0).addText(new AdvancedText(m.getName(), true, color));
            }
        }
    }
}
