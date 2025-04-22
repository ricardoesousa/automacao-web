package report;

import driver.DriverManagerFactory;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Report {

    public static Scenario scenario;
    private static final Logger logger = LoggerFactory.getLogger(Report.class);

    public static void tirarFotoDaTela() {
        final byte[] screenshot = ((TakesScreenshot) DriverManagerFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Imagem da tela");
    }

    public static void criarLog(String text) {
        scenario.log(text);
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
            String fileName = timestamp + "_" + scenario.getName()
                    .replaceAll("[^a-zA-Z0-9]", "_") + ".txt";

            // Caminho completo do arquivo
            File pageSourceFile = new File(directory, fileName);

            // Salva o page source em um arquivo
            try (FileWriter writer = new FileWriter(pageSourceFile)) {
                writer.write(Objects.requireNonNull(DriverManagerFactory.getDriver().getPageSource()));
                logger.info("Page source salvo em: {}", pageSourceFile.getAbsolutePath());
            }
        } catch (IOException e) {
            logger.error("Erro ao salvar page source: {}", e.getMessage(), e);
        }
    }


}
