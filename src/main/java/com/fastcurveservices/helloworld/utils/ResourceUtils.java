package com.fastcurveservices.helloworld.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public interface ResourceUtils {

    static Properties loadGit(Resource location) throws IOException {
        String prefix = "git.";
        Properties target = new Properties();
        Properties source = PropertiesLoaderUtils.loadProperties(location);
        for (String key : source.stringPropertyNames()) {
            if (key.startsWith(prefix)) {
                target.put(key.substring(prefix.length()), source.get(key));
            }
        }
        return target;
    }
}
