package cn.myfreecloud.javautils.office.controller;

import org.apache.commons.io.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 处理用户数据请求的控制器类
 */
@RestController
@RequestMapping("upload")
public class FileController {


    //fileinput 其实每次只会上传一个文件  多图上传也是分多次请求,每次上传一个文件 所以不需要循环
    //@RequestParam("images") 这里的images对应表单中name 然后MultipartFile 参数名就可以任意了
    @RequestMapping(value = "/image/savefile", method = RequestMethod.POST)
    public void saveFile(@RequestParam("images") MultipartFile file) throws IOException {

        String pathname = "";

        String returnPath = "";

        if (!file.isEmpty()) {

            String fileName = file.getOriginalFilename();

            InputStream in = file.getInputStream();

            String path = "D:\\upload";

            String realName = "123.gif";

            FileOutputStream out = new FileOutputStream(path + "/" + realName);

            //两个流对拷
            IOUtils.copy(in, out);
            out.close();
            in.close();
        }
    }


    //fileinput 其实每次只会上传一个文件  多图上传也是分多次请求,每次上传一个文件 所以不需要循环
    //@RequestParam("images") 这里的images对应表单中name 然后MultipartFile 参数名就可以任意了
    @RequestMapping(value = "/image/save-test", method = RequestMethod.POST)
    public void saveImg(@RequestParam("images") MultipartFile[] uploadFile) throws IOException {

        //creating empty presentation
        XMLSlideShow ppt = new XMLSlideShow();

        for (MultipartFile multipartFile : uploadFile) {

            InputStream inputstream = multipartFile.getInputStream();

            XMLSlideShow src = new XMLSlideShow(inputstream);

            // 原比例合并
            Dimension pagesize = src.getPageSize();

            for (XSLFSlide srcSlide : src.getSlides()) {

//                XSLFSlideLayout slideLayout = srcSlide.getSlideLayout();
//                slideLayout.copyLayout(srcSlide);
                ppt.setPageSize(pagesize);
                //merging the contents
                ppt.createSlide().importContent(srcSlide);
            }

        }

        String result = "666.pptx";
        //creating the file object
        FileOutputStream out = new FileOutputStream(result);
        // saving the changes to a file
        ppt.write(out);
        System.out.println("Merging done successfully");
        out.close();
    }
}

