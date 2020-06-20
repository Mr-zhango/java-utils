package cn.myfreecloud.javautils.office.ppt.yuanjie;//package cn.myfreecloud.cn.myfreecloud.utils.office.ppt.yuanjie;
//
//import com.spire.presentation.*;
//
//import com.spire.presentation.drawing.FillFormatType;
//
//import java.awt.geom.Rectangle2D;
//
//public class AddImg_PPT {
//
//public static void main(String[] args) throws Exception {
//
////创建Presentation实例，并加载需要添加图片的文档
//
//        Presentation ppt = new Presentation();
//
//        ppt.loadFromFile("test.pptx");
//
//
//        Rectangle2D rect1 = new Rectangle2D.Double(ppt.getSlideSize().getSize().getWidth() / 2 - 180, 140, 400, 220);
//
//        Rectangle2D rect2 = new Rectangle2D.Double(ppt.getSlideSize().getSize().getWidth() / 2 - 120, 110, 280, 280);
//
//        //获取第一张幻灯片
//
//        ISlide slide = ppt.getSlides().get(0);
//
//        //插入图片
//
//        IEmbedImage image = slide.getShapes().appendEmbedImage(ShapeType.RECTANGLE, "img1.png", rect1);
//
//        image.getLine().setFillType(FillFormatType.NONE);
//
//        //添加一张新的幻灯片
//
//        slide = ppt.getSlides().append();
//
//        //插入图片到幻灯片
//
//        image = slide.getShapes().appendEmbedImage(ShapeType.RECTANGLE, "img2.png", rect2);
//
//        image.getLine().setFillType(FillFormatType.NONE);
//
//        //保存文档
//
//        ppt.saveToFile("AddImages.pptx", FileFormat.PPTX_2013);
//   }
//
//}