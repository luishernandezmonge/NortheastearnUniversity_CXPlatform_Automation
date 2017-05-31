/**
 * 
 */
package northeasternuniversity.cxplatform.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



/**
 * @author luishernandez
 *
 */
public class DataSourceManager {
	private int testDataRow;
	private String filePath;
	private String dataSheetName;

	FileInputStream dataSourceFileInputStream;
	HSSFWorkbook workbook;
	HSSFSheet dataSheet;
	HSSFRow dataRow;

	public DataSourceManager(String filePath, String dataSheetName, int testDataRow) {
		this.filePath = filePath;
		this.dataSheetName = dataSheetName;
		this.testDataRow = testDataRow;

	}
	
	public DataSourceManager(String filePath, String dataSheetName) {
		this.filePath = filePath;
		this.dataSheetName = dataSheetName;

	}

	public int getTestDataRow() {
		return testDataRow;
	}

	public void setTestDataRow(int testDataRow) {
		this.testDataRow = testDataRow;
	}

	public String getDataValue(int testDataColumn) {
		String testDataValue = null;

		try {
			dataSourceFileInputStream = new FileInputStream(new File(this.filePath));
			workbook = new HSSFWorkbook(dataSourceFileInputStream);
			dataSheet = workbook.getSheet(this.dataSheetName);
			dataRow = dataSheet.getRow(this.testDataRow);

			testDataValue = dataRow.getCell(testDataColumn).getStringCellValue();

		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return testDataValue;
	}

	public void closeIO() {
		try {
			dataSourceFileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
