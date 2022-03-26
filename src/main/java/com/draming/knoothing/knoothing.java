package com.draming.knoothing;


/*
import jd.core.Decompiler;
 */
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

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


