package com.wudji.optcheck.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.wudji.optcheck.Optcheck.OptiFineWarningScreen;

@Mixin(TitleScreen.class)
public class MainMenuMixin {
    @Unique
    private boolean optcheck$flag = true;

    @Inject(at = @At("HEAD"),method = "render")
    public void injectOptiFineChecker(CallbackInfo ci){
        try{
            Class.forName("net.optifine.Config");
        } catch (ClassNotFoundException e) {
            if (optcheck$flag) {
                optcheck$flag = false;
            }
        }
        if (optcheck$flag) {
            Minecraft.getInstance().setScreen(OptiFineWarningScreen);
        }
    }
}
