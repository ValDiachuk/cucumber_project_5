package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //help us read properties file
    private static Properties properties = new Properties();

    static{
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
