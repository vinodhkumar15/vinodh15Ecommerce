package com.Utlity;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	//Store all commonly used methods for method reusablity purpose 

		static String filepath = "./src/main/java/com/TestData/myBook.ods";

		// Store all commonly used methods for method reusablity purpose

		public static String[][] setdata(String sheetname) throws Throwable {

			File file = new File(filepath);
			FileInputStream stream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(stream);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int rows = sheet.getPhysicalNumberOfRows();
			int columns = sheet.getRow(1).getLastCellNum();
			String[][] data = new String[rows - 1][columns];

			for (int i = 0; i < rows - 1; i++) {
				for (int j = 0; j < columns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
				}
			}

			workbook.close();
			stream.close();
			return data;

		}

	}


