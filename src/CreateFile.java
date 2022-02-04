import java.io.*;   
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class CreateFile

{   

	public static void main(String[] args) throws FileNotFoundException, IOException   
	{   

		Workbook wb = new XSSFWorkbook();  

		Sheet sheet = wb.createSheet("Sheet");

		OutputStream fileOut = new FileOutputStream("C:\\Work\\temp\\MyFile.xlsx");   

		System.out.println("Excel File has been created successfully.");   

		wb.write(fileOut); 

	}   

}  