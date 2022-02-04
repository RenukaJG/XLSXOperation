import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReadCell  
{  
	public static void main(String[] args)   
	{  
		FileReadCell rc=new FileReadCell();   //object of the class  
		 
		String output=rc.ReadCellData(2, 2);   //reading the value of 2nd row and 2nd column 
		
		System.out.println(output);  
	
	}  
	 
	public String ReadCellData(int vRow, int vColumn) 
	
	{  
		
		String value=null;          //variable for storing the cell value  
		
		Workbook wb=null;           //initialize Workbook null  
		
		try  
		
		{  
			 
			FileInputStream fis=new FileInputStream("C:\\Work\\temp\\employdata.xlsx");  
			
			wb=new XSSFWorkbook(fis);
			
		}catch(FileNotFoundException e)  
		
		{  
			
			e.printStackTrace();  
		
		}catch(IOException e1)  
		
		{  
			
			e1.printStackTrace();  
		
		}  
		
		Sheet sheet=wb.getSheetAt(1);   //getting the XSSFSheet object at given index  
		
		Row row=sheet.getRow(vRow); //returns the logical row  
		
		Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
		
		value=cell.getStringCellValue();    //getting cell value  
		
		return value;               //returns the cell value  
	
	} 
	
}  
