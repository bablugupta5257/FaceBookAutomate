package FB;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginAndCreateUserData {
	
		
	public String readExceldata( String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream f = new FileInputStream("./TestData/FbUserData.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		 String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
public String readExceldataForNumeric( String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream f = new FileInputStream("./TestData/FbUserData.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		 String data1 =Long.toString((long)(wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue()));
		return data1;
	}

	
	
}
	

