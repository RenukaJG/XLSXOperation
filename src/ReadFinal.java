import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFinal {

	private static final String FILE_NAME = "C:\\Work\\temp\\mySheet.xlsx";

	public static void main(String[] args) throws InvalidFormatException, EncryptedDocumentException, IOException {

		InputStream inp = new FileInputStream(FILE_NAME);

		int ctr = 0;

		Workbook wb = WorkbookFactory.create(inp);

		Sheet sheet = wb.getSheetAt(0);

		Row row = null;

		Cell cell = null;

		Cell headrecell;

		Row rows = sheet.getRow(0);

		Iterator cells = rows.cellIterator();

		ArrayList<String> header = new ArrayList<String>();

		while (cells.hasNext())

		{

			headrecell = (Cell) cells.next();

			{

				header.add(headrecell.getStringCellValue());

			}

		}

		ArrayList<String> customheader = new ArrayList<String>();

		customheader.add("Name");

		customheader.add("Salary");

		// customheader.add("adderss");

		customheader.add("DOB");

		// customheader.add("Age");

		// customheader.add("Location");

		for (ctr = 0; ctr <= sheet.getLastRowNum(); ctr++) {

			try {

				row = sheet.getRow(ctr);

				for (String s : customheader) {

					if (header.contains(s)) {

						int i = header.indexOf(s);

						cell = row.getCell(i);

						if (cell.getCellTypeEnum()  == CellType.NUMERIC) {

							if (DateUtil.isCellDateFormatted(cell)) {

								SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");

								System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t\t");

							} else {

								System.out.print( + cell.getNumericCellValue() + "\t\t");

							}

						} else if (cell.getCellTypeEnum() == CellType.STRING) {

							System.out.print(  cell.getStringCellValue() + "\t\t");

						} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {

							System.out.print(  cell.getBooleanCellValue() + "\t\t");

						}

					}

				}

				System.out.println();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

}
