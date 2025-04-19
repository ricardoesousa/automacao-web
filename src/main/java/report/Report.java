package report;

import cucumber.api.Scenario;
import driver.DriverManagerFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class Report {

    public static Scenario scenario;

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static void tirarFotoDaTela() {
        try {
            final byte[] screenshot = ((TakesScreenshot) DriverManagerFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public static void criarLog(String text) {
        scenario.write(text);
    }

    public static void salvarEvidencia(String text) {
        tirarFotoDaTela();
        criarLog(text);
    }
}
