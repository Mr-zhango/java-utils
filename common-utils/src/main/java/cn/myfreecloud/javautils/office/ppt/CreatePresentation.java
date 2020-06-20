package cn.myfreecloud.javautils.office.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreatePresentation {
   
   public static void main(String args[]) throws IOException{
   
      //creating a new empty slide show
      XMLSlideShow ppt = new XMLSlideShow();	     
      
      //creating an FileOutputStream object
      File file =new File("example1.pptx");
      FileOutputStream out = new FileOutputStream(file);
      
      //saving the changes to a file
      ppt.write(out);
      System.out.println("Presentation created successfully");
      out.close();
   }
}