package cn.hrmzone.test;

import cn.hrmzone.util.FileUtil;
import cn.hrmzone.util.ImgList;
import cn.hrmzone.table.TableOcr;
import com.baidu.aip.ocr.AipOcr;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class TableTest {
    public static final String APP_ID = "15356254";
    public static final String API_KEY = "BqYACe5k8Xw73QrO9f3RKXXY";
    public static final String SECRET_KEY = "o2iS5GTF53FbLnOoZiGKAXVBivGQHwu9";
    AipOcr client;
    String path;
    String content;
    FileUtil fileUtil;
    ImgList imgList;

    @Before
    public void init() {
        client=new AipOcr(APP_ID,API_KEY,SECRET_KEY);
        path="F:\\道恒共建\\2022\\21一分一档线\\对口电子电工\\0002.jpg";
    }

    @Ignore
    public void singlePic() {
        TableOcr ocr=new TableOcr(client,path);
        ocr.writeFile();

    }

    @Test
    public void multiPic() {
        String path="F:\\道恒共建\\2022\\21一分一档线\\音乐";
        ImgList imgList=new ImgList(path);
        ArrayList<String> arrayList= imgList.getFileList();
        for(String s:arrayList) {
            TableOcr ocr=new TableOcr(client,s);
            ocr.writeFile();
        }
    }
}
