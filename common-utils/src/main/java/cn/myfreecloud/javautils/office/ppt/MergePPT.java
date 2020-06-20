package cn.myfreecloud.javautils.office.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MergePPT {

    public static void main(String args[]) throws IOException{

        //creating empty presentation

        //taking the two presentations that are to be merged
        String file1 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\2016测试pptx.pptx";
//        String file2 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\2016版ppt2.pptx";
//        String file3 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\Xp_07版本测试.pptx";
//        String file4 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\xp_o3.ppt";
//        String file5 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\2016pptxmerge测试.pptx";
//        String file5 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\11111.ppt";
//        String file5 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\【元杰测试-2003编辑模板】.pptx";
//        String file5 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\Dan(1).pptx";
//        String file5 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\C-ppt(1)(1).pptx";
//        String file5 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\lastOnepptx.pptx";
//        String file4 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\3.pptx";
//        String file5 = "C:\\develop\\IDEAProjects\\MyProjects\\java-utils\\src\\main\\resources\\static\\file\\4.pptx";
//        String[] inputs = {file1, file2,file3,file4};
        String[] inputs = {file1};


        XMLSlideShow ppt = new XMLSlideShow();

        for(String arg : inputs){

            FileInputStream inputstream = new FileInputStream(arg);
            XMLSlideShow src = new XMLSlideShow(inputstream);


            // 原比例合并
            Dimension pagesize = src.getPageSize();



            for(XSLFSlide srcSlide : src.getSlides()){

//                XSLFSlideLayout slideLayout = srcSlide.getSlideLayout();
//                slideLayout.copyLayout(srcSlide);
                ppt.setPageSize(pagesize);
                //merging the contents
                ppt.createSlide().importContent(srcSlide);
            }

//            for(XSLFSlide srcSlide : src.getSlides()){
//
////                XSLFSlideLayout slideLayout = srcSlide.getSlideLayout();
////                slideLayout.copyLayout(srcSlide);
//                ppt.setPageSize(pagesize);
//                //merging the contents
//                ppt.createSlide().importContent(srcSlide);
//            }
        }

        String result = "4.pptx";

        //creating the file object
        FileOutputStream out = new FileOutputStream(result);

        // saving the changes to a file
        ppt.write(out);
        System.out.println("Merging done successfully");
        out.close();
    }
}