package com.draming.knoothing.processor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.groovy.runtime.InvokerHelper;

import groovy.lang.GroovyClassLoader;
import groovy.lang.Binding;
import groovy.lang.Script;

public class GroovyScriptFactory {
    private static Map<String, Class<Script>> scriptCache = new HashMap<>();
    private GroovyClassLoader classLoader = new GroovyClassLoader();
    private static GroovyScriptFactory factory = new GroovyScriptFactory();
    EncryptUtil encryptUtil = new EncryptUtil();
    
    private GroovyScriptFactory(){}

    public static GroovyScriptFactory getInstance(){
        return factory;
    }

    private Class getScript(File file) {
        String key;
        key = com.draming.knoothing.processor.ReadFileContent.readFileContent(file);

        String encodeStr = encryptUtil.SHA256(key);

        if(scriptCache.containsKey(encodeStr)){
            return scriptCache.get(encodeStr);
        }else{
            // 脚本不存在则创建新的脚本
            Class<Script> scriptClass = classLoader.parseClass(key);
            scriptCache.put(encodeStr, scriptClass);
            return scriptClass;
        }
    }

    private Object run(Class<Script> script, Binding binding) {
        Script scriptObj = InvokerHelper.createScript(script, binding);
        Object result = scriptObj.run();
        // clear the script cache
        classLoader.clearCache();
        return result;
    }

    public Object scriptGetAndRun(File file, Binding binding) {
        return run(getScript(file), binding);
    }
}