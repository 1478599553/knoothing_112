package com.draming.knoothing.processor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;


import com.draming.knoothing.knoothing;
import groovy.lang.Closure;

import groovy.lang.Binding;


public class GroovyProcessor {

    final File SCRIPT_DIR = new File("./scripts/groophite");
    Binding binding = new Binding();
    File[] script_files = SCRIPT_DIR.listFiles
        (
            new FilenameFilter() 
            {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".groovy");
                };
            }
        );

    public static void cleanClosures() throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        List<Class> event_clazz = new ArrayList<Class>();

        event_clazz.add(Class.forName("Groophite_PlayerDestroyItemEvent"));
        event_clazz.add(Class.forName("Groophite_EntityJoinWorldEvent"));
        event_clazz.add(Class.forName("Groophite_PlayerSetSpawnEvent"));
        event_clazz.add(Class.forName("Groophite_PlayerContainerEvent"));
        event_clazz.add(Class.forName("Groophite_FillBucketEvent"));
        event_clazz.add(Class.forName("Groophite_ItemTooltipEvent"));
        event_clazz.add(Class.forName("Groophite_AttackEntityEvent"));


        for (Class clazz : event_clazz){
            clazz.getField("closures").set(clazz,new ArrayList<Closure>());;
        }
        //TODO add more cleaning entries!
    }

    public GroovyProcessor() throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        cleanClosures();
        if (script_files  != null)
        {

        for (File key : script_files)
            {
            knoothing.logger.info("loading script : " + key.getName());

            com.draming.knoothing.processor.GroovyScriptFactory.getInstance().scriptGetAndRun(key, binding);
                knoothing.logger.info("loaded script : " + key.getName());
            }
        }
    }

}
