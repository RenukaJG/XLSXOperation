import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class test2 {

	private static final String FILE_NAME = "C:\\Work\\temp\\employdata.xlsx";

	public static void main(String[] args) throws  InvalidFormatException, EncryptedDocumentException, IOException {

		InputStream inp = new FileInputStream(FILE_NAME);
		
		Workbook wb = WorkbookFactory.create(inp);

		Sheet sheet = wb.getSheetAt(1);
		
		Row row=null ;
Cell cell=null;
		Row rows = sheet.getRow(0);
		int ctr = 0;
System.out.println(sheet.getLastRowNum());
		for (ctr=0; ctr< sheet.getLastRowNum(); ctr++){
			if (DateUtil.isCellDateFormatted(cell)) {
			    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			    System.out.println( df.format(cell.getDateCellValue()));
  //  } 
			//else {
			  //  DecimalFormat df = new DecimalFormat("##.###############");
			    //return df.format(cell.getNumericCellValue());
			//}
			    }

		
		}
	
	
	
	}
}