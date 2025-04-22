package driver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

    @Getter @Setter
    public static WebDriver driver;

    public static DriverManager getManager(DriverType type) {

        return switch (type) {
            case CHROME -> new ChromeDriverManager();
            case EDGE -> new EdgeDriverManager();
        };
    }
}
