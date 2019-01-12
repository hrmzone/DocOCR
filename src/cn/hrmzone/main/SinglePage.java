package cn.hrmzone.main;

import cn.hrmzone.util.OCRClient;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @Author:张生
 * @Blog:http://hrmnzone.cn
 * @Organization:荆州青年教育平台(https://jzyouth.com),专注职业资格培训、学历提升
 * @Description:
 * @Date:19-1-11
 */
public class SinglePage {
//    设置APPID/AK/SK
    public static final String APP_ID = "15356254";
    public static final String API_KEY = "BqYACe5k8Xw73QrO9f3RKXXY";
    public static final String SECRET_KEY = "o2iS5GTF53FbLnOoZiGKAXVBivGQHwu9";

    public static void main(String args[]) {
//        初始化一个AipOcr
        AipOcr client=new AipOcr(APP_ID,API_KEY,SECRET_KEY);

//         可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

//        需要进行识别的图片
        String path = "imgs/1.jpg";
//        传入可选参数调用接口
//        language_type：识别的语言类型，可设置文中英文
//                detect_direction：是否检测图片的方向
//                detect_language：检测识别的语言
//                probability：检测识别的语言
        HashMap<String,String> options=new HashMap<String,String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
//        options.put("detect_language", "true");
//        options.put("probability", "true");

//        调用接口
        JSONObject res = client.basicGeneral(path, options);
//        JSONObject res=client.basicAccurateGeneral(path,options);
//        System.out.println(res.toString(2));
        System.out.println("===========json content=================");
        /*
        解析调用结果
        1、res返回值是一个JSON，使用JSON工具进行解析；
        2、根据百度的返回值定义，内容是一个word_result的JSON数组jsonaray；
        3、根据数组长度，取得数组中的每一个对象，并根据key：words取得相应的内容。
         */
        JSONArray words_result=res.getJSONArray("words_result");
        int length=words_result.length();
        for(int i=0;i<length;i++) {
            JSONObject obj=words_result.getJSONObject(i);
            System.out.println(obj.get("words"));
        }

    }
}