package cn.myfreecloud.javautils.office.ppt.yuanjie;//package cn.myfreecloud.cn.myfreecloud.utils.office.ppt.yuanjie;
//
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.sl.usermodel.PictureData;
//import org.apache.poi.xslf.usermodel.XMLSlideShow;
//import org.apache.poi.xslf.usermodel.XSLFPictureShape;
//import org.apache.poi.xslf.usermodel.XSLFSlide;
//
//import java.awt.*;
//import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Test {
//    public static void main(String[] args) throws Exception {
//        XMLSlideShow pptx = new XMLSlideShow(OPCPackage.open(new FileInputStream("E:\\empty.pptx")));
//
//        //ppt模板        先把所有图片插入到ppt中        
//        List<String> indexList = new ArrayList<String>(); //存储图片索引        
//        String path = "E:\\ppt\\pic\\"; //图片路径       
//        String[] pic = new String[30]; //30张图片       
//        for (int m = 0; m < 30; m++) {
//            File file = new File(path + (i + 1) + ".JPG");
//            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
//            ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
//            int size = 0;
//            byte[] temp = new byte[1024];
//            while ((size = in.read(temp)) != -1) {
//                out.write(temp, 0, size);
//            }
//            in.close();
//            byte[] content = out.toByteArray();
//            int newIndex = pptx.addPicture(content, PictureData.PictureType.JPEG);
//            indexList.add(String.valueOf(index + 1));
//            //存储图片索引      
//        }
//
//        Collections.sort(indexList);
//        //按字典序把(inex+1)进行排序      把图片插入到slide指定的位置      
//        for (int m = 0; m < pptx.getAllPictures().size(); m++) {
//            XSLFSlide slide = pptx.createSlide();
//
//            XSLFPictureShape picShape = slide.createPicture(indexList.indexOf(String.valueOf((m + 1))));
//            //返回(index+1)在列表中的字典序                
//            picShape.setAnchor(new Rectangle(20, 20, 500, 500));
//            picShape.setLineWidth(0);
//        }
//    }
//}
