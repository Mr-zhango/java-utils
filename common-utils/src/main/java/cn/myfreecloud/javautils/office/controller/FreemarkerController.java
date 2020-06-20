package cn.myfreecloud.javautils.office.controller;

import cn.myfreecloud.javautils.office.word.ExportWordUtils;
import cn.myfreecloud.javautils.office.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 *
 * 测试freemarker及动态生成word文档
 * word文档导出API
 */
@Slf4j
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    private ExportWordUtils exportWordUtils;

    @RequestMapping(value = "/jsonTest")
    @ResponseBody
    public String jsonTest(){
        return "hello";
    }

    /**
     * freemarker页面静态化
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/toFreemarkerPage")
    public String toPage(ModelMap modelMap){

        /**
         * 基本
         */
        Map<String,Object> resMap=new HashMap<>();
        resMap.put("name","Jack");
        resMap.put("language","Chinese");
        resMap.put("success",true);
        resMap.put("birthday",new Date());
        resMap.put("styleShow","<font color = 'red'>菜单</font>");
        resMap.put("age","100");
        modelMap.put("user",resMap);

        /**
         * list对象
         */
        List<UserDTO> userList= new ArrayList<>();
        UserDTO userDTO=new UserDTO();

        userDTO.setName("zhangsan");
        userDTO.setCellphone("17600365555");
        userDTO.setEmail("123456@qq.com");


        UserDTO userDTO2=new UserDTO();
        userDTO2.setName("Jack");
        userDTO2.setCellphone("17600365555");
        userDTO2.setEmail("41485@qq.com");


        userList.add(userDTO);
        userList.add(userDTO2);
        // list中两个元素
        modelMap.put("userList",userList);

        //模板资源路径 classpath
        return "freemarker/demo";
    }


    /**
     * 动态导出 测试freemarker渲染xml，动态生成word
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/exportword")
    public void exportWord(HttpServletRequest request, HttpServletResponse response){
        //封装数据
        Map<String,Object> templateData=new HashMap<>();
        templateData.put("title","简历");
        templateData.put("name","张三");
        templateData.put("age","18");
        templateData.put("phone","176000000000");
        templateData.put("address","北京市朝阳区");
        templateData.put("tech","写bug");
        exportWordUtils.createDoc(templateData,"testExportWord","","测试word",request,response);
    }

}
