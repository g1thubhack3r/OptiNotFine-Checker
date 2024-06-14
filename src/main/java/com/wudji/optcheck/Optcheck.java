package com.wudji.optcheck;

import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Optcheck.MODID)
public class Optcheck {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "optcheck";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static Screen OptiFineWarningScreen = new ConfirmScreen(
            (boolean b) ->{
                if(b){
                    Util.getPlatform().openUri("https://www.optifine.net/downloads");
                }else{
                    Minecraft.getInstance().stop();
                }
            },
            Component.translatable("optcheck.xplus.failure.title"),
            Component.translatable("optcheck.xplus.failure.notfound"),
            Component.translatable("optcheck.xplus.openlink"),
            Component.translatable("menu.quit")

    );

    public Optcheck() {

    }
}
