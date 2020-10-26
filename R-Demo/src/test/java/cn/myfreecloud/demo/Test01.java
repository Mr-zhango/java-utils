package cn.myfreecloud.demo;

import org.junit.Test;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class Test01 {


    /**
     * 读取.csv文件的数据然后进行绘图
     */
    @Test
    public void test02() {
        String host = "127.0.0.1";
        int port = 6311;

        //连接 R
        RConnection connection = null;
        try {
            connection = new RConnection(host, port);
            connection.setStringEncoding("utf8");

            //connection.eval("setwd('D:/Desktop/radar-new')");
            connection.eval("data <- read.csv('D:/Desktop/radar-new/source.csv')");
            connection.eval("isData <- subset(data, data$Identification=='Is')");
            connection.eval("hightData <- isData$Height.m.");
            connection.eval("png(file = 'D:/Desktop/radar-new/111/hight.png')");
            connection.eval("plot(density(hightData))");
            connection.eval("while (!is.null(dev.list()))  dev.off()");

        } catch (RserveException e) {
            e.printStackTrace();
        } finally {
            //记得关闭连接，否则内存的资源不被释放，会引起进程冲突
            connection.close();
        }

    }

    /**
     * 读取mysql的数据然后进行绘图
     */
    @Test
    public void test03Mysql() {
        String host = "127.0.0.1";
        int port = 6311;
        //连接 R
        RConnection connection = null;
        try {
            connection = new RConnection(host, port);
            connection.setStringEncoding("utf8");
            connection.eval("library(RMySQL)");
            connection.eval("mysqlconnection = dbConnect(MySQL(), user = 'root', password = '123456', dbname = 'renren_fast',host = 'localhost')");
            connection.eval("result = dbSendQuery(mysqlconnection, 'select * from radar_localtion')");
            connection.eval("data.frame = fetch(result, n = 5)");
            connection.eval("isData <- data.frame$id");
            connection.eval("hightData <- isData");
            connection.eval("png(file = 'D:/Desktop/radar-new/111/hight.png')");
            connection.eval("plot(density(hightData))");
            connection.eval("while (!is.null(dev.list()))  dev.off()");
        } catch (RserveException e) {
            e.printStackTrace();
        } finally {
            //记得关闭连接，否则内存的资源不被释放，会引起进程冲突
            connection.close();
        }

    }
}
