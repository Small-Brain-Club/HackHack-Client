package com.hackhack.mixin.mixins;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.hackhack.MapPeek;

@Mixin({GuiContainer.class})
public class MixinContainerGui extends GuiScreen
{
    MapPeek peek = new MapPeek();

    @Inject(
            method = {"drawScreen(IIF)V"},
            at = {@At("RETURN")}
    )
    public void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo info)
    {
        try
        {
            this.peek.draw(mouseX, mouseY, (GuiContainer) this.mc.currentScreen);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
