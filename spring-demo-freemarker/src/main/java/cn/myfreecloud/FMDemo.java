package cn.myfreecloud;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

/**
 *
 * @author zhangyang
 *
 *  静态化的主程序
 */
public class FMDemo {

    /**
     * 静态化技术程序
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) throws Exception {

		//Freemarker
		Configuration configuration = new Configuration(Configuration.getVersion());
		//模板+数据 == 输出
		//ftl  .html .java .txt .xml .properties  
		//配置模板所在目录
		String dir = "C:\\develop\\IDEA\\JavaWEB\\spring-demo-freemarker\\ftl\\";
		configuration.setDirectoryForTemplateLoading(new File(dir));
		//模板目录下 会有很多个模板
		Template template = configuration.getTemplate("freemarker.html");
		//加载数据
		Map root = new HashMap<>();
		/*为null的时候的判断*/
		root.put("name", null);
		root.put("isSuccess", "true");
		
		
		//List
		List<String> list = new ArrayList<>();
		list.add("李晨");
		list.add("邓越");
		list.add("angularjs");
		root.put("list", list);
		
		List<Map> goodsList  = new ArrayList<>();
		
		Map goods1=new HashMap();
		goods1.put("name", "苹果");
		goods1.put("price", 5.8);
		Map goods2=new HashMap();
		goods2.put("name", "香蕉");
		goods2.put("price", 2.5);
		Map goods3=new HashMap();
		goods3.put("name", "橘子");
		goods3.put("price", 3.2);
		goodsList.add(goods1);
		goodsList.add(goods2);
		goodsList.add(goods3);
		
		root.put("goodsList", goodsList);
		
		root.put("cur_time", new Date());
		
		//数字是什么格式?
		// 1,110,000 真正的数字格式 Freemarker是底层
		root.put("point",12345678);
		
		

		//输出
		Writer out = new FileWriter(new File(dir + "hello.html"));
		//处理
		template.process(root, out);
		
		System.out.println("完成生成");
		
	}
}
