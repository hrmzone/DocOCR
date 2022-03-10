package cn.hrmzone.table;

import cn.hrmzone.util.FileNameParser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {
    String fileName;
    Workbook workbook;
    Sheet sheet;

    public ExcelUtil(String fileName) {
        this.fileName = fileName;
        workbook=new XSSFWorkbook();
    }

    public void newSheet(String sheetName) {
        System.out.println("sheet name:"+FileNameParser.getName(fileName));
        sheet=workbook.createSheet(FileNameParser.getName(fileName));
    }
    public void writeCell(int row,int col,String s) {
        Row row1=sheet.getRow(row);
        if(row1==null) {
            row1= sheet.createRow(row);
        }
        Cell cell=row1.createCell(col);
        cell.setCellValue(s);
    }

    public void writeExcel() {
        FileOutputStream fos= null;
        try {
            System.out.println(FileNameParser.getPath(fileName)+ File.separator+FileNameParser.getName(fileName)+".xlsx");
            fos = new FileOutputStream(FileNameParser.getPath(fileName)+ File.separator+FileNameParser.getName(fileName)+".xlsx");
            workbook.write(fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
