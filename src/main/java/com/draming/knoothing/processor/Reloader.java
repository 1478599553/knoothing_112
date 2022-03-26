package com.draming.knoothing.processor;

import java.io.IOException;

public class Reloader {
    public static void reloadScript() throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        new com.draming.knoothing.processor.GroovyProcessor();
    }
}
