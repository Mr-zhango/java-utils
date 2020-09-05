package cn.myfreecloud.fastdfs;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        File text = new File("D:\\Desktop\\1.txt");

        String s = openTextFile(text);

        String str = s;

        String dest = "";

        if (str != null) {

            str.replaceAll("[\\t]", "[\r\n]");
        }

        System.out.println(str);
    }


    public static String openTextFile(File source) {

        StringBuffer text = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader(source));
            String info = null;
            while ((info = br.readLine()) != null) {
                text.append(info + "\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("文件未找到");
        } catch (IOException e) {
            System.err.println("文件读取出错");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return text.toString();
    }
}
