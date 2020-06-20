package cn.myfreecloud.javautils.office.word;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.Map;


/**
 * freemarker渲染xml，动态生成word文档
 */
@Slf4j
@Service
public class ExportWordUtils {

    private Configuration configuration;

    public ExportWordUtils() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
    }


    /**
     * @param templateData     模本数据
     * @param templateFileName 模版文件名(无后缀)
     * @param folderName       freemarker下级文件夹名称
     * @param exportFileName   导出文件名(无后缀)
     * @param response
     */
    public void createDoc(Map<String, Object> templateData, String templateFileName, String folderName, String exportFileName, HttpServletRequest request, HttpServletResponse response) {

        try {

            //获取template模板
            String basePackagePath = StringUtils.isEmpty(folderName) ? "/templates/freemarker" : "/templates/freemarker" + "/" + folderName;
            configuration.setClassForTemplateLoading(this.getClass(), basePackagePath);
            Template template = configuration.getTemplate(templateFileName + ".xml");

            //设置response，获取输出流
            ServletOutputStream responseOutputStream = response.getOutputStream();
            /**文件名乱码处理*/
            String fileNameRes = "";
            String userAgent = request.getHeader("user-agent").toLowerCase();
            if (userAgent.contains("msie") || userAgent.contains("edge") || userAgent.contains("trident")) {
                //IE
                fileNameRes = URLEncoder.encode(exportFileName, "UTF-8");
            } else {
                //非IE
                fileNameRes = new String(exportFileName.getBytes("UTF-8"), "iso-8859-1");
            }
            response.reset();
            response.setContentType("application/msword");
            fileNameRes = fileNameRes + ".doc";
            response.setHeader("Content-disposition", "attachment; filename=" + fileNameRes);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseOutputStream, "UTF-8"));
            //模板渲染数据
            template.process(templateData, bufferedWriter);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}