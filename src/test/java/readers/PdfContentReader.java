package readers;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.util.Arrays;

public class PdfContentReader implements ContentReader {
    private static final String FILE_FORMAT = "pdf";

    @Override
    public String read(String filename) throws IOException {
        if (!filename.endsWith(FILE_FORMAT)) {
            throw new IllegalArgumentException("Wrong file format");
        }

        PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(filename));
        if (document.isEncrypted()) {
            throw new IllegalArgumentException("Unable to read encrypted document");
        }

        StringBuilder sb = new StringBuilder();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String[] lines = pdfStripper.getText(document).split("\\r?\\n");
        Arrays.stream(lines)
                .skip(1)
                .forEach(sb::append);

        return sb.toString().replaceAll("[\",\\s]", "");
    }
}