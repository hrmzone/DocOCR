package cn.hrmzone.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author:张生
 * @Blog:http://hrmnzone.cn
 * @Organization:荆州青年教育平台(https://jzyouth.com),专注职业资格培训、学历提升
 * @Description:生成一个以图片同名的txt文本文件，将OCR返回内容写入文件。
 * @Date:19-1-11
 */
public class FileUtil {
    private String fileName;

    public FileUtil(String fileName) {
        this.fileName = fileName+"_ocr.txt";
    }

    /**
     * 通过流将内容写入文本文件
     * @param content
     */
    public void writeTxt(String content) {
        Path path= Paths.get(fileName);
        try {
            BufferedWriter writer= Files.newBufferedWriter(path);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {

        }
    }
}