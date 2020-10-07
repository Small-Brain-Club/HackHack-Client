package com.hackhack.module.modules;

import java.util.Arrays;
import java.util.List;

import com.hackhack.module.Category;
import com.hackhack.module.Module;
import com.hackhack.settings.SettingBase;
import com.hackhack.settings.SettingToggle;

public class Peek extends Module
{
    private static final List<SettingBase> settings = Arrays.asList(new SettingToggle(true, "Map"), new SettingToggle(true, "Book"), new SettingToggle(true, "Shulker Cmd"));

    public Peek()
    {
        super("Peek", 0, Category.MISC, "Shows content of stuff", settings);
    }
}
