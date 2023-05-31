package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 

/**
 * This class is related to Excel Reader
 * 
 * @author ganapati.bhat
 *
 */
public class ExcelReader {

	public   String excelFilePath = null;
	public   String sheetName = null;
	 
/**
 * Method to get Data provide value
 * @param excelpath
 * @param sheetName1
 * @return
 * @throws IOException
 */
	public String[][] getDataProviderData(String excelpath, String sheetName1) throws IOException {
		excelFilePath = excelpath;
		sheetName = sheetName1;

		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheet(sheetName);
		System.out.println("Sheet name selected is  " + sheetName1);
		int totalRowCount = getTotalRowCount(firstSheet);

		int totalColCount = totalColumnCount(firstSheet, 1);

		String data[][] = new String[totalRowCount][totalColCount];

		DataFormatter dataFormatter = new DataFormatter();
		for (int x = 1; x <= totalRowCount; x++) {

			Row row = firstSheet.getRow(x);

			for (int m = 0; m < totalColCount; m++) {
				Cell cell = row.getCell(m);
				try {
					@SuppressWarnings("deprecation")
					CellType cellType = cell.getCellTypeEnum();
					
					switch (cellType) {
					case STRING:
						data[x - 1][m] = cell.getStringCellValue();
						break;

					case FORMULA:
						data[x - 1][m] = cell.getStringCellValue();
						break;
						
					case NUMERIC:
						data[x - 1][m] = dataFormatter.formatCellValue(cell);
						break;
						
					case BLANK:
						data[x - 1][m] = dataFormatter.formatCellValue(cell);
						break;
						
					default:
						break;

					}
				} catch (Exception e) {
					System.out.println("can not read cell data");
				}
			}

		}

		/*
		 * for (int x = 0; x < totalRowCount; x++) {
		 * 
		 * for (int m = 0; m < totalColCount; m++) { System.out.println(data[x][m]); }
		 * 
		 * }
		 */

		workbook.close();
		return data;

	}

	/**
	 * to get total row count which contains data
	 * 
	 * @param sheetTD
	 * @return
	 */
	private static int getTotalRowCount(XSSFSheet sheetTD) {
		int totalRowCount = sheetTD.getLastRowNum();
	 
		boolean isRowEmpty = false;

		int r = totalRowCount;
		int totalloopCountRow = sheetTD.getRow(totalRowCount).getPhysicalNumberOfCells();
		do {

			for (int d = 1; d <= totalloopCountRow; d++) {
				try {

					if (sheetTD.getRow(r).getCell(d) == null || sheetTD.getRow(r).getCell(d).toString().equals("")) {

						isRowEmpty = true;

					} else {
						isRowEmpty = false;
					}

					if (d != 0 && isRowEmpty == false) {

						break;
					}

				} catch (NullPointerException e) {

				}

			}

			if (isRowEmpty == true) {
				r--;
			}
		} while (isRowEmpty == true);

		return r;
	}

	/**
	 * To get actual column count which contains data
	 * 
	 * @param rowNum
	 * @param sheetTD
	 */

	private static int totalColumnCount(XSSFSheet sheetTD, int tcRowNum) {

		boolean isColEmpty = false;
		int col = 0;
		do {

			try {

				if (sheetTD.getRow(tcRowNum).getCell(col) == null
						|| sheetTD.getRow(tcRowNum).getCell(col).toString().equals("")) {

					isColEmpty = true;

				} else {
					isColEmpty = false;
				}

			} catch (NullPointerException e) {

			}

			if (isColEmpty == false) {
				col++;
			}

			if (isColEmpty == true) {

				break;
			}

		} while (isColEmpty == false);
		return col;
	}
/**
 * Method to get excel first set of data
 * @param excelpath
 * @param sheetName1
 * @return
 * @throws IOException
 */
	public HashMap<String, String> getExcelFirstSetOfData(String excelpath, String sheetName1) throws IOException {
		HashMap<String, String> hmap = new HashMap<String, String>();
		excelFilePath = excelpath;
		sheetName = sheetName1;

		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheet(sheetName);
		System.out.println("Sheet name selected is  " + sheetName1);

		int totalColCount = totalColumnCount(firstSheet, 0);

		Row row = firstSheet.getRow(0);
		Row dataRow = firstSheet.getRow(1);

		for (int m = 0; m < totalColCount; m++) {
			Cell cell = row.getCell(m);
			Cell datacell = dataRow.getCell(m);
			try {

				CellType cellType = datacell.getCellTypeEnum();

				switch (cellType) {
				case STRING:
					hmap.put(cell.getStringCellValue(), datacell.getStringCellValue());

					break;

				case FORMULA:
					hmap.put(cell.getStringCellValue(), datacell.getStringCellValue());
					break;
				default:
					break;

				}
			} catch (Exception e) {
				System.out.println("can not read cell data");
			}
		}

	 
		workbook.close();
		return hmap;

	}
/**
 * Method related to getErrorValidationSetOfData
 * @param excelpath
 * @param sheetName1
 * @param columnName
 * @return
 * @throws IOException
 */
	public ArrayList<String> getErrorValidationSetOfData(String excelpath, String sheetName1, String columnName)
			throws IOException {
		ArrayList<String> aList = new ArrayList<String>();
		columnName = columnName.toLowerCase();
		excelFilePath = excelpath;
		sheetName = sheetName1;
		int columnNumber = 0;

		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheet(sheetName);
		System.out.println("Sheet name selected is  " + sheetName1);
		int totalRowCount = getTotalRowCount(firstSheet);

		int physicalcells = firstSheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 0; i < physicalcells; i++) {
			if (firstSheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
				columnNumber = i;
				break;
			}
		}

		for (int r = 1; r <= totalRowCount; r++) {
			Row row = firstSheet.getRow(r);
			Cell cell = row.getCell(columnNumber);

			try {

				CellType cellType = cell.getCellTypeEnum();

				switch (cellType) {
				case STRING:
					aList.add(cell.getStringCellValue().trim());
					break;
				case NUMERIC:
					aList.add(String.valueOf(cell.getNumericCellValue()));
					break;
				case FORMULA:
					aList.add(cell.getStringCellValue().trim());
					break;
				default:
					break;

				}
			} catch (Exception e) {
				aList.add("");
				System.out.println("Cell data is empty");
			}
		}

		workbook.close();

		return aList;

	}
/**
 * Method related to getCommonData
 * @param parameters
 * @return
 * @throws IOException
 */
	public HashMap<String, String> getCommonData(String... parameters) throws IOException {
		HashMap<String, String> hmap = new HashMap<String, String>();
		excelFilePath = parameters[0];
		sheetName = parameters[1];

		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheet(sheetName);
		//System.out.println("Sheet name selected is  " + sheetName);

		int totalRowCount = getTotalRowCount(firstSheet);
 
		for (int k = 1; k <= totalRowCount; k++) {

			for (int i = 2; i < parameters.length; i++) {
				 
				if (firstSheet.getRow(k).getCell(0).getStringCellValue().equalsIgnoreCase(parameters[i])) {
					hmap.put(parameters[i], firstSheet.getRow(k).getCell(1).getStringCellValue());

				}
			}

		}
		workbook.close();
		/*for (Map.Entry<String, String> entry : hmap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}*/
		return hmap;

	}
 
/**
 * Method related to getExcelData
 * @param excelpath
 * @param sheetname
 * @return
 * @throws IOException
 */
	public HashMap<String, String> getExcelData(String excelpath, String sheetname) throws IOException {

		HashMap<String, String> hmap = new HashMap<String, String>();
		excelFilePath = excelpath;
		sheetName = sheetname;

		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheet(sheetName);
		System.out.println("Sheet name selected is  " + sheetName);

		int totalRowCount = getTotalRowCount(firstSheet);

		for (int k = 1; k <= totalRowCount; k++) {

			hmap.put(firstSheet.getRow(k).getCell(0).getStringCellValue(),
					firstSheet.getRow(k).getCell(1).getStringCellValue());

		}
		workbook.close();
		for (Map.Entry<String, String> entry : hmap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		return hmap;

	}

	public void setCellValue(int totalColCount, XSSFSheet firstSheet, String value, int rownumber, String mapValue) {
		for (int i = 2; i <= totalColCount; i++) {
			String hdrname = firstSheet.getRow(0).getCell(i).getStringCellValue();

			if (hdrname.equalsIgnoreCase(value)) {
				firstSheet.getRow(rownumber).getCell(i).setCellValue(mapValue);

				break;
			}
		}
	}
 

}