package cn.hrmzone.main;

import cn.hrmzone.util.OCRAction;

/**
 * @Author:张生
 * @Blog:http://hrmnzone.cn
 * @Organization:荆州青年教育平台(https://jzyouth.com),专注职业资格培训、学历提升
 * @Description:使用百度OCR接口，批量识别指定目录下的文件，并将返回值写入相应的文件。
 * @Date:19-1-11
 */
public class DocOCR {
    public static void main(String[] args) {
        OCRAction action;
        if(args[0].equalsIgnoreCase("-f")) {
            action=new OCRAction(args[1]);
            action.actionFile();
        } else if(args[0].equalsIgnoreCase("-d")) {
            action=new OCRAction(args[1]);
            action.actionDir();
        } else if(args[0].equalsIgnoreCase("-h")) {
            System.out.println("使用方法:");
            System.out.println("1.单个图片识别：[ java -jar DocOCR.jar -f filename ]"+"\t 识别指定图片文件:filename");
            System.out.println("2.批量图片识别：[ java -jar DocOCR.jar -d filepath ]"+"\t 识别指定目录中的全部图片:filepath");
        } else {
            System.out.println("警告：无法识别你的输入。");
            System.out.println("1.单个图片识别：[ java -jar DocOCR.jar -f filename ]"+"\t 识别指定图片文件:filename");
            System.out.println("2.批量图片识别：[ java -jar DocOCR.jar -d filepath ]"+"\t 识别指定目录中的全部图片:filepath");
        }
    }
}