package com.draming.groophite;


/*
import jd.core.Decompiler;
 */
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.datatransfer.Clipboard;

@Mod(
        modid = knoothing.MODID,
        name = knoothing.NAME,
        version = knoothing.VERSION)

public class knoothing {
    public static final String MODID = "knoothing";
    public static final String NAME = "Knoothing";
    public static final String VERSION = "1.0";
    @Mod.Instance
    public static knoothing Instance;


    public static Clipboard clipboard;

    public static Logger logger;

    public knoothing() {

    }
}


