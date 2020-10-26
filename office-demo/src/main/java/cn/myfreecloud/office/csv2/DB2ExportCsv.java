package cn.myfreecloud.office.csv2;
import com.csvreader.CsvReader;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB2ExportCsv {
    /**
     * 读取CSV文件
     *
     * @param con         数据库访问
     * @param csvFilePath 文件路径
     */
    public static void readCsv(String csvFilePath) {

        RadarData radarData = null;
        try {
           // String sql = "INSERT INTO app_stock_news(title,external_links,create_time,news_time,stock_code,stock_name,content) VALUES(?,?,?,?,?,?,?)";
            //PreparedStatement pStatement = con.prepareStatement(sql);

            ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
            //生成CsvReader对象，以，为分隔符，GBK编码方式
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("gbk"));    //一般用这编码读就可以了
            reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。
            //逐条读取记录，直至读完
            while (reader.readRecord()) {
                radarData = new RadarData();
                radarData.setCode(reader.get("code"));
                radarData.setShort_name(reader.get("short_name"));
                radarData.setName(reader.get("name"));
                radarData.setRemark(reader.get("remark"));
                radarData.setParent_id(reader.get("parent_id"));
                radarData.setType_name(reader.get("type_name"));
                System.out.println(radarData.toString());
            }
            reader.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

//    写入CSV文件，无追加功能，所以每次都得重新写（包括表头）：
//
//    1 CsvWriter wr =new CsvWriter("F://Eclipse//Test//src//info.csv",',',Charset.forName("GBK"));
//    2         String[] contents = {"Lily","五一","90","女"};                    
//    3         wr.writeRecord(contents);
//    4         wr.close();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String csvFilePath = "D:\\Desktop\\radar\\sourceone.csv";
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/tradergem_news", "root", "123456");
//        System.out.println("数据库连接成功！");

        readCsv(csvFilePath);

        System.out.println("数据导入完成!");
    }

} 