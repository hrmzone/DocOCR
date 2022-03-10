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

/**
 * 将获取的数据，存放再excel指定的单元格中。
 */
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
        //注意：单元格是先创建行，然后在行中获得cell，所以需要先获取这一行，让后填入输入，如果每次新建行，只会保留最后一个单元格数据。
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
