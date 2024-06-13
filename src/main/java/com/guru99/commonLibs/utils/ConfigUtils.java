package com.guru99.commonLibs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {

    public static Properties readProperty(String fileName) throws IOException {
        InputStream fileReader = Files.newInputStream(Paths.get(fileName));
        Properties property = new Properties();
        property.load(fileReader);
        return property;
    }
}
