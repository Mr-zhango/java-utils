//package cn.myfreecloud;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//import javax.jms.*;
//
///**
// * @author: zhangyang
// * @date: 2019/5/11 23:52
// * @description:
// */
//public class QueueProducer {
//
//
//    public static void main(String[] args) throws Exception {
//        // 后台管理 端口 8161
//        //客户端连接服务端 61616
//
//        //1.创建连接工厂
//        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(
//                "tcp://192.168.200.128:61616");
//        //2.获取连接
//        Connection connection = connectionFactory.createConnection();
//        //3.启动连接
//        connection.start();
//
//
//
//
//        //4.获取session  (参数1：是否启动事务,参数2：消息确认模式)
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        //5.创建队列对象
//        Queue queue = session.createQueue("test-queue");
//        //6.创建消息生产者
//        MessageProducer producer = session.createProducer(queue);
//        //7.创建消息
//        TextMessage textMessage = session.createTextMessage("欢迎来到神奇的品优购世界666");
//        //8.发送消息
//        producer.send(textMessage);
//        //9.关闭资源
//        producer.close();
//        session.close();
//        connection.close();
//
//    }
//}
