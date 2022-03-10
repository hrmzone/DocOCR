package cn.hrmzone.util;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 解析文件地址，获取输入文件路径的目录和文件名
 */
public class FileNameParser {

    public static String getPath(String s) {
        Path path= Paths.get(s);
        return path.getParent().toString();
    }

    public static String getName(String s) {
        Path path= Paths.get(s);
        String name=path.getFileName().toString();
        String subName=name.split("\\.")[0];
        return subName;
    }

    public static void main(String[] args) {
        System.out.println(getPath("F:\\道恒共建\\2022\\21一分一档线\\对口电子电工\\0002.jpg"));
        System.out.println(getName("F:\\道恒共建\\2022\\21一分一档线\\对口电子电工\\0002.jpg"));
        System.out.println(getPath("F:\\道恒共建\\2022\\21一分一档线\\对口电子电工\\0002.jpg")+ File.separator+getName("F:\\道恒共建\\2022\\21一分一档线\\对口电子电工\\0002.jpg")+".xlsx");
    }
}
