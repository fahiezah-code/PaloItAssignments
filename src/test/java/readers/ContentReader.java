package readers;

import java.io.IOException;

public interface ContentReader {
    String read(String filename) throws IOException;
}