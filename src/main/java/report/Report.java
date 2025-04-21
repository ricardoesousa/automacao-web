package report;

import cucumber.api.Scenario;
import driver.DriverManagerFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static void salvarPageSource() {
        String path = "target/error-page-sources/";
        try {
            // Define o diretório para salvar os arquivos
            File directory = new File(path);

            // Cria os diretórios se não existirem
            if (!directory.exists()) {
                boolean dirCreated = directory.mkdirs();
                if (!dirCreated) {
                    System.err.println("Não foi possível criar o diretório: " + directory.getPath());
                    return;
                }
            }

            // Cria um nome de arquivo único com timestamp
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = scenario.getName()
                    .replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".txt";

            // Caminho completo do arquivo
            File pageSourceFile = new File(directory, fileName);

            // Salva o page source em um arquivo
            try (FileWriter writer = new FileWriter(pageSourceFile)) {
                writer.write(DriverManagerFactory.getDriver().getPageSource());
                System.out.println("Page source salvo em: " + pageSourceFile.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar page source: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
