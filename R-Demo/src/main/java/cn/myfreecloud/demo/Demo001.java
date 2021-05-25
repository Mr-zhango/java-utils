package cn.myfreecloud.demo;

import java.io.File;

/**
 * 删除文件
 */
public class Demo001 {
    public static void main(String[] args) {
        boolean b = deleteFile("D:\\Desktop\\delete\\barchart_stacked.png");
        System.out.println(b);
    }

    /**
     * 删除单个文件
     *
     * @param sPath 被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        Boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

}
