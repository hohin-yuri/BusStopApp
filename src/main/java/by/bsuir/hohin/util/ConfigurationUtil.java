package by.bsuir.hohin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface ConfigurationUtil {

    static final String CONFIGURATION_PATH = "config.properties";

    public static String getProperty(String key, String defaultValue) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        try(InputStream resourceStream = loader.getResourceAsStream(CONFIGURATION_PATH)) {
            props.load(resourceStream);
        } catch (IOException e) {
            System.err.println("Error! Can't find properties file!");
            e.printStackTrace();
        }
        return props.getProperty(key, defaultValue);
    }

}
