package com.jiuyi.yao.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author superb    @Date 2016年2月29日
 * 
 * @Description 
 *
 * @Copyright 2016 重庆柒玖壹健康管理有限公司
 */
public class PoiReadExcelTwo {
	public static void main(String[] args) throws Exception {
		String path = "F:\\html\\";
		String fileName = "791";
		String fileType = "xlsx";
		// read(path, fileName, fileType);
		insert();
	}

	static void read(String path, String fileName, String fileType) throws Exception {
		InputStream stream = new FileInputStream(path + fileName + "." + fileType);
		Workbook wb = null;
		if (fileType.equals("xls")) {
			wb = new HSSFWorkbook(stream);
		} else if (fileType.equals("xlsx")) {
			wb = new XSSFWorkbook(stream);
		} else {
			System.out.println("您输入的文件格式不正确");
		}

		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC:// 数字
					System.out.print(cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_STRING:// 字符串
					System.out.print(cell.getStringCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:// boolean
					System.out.print(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:// 公式
					System.out.print(cell.getCellFormula());
					break;
				case HSSFCell.CELL_TYPE_BLANK:// 空值
					System.out.print("");
					break;
				case HSSFCell.CELL_TYPE_ERROR:// 故障
					System.out.print("");
					break;
				default:
					System.out.print("未知类型");
					break;
				}
				System.out.print("\n");
				
			}
		}

	}

	public static void insert() throws Exception {
		String fileType = "xlsx";
		InputStream stream = new FileInputStream(new File("F:\\html\\791.xmls"));
		Workbook wb = null;
		if (fileType.equals("xlsx")) {
			wb = new HSSFWorkbook(stream);
		} else if (fileType.equals("xls")) {
			wb = new XSSFWorkbook(stream);
		} else {
			System.out.println("您输入的文件不合法");
		}

		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC:// 数字
					System.out.print(cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_STRING:// 字符串
					System.out.print(cell.getStringCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:// boolean
					System.out.print(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:// 公式
					System.out.print(cell.getCellFormula());
					break;
				case HSSFCell.CELL_TYPE_BLANK:// 空值
					System.out.print("");
					break;
				case HSSFCell.CELL_TYPE_ERROR:// 故障
					System.out.print("");
					break;
				default:
					System.out.print("未知类型");
					break;
				}
				System.out.print("\n");
			}
		}
	}
}
