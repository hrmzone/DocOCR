package cn.hrmzone.test;
import cn.hrmzone.util.FileUtil;
import cn.hrmzone.util.ImgList;
import cn.hrmzone.util.OCRClient;
import com.baidu.aip.ocr.AipOcr;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class ClientTest {
    public static final String APP_ID = "15356254";
    public static final String API_KEY = "BqYACe5k8Xw73QrO9f3RKXXY";
    public static final String SECRET_KEY = "o2iS5GTF53FbLnOoZiGKAXVBivGQHwu9";
    AipOcr client;
    String path;
    String content;
    FileUtil fileUtil;
    ImgList imgList;
    ArrayList<String> fileList;


    @Before
    public void init() {
        client=new AipOcr(APP_ID,API_KEY,SECRET_KEY);
        path="imgs/1.jpg";
        fileUtil=new FileUtil(path);
    }

    @Ignore
    @Test
    public void resWords() {
        OCRClient ocr=new OCRClient(client,path);
        content=ocr.getWords();
        System.out.println(content);
        fileUtil.writeTxt(content);
    }

    @Test
    public void multiOcr() {
        imgList=new ImgList("imgs");
        fileList=imgList.getFileList();
        System.out.println(fileList.toString());
        for(int i=0;i<fileList.size();i++) {
            String fileName=fileList.get(i);
            OCRClient ocr=new OCRClient(client,fileName);
            FileUtil util=new FileUtil(fileName);
            util.writeTxt(ocr.getWords());
        }
    }
}