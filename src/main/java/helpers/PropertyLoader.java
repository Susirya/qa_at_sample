package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static final String PROPERTY_FILE = System.getProperties().get("basedir") + "/target/classes/application.properties";
    private static PropertyLoader instanse;
    private Properties appProperties;
    private PropertyLoader() {
        try (FileInputStream in = new FileInputStream(PROPERTY_FILE)){
            appProperties = new Properties();
            appProperties.load(in);
        } catch (IOException e) {
            //TO-DO normal logging
            e.printStackTrace();
        }
    }

    public static PropertyLoader getInstanse(){
        if (instanse == null) {
            instanse = new PropertyLoader();
        }
        return instanse;
    }

    public String getPropertyValue(String key){
        return appProperties.getProperty(key);
    }
}
