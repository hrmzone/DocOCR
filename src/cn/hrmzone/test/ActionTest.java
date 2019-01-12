package cn.hrmzone.test;

import cn.hrmzone.util.OCRAction;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @Author:张生
 * @Blog:http://hrmnzone.cn,QQ:78049500
 * @Organization:荆州青年教育平台(https://jzyouth.com),专注职业资格培训、学历提升
 * @Description:
 * @Date:19-1-11
 */
public class ActionTest {
    private String path;
    private String file;
    private OCRAction action;

    @Before
    public void init() {
        path="/home/neal/桌面/ao";
        file="/home/neal/桌面/ao/1.jpg";
    }

    @Ignore
    @Test
    public void pathTest() {
        action=new OCRAction(path);
        action.actionDir();
    }

    @Test
    public void fileTest() {
        action=new OCRAction(file);
        action.actionFile();
    }
}