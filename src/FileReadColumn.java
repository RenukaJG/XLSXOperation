import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReadColumn {

	private static final String FILE_NAME = "C:\\Work\\temp\\employdata.xlsx";

	public static void main(String[] args) throws  InvalidFormatException, EncryptedDocumentException, IOException {

		InputStream inp = new FileInputStream(FILE_NAME);

		int ctr = 0;

		Workbook wb = WorkbookFactory.create(inp);

		Sheet sheet = wb.getSheetAt(0);

		Row row = null;

		Cell cell = null;

		boolean isnull=false;

		do{

			try{

				row = sheet.getRow(ctr);

				cell = row.getCell(0);
				
				System.out.println(cell.toString());
				
				ctr++;

			} catch(Exception e) {

				isnull=true;
			}
		

		}while(isnull!=true);

		inp.close();
	}
}