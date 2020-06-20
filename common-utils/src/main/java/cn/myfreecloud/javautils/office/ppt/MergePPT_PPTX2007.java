package cn.myfreecloud.javautils.office.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MergePPT_PPTX2007 {

    public static void main(String args[]) throws IOException{

        String file1 = "E:\\pptmerge\\x1.pptx";
        String file2 = "E:\\pptmerge\\x2.pptx";

        FileInputStream is = new FileInputStream(file1);
        XMLSlideShow src = new XMLSlideShow(is);
        is.close();
        FileInputStream is2 = new FileInputStream(file2);
        XMLSlideShow src2 = new XMLSlideShow(is2);
        is2.close();

        XMLSlideShow ppt = new XMLSlideShow();
        for (XSLFSlide slide : src.getSlides()) {
            XSLFSlide slide1 = ppt.createSlide(slide.getSlideLayout());
            slide1.importContent(slide);
        }
        for (XSLFSlide slide : src2.getSlides()) {
            ppt.createSlide(slide.getSlideLayout()).importContent(slide);
        }

        FileOutputStream out = new FileOutputStream("merged2.pptx");
        ppt.write(out);
        out.close();
        System.out.println("merge successfully");
    }
}