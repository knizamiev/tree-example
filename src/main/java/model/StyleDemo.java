package model;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;

import java.io.FileOutputStream;
import java.io.IOException;

public class StyleDemo {
//    private static HSSFCellStyle getSampleStyle(HSSFWorkbook workbook) {
//        // Font
//        HSSFFont font = workbook.createFont();
////        font.setBold(true);
////        font.setItalic(true);
//
//        // Font Height
//        font.setFontHeightInPoints((short) 14);
//
//        // Font Color
////        font.setColor(IndexedColors.RED.index);
//
//        // Style
//        HSSFCellStyle style = workbook.createCellStyle();
//        style.setFont(font);
//
//        return style;
//    }

    public static void main(String[] args) throws IOException {

 /*
 goal:
     +---------+---------+----------+
     |    A    |    B    |    C     |
 +---+------------------------------+
 | 1 |         |      Savings       |
 +---+ Month   |--------------------+
 | 2 |         | January | February |
 +---+---------+---------+----------+
 */

        try (Workbook workbook =new HSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Style Demo");
            CellRangeAddress mergedRegion = new CellRangeAddress(0,0,1,2); // row 1 col B and C
            sheet.addMergedRegion(mergedRegion);
            mergedRegion = new CellRangeAddress(0,1,0,0); // row 1 and 2 col A
            sheet.addMergedRegion(mergedRegion);

//            Row row = sheet.createRow(0); // row 1
//            Cell cell = row.createCell(0); // cell A1
//            cell.setCellValue("Month");
//            // set vertical alignment center
//            CellUtil.setCellStyleProperty(cell, CellUtil.VERTICAL_ALIGNMENT, VerticalAlignment.CENTER);
//
//            cell = row.createCell(1); // cell B1
//            cell.setCellValue("Savings");
//            // set horizontal alignment center
//            CellUtil.setCellStyleProperty(cell, CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
//
//            row = sheet.createRow(1); // row 2
//            cell = row.createCell(1); // cell B2
//            cell.setCellValue("January");
//            cell = row.createCell(2); // cell C2
//            cell.setCellValue("February");




            if (workbook instanceof HSSFWorkbook) {
                try(FileOutputStream out = new FileOutputStream("CreateExcelMergedRegions.xls")){
                    workbook.write(out);
                }
            }
            workbook.close();
        }

            //Workbook workbook = new HSSFWorkbook();

        }
}
