package hooks;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import properties.DefaultProperties;
import report.Report;

import java.time.Duration;

import static driver.DriverType.EDGE;
import static report.Report.salvarEvidencia;
import static report.Report.salvarPageSource;

public class Hook extends DriverManagerFactory implements DefaultProperties {

    DriverManager driverManager;

    @Before
    public void init(Scenario scenario) {
        Report.scenario = scenario;
        driverManager = DriverManagerFactory.getManager(EDGE);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            salvarEvidencia("O cenário: " + scenario.getName() + " falhou!");
            salvarPageSource();
        }
        driver.quit();
    }
}
