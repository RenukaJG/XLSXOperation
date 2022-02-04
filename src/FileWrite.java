import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {

	private static final String FILE_NAME = "C:/Work/temp/Employee.xlsx";

	public static void main(String[] args) {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Employee");

		Object[][] datatypes = {

				{"Name", "Id", "Salary","Date Of Birth"},
				{"E1", "101", 50000.00,"03/02/1998"},
				{"E2", "102", 50000.00,-239747},
				{"E3", "103", 80000.00},
				{"E4", "104", 10000.00},
				{"E5", "104", 50000.00}

		};

		int rowNum = 0;

		for (Object[] datatype : datatypes) {

			Row row = sheet.createRow(rowNum++);

			int colNum = 0;

			for (Object field : datatype) {

				Cell cell = row.createCell(colNum++);

				if (field instanceof String) {

					cell.setCellValue((String) field);

				} else if (field instanceof Integer) {

					cell.setCellValue((Integer) field);

				}else if (field instanceof Double) {

					cell.setCellValue((Double) field);

				}


			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}