package utils;

import hooks.Hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Screenshot {

    public static void tirarPrint(WebDriver driver, String nomePrint) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String caminho = "target/evidencias/" + Hooks.featureName + "/" + nomePrint + ".png";

            File file = new File(caminho);
            file.getParentFile().mkdirs();

            FileUtils.copyFile(src, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}