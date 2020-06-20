package cn.myfreecloud.javautils.regex;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  把图片插入ppt
 */
public class AddingImageToPPTXMultiFile {
    public static void main(String args[]) throws IOException {

        // creating a presentation
        XMLSlideShow ppt = new XMLSlideShow();

        // 原比例合并
        Dimension pagesize = new Dimension();
        pagesize.setSize(960,540);
        ppt.setPageSize(pagesize);

        // creating a slide in it
        // XSLFSlide slide =

        // reading an image
        File image = new File("C:\\Users\\zhangyang\\Desktop\\demo");

        String[] listFile = image.list();

        for (String file : listFile) {
            File readfile = new File("C:\\Users\\zhangyang\\Desktop\\demo" + "\\" + file);
            // converting it into a byte array
            byte[] picture = IOUtils.toByteArray(new FileInputStream(readfile));
            // adding the image to the presentation
            XSLFPictureData idx = ppt.addPicture(picture, PictureData.PictureType.JPEG);
            // creating a slide with given picture on it
            ppt.createSlide().createPicture(idx);
        }


        // creating a file object
        File file = new File("AddingimageToPPT.pptx");
        FileOutputStream out = new FileOutputStream(file);

        // saving the changes to a file
        ppt.write(out);

        System.out.println("image added successfully");
        out.close();
    }

}