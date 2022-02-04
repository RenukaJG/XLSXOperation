import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReadCustom11111 {

	private static final String FILE_NAME = "C:\\Work\\temp\\employdata.xlsx";

	public static void main(String[] args) throws  InvalidFormatException, EncryptedDocumentException, IOException {

		InputStream inp = new FileInputStream(FILE_NAME);

		int ctr = 0;

		Workbook wb = WorkbookFactory.create(inp);

		Sheet sheet = wb.getSheetAt(0);

		Row row ;

		Cell cell;

		Cell headrecell;

		Row rows = sheet.getRow(0);

		Iterator cells = rows.cellIterator();

		ArrayList<String> header = new ArrayList<String>();

		while (cells.hasNext())

		{

			headrecell=(Cell) cells.next();

			{

				header.add(headrecell.getStringCellValue());

			}

		}

		ArrayList<String> customheader = new ArrayList<String>();

		customheader.add("name");

		customheader.add("adderss");
		
		customheader.add("salary");

		customheader.add("DOB");

		for (ctr=0; ctr< sheet.getLastRowNum(); ctr++){

			try{
				row = sheet.getRow(ctr);

				for (String s : customheader) {

					if (header.contains(s)) {

						int i = header.indexOf(s);

						cell = row.getCell(i);

						System.out.print(cell.toString()+"\t\t");

					}

				}

				System.out.println();

			}catch(Exception e){
				
				e.printStackTrace();
				
			}

		}

	}

}


