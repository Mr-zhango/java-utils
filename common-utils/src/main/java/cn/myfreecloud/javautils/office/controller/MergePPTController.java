package cn.myfreecloud.javautils.office.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/ppt")
public class MergePPTController {

    /**
     * 跳转:单文件添加
     *
     * @return
     */
    @GetMapping("/signalFileAdd")
    public String tosignalFileAdd(Model model) {
        return "signalFileUpload";
    }


    /**
     * 跳转:多文件添加
     *
     * @return
     */
    @GetMapping("/multipalFileAdd")
    public String tomultipalFileAdd(Model model) {
        return "multipalFileUpload";
    }

}
