package net.thorhammer.mediaorg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;

public class App {
    public static void main(String[] args) throws IOException {
        Path sourcePath = Paths.get("C:/tmp/CoolPhotos/");
        Files
                .find(sourcePath, 5, (p, a) -> a.isRegularFile())
                .forEach(o -> {
                    System.out.println("File: " + o + "\nMetadata:\n" + parseToPlainText(o));
                });
    }

    private static String parseToPlainText(Path p) {
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        try (InputStream stream = new FileInputStream(p.toFile())) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        } catch (Exception ex) {
            return "n/a";
        }
    }
}
