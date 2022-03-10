package cn.hrmzone.table;

import cn.hrmzone.util.FileNameParser;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class TableOcr {
    private AipOcr client;
    private String imgPath;
    ExcelUtil excelUtil;
    String sheetName,fileName;

    public TableOcr(AipOcr client, String imgPath) {
        this.client = client;
        this.imgPath = imgPath;
    }

    /**
     * 解析图片表格数据，根据返回的json，获取row、col和内容，将数据存入响应的excel行和列
     */
    public void writeFile() {
        excelUtil=new ExcelUtil(imgPath);
        excelUtil.newSheet(imgPath);
        HashMap<String,String> options=new HashMap<String,String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        JSONObject res=client.form(imgPath,options);
        /*
        返回的json，是一个多层嵌套的json内容，需要先获取JSONArray，再从中获取一个jsonobject，再获取JSONArray。
        可以通过格式化全部json内容，查看详细的分层格式
         */
        JSONArray bodyArray=res.getJSONArray("forms_result").getJSONObject(0).getJSONArray("body");
        int len=bodyArray.length();

        for(int i=0;i<len;i++) {
            JSONObject obj=bodyArray.getJSONObject(i);
            int row=obj.getInt("row");
            int col=obj.getInt("column");
            String words=obj.getString("words");
            excelUtil.writeCell(row,col,words);
        }

        excelUtil.writeExcel();
    }
}
