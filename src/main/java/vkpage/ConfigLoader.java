package vkpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties = new Properties();

    public ConfigLoader() {
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load configuration file");
        }
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
    public String getLoginMail() {
        return properties.getProperty("loginMail");
    }

    public String getPasswordMail() {
        return properties.getProperty("passMail");
    }
}
