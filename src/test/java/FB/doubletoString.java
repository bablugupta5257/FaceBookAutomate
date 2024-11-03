package FB;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class doubletoString {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream f = new FileInputStream("./TestData/FbUserData.xlsx");
	Workbook wb = WorkbookFactory.create(f);
	 String data1 =Long.toString((long)(wb.getSheet("Sheet1").getRow(3).getCell(3).getNumericCellValue()));
	 
	
	System.out.println(data1);
}
}
