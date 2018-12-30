package by.bsuir.hohin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface ConfigurationUtil {

    static final String CONFIGURATION_PATH = "";

    public static String getProperty(String key, String defaultValue) throws IOException {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        try(InputStream resourceStream = loader.getResourceAsStream(CONFIGURATION_PATH)) {
            props.load(resourceStream);
        }
        return props.getProperty(key, defaultValue);
    }

}
