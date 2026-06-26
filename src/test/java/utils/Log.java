package utils;

import hooks.Hooks;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {

    public static void escreverLog(String texto) {

        String caminho = "target/evidencias/" + Hooks.featureName + "/log.txt";

        File file = new File(caminho);
        file.getParentFile().mkdirs();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {

            writer.println("[" + java.time.LocalDateTime.now() + "] " + texto);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}