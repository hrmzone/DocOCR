package cn.hrmzone.util;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @Author:张生
 * @Blog:http://hrmnzone.cn
 * @Organization:荆州青年教育平台(https://jzyouth.com),专注职业资格培训、学历提升
 * @Description:使用百度OCR接口，将图片上传识别，获得文字内容。
 * @Date:19-1-11
 */
import java.util.HashMap;

public class OCRClient {
    private AipOcr client;
    private String imgPath;

    public OCRClient(AipOcr client, String imgPath) {
        this.client = client;
        this.imgPath = imgPath;
        this.client.setConnectionTimeoutInMillis(2000);
        this.client.setSocketTimeoutInMillis(60000);
    }

    /**
     * 1、使用了百度的OCR接口，使用了Java SDk的AipOCR接口；
     * 2、使用了接口的普通文字ocr功能：client.basicGeneral(imgPath,options);
     * 3、将返回值JSONObject对象进行解析，获取words_resul数组中的words子段的多行文本；
     * @return
     */
    public String getWords() {
        StringBuffer resWords=new StringBuffer();
        HashMap<String,String> options=new HashMap<String,String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        JSONObject res=client.basicGeneral(imgPath,options);
//        JSONObject res=client.accurateGeneral(imgPath,options);
        JSONArray words_result=res.getJSONArray("words_result");
        int length=words_result.length();
        for(int i=0;i<length;i++) {
            JSONObject obj=words_result.getJSONObject(i);
            resWords.append(obj.getString("words")+"\n");
        }
        return resWords.toString();
    }


}