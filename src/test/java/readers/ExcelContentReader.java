package readers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelContentReader implements ContentReader {
    private static final String FILE_FORMAT = "xlsx";

    @Override
    public String read(String filename) throws IOException {
        if (!filename.endsWith(FILE_FORMAT)) {
            throw new IllegalArgumentException("Wrong file format");
        }

        FileInputStream inputStream = new FileInputStream(filename);
        Workbook workbook = new XSSFWorkbook(inputStream);
        StringBuilder sb = new StringBuilder();
        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            sb.append(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            sb.append((int) cell.getNumericCellValue());
                            break;
                        default:
                            System.out.print("Unknown cell type!");
                    }
                }
            }
        }

        return sb.toString().replaceAll("[\",\\s]", "");
    }
}