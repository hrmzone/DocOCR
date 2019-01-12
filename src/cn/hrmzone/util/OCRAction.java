package cn.hrmzone.util;

import com.baidu.aip.ocr.AipOcr;

import java.util.ArrayList;

/**
 * @Author:张生
 * @Blog:http://hrmnzone.cn
 * @Organization:荆州青年教育平台(https://jzyouth.com),专注职业资格培训、学历提升
 * @Description:根据传入的路径(path)参数，将当前路径目录下的全部文件使用百度OCR接口识别为文字，并保存在同名txt文件中。
 * 流程：
 * 1.扫描目录图片文件(ImgList)
 * 2.将图片文件逐个上传至百度OCR进行识别(OCRClient);
 * 3.将图片识别内容保存至图片同名txt文件中(FileUtil)；
 * @Date:19-1-11
 */
public class OCRAction {
    private String path;
    private ArrayList<String> fileList;
    private OCRClient client;
    private FileUtil fileUtil;
    private ImgList imgList;
    private AipOcr aipOcr;
    public static final String APP_ID = "15356254";
    public static final String API_KEY = "BqYACe5k8Xw73QrO9f3RKXXY";
    public static final String SECRET_KEY = "o2iS5GTF53FbLnOoZiGKAXVBivGQHwu9";

    public OCRAction(String path) {
        this.path = path;
        aipOcr=new AipOcr(APP_ID,API_KEY,SECRET_KEY);

    }

    public void actionDir() {
        imgList=new ImgList(path);
        fileList=imgList.getFileList();
        for(int i=0;i<fileList.size();i++) {
            String fileName=fileList.get(i);
            client=new OCRClient(aipOcr,fileName);
            fileUtil=new FileUtil(fileName);
            fileUtil.writeTxt(client.getWords());
        }
    }


    public void actionFile() {
        client=new OCRClient(aipOcr,path);
        fileUtil=new FileUtil(path);
        fileUtil.writeTxt(client.getWords());
    }
}