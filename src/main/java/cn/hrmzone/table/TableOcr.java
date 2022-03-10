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

    public void writeFile() {
        excelUtil=new ExcelUtil(imgPath);
        excelUtil.newSheet(imgPath);
        HashMap<String,String> options=new HashMap<String,String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        JSONObject res=client.form(imgPath,options);
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
