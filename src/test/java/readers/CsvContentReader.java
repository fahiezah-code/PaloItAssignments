package readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvContentReader implements ContentReader {
    private static final String FILE_FORMAT = "csv";

    @Override
    public String read(String filename) throws IOException {
        if (!filename.endsWith(FILE_FORMAT)) {
            throw new IllegalArgumentException("Wrong file format");
        }

        return Files.readString(Path.of(filename)).replaceAll("[\",\\s]", "");
    }
}
