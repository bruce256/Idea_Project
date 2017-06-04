package zip;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author 儒尊
 * @date 2017/06/04
 */
public class ExcelExtract {

	@Test
	public void excel() {
		XSSFWorkbook    book = null;
		FileInputStream fis  = null;

		try {
			File file = new File("/temp/zip/windows/全渠道批量发布模板.xlsx");
			fis = new FileInputStream(file);
			book = new XSSFWorkbook(fis);
			System.out.println(book.getActiveSheetIndex());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
