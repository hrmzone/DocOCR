package cn.hrmzone.util;

import java.io.File;
import java.util.ArrayList;

/**
 * @Author:张生
 * @Blog:http://hrmnzone.cn
 * @Organization:荆州青年教育平台(https://jzyouth.com),专注职业资格培训、学历提升
 * @Description:获取目录下的全部图片文件，供ocr识别上传使用。
 * @Date:19-1-11
 */
public class ImgList {


    private String dir;
    private ArrayList<String> fileList;

    public String getDir() {
        return dir;
    }
    public ImgList(String dir) {
        this.dir = dir;
        fileList=new ArrayList<String>();
    }

    /**
     * 判断文件是否为图片
     * @param file
     * @return
     */
    private boolean isImage(File file) {
        String fileName=file.getName();
        boolean flag=false;
        if(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg") || fileName.endsWith(".JPG")) {
            flag=true;
        }
        return flag;
    }

    /**
     * 1、遍历当前目录，将图片文件名状入数组返回
     * 2、返回文件名为目录下的图片文件完整路径名
     * @return
     */
    public ArrayList<String> getFileList() {
        File file=new File(dir);
        File[] files=file.listFiles();
        for(int i=0;i<files.length;i++) {
            File f=files[i];
            if(f.isFile() && isImage(f)) {
                fileList.add(getDir()+File.separator+f.getName());
            }

        }

        return fileList;
    }

    public static void main(String[] args) {
        ImgList iList=new ImgList("imgs");
        System.out.println(iList.getFileList());
    }
}