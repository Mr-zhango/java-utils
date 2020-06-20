package cn.myfreecloud.javautils.jwt;

import java.awt.*;
import javax.swing.*;

public class Demo10 extends JFrame {
    // 定义组件
    JPanel jp1, jp2;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;

    public static void main(String[] args) {
        Demo10 de = new Demo10();
    }

    // 构造函数
    public Demo10() {
        // 创建组件

        jp1 = new JPanel();
        jp2 = new JPanel();

        jb1 = new JButton("西瓜");
        jb2 = new JButton("苹果");
        jb3 = new JButton("荔枝");
        jb4 = new JButton("葡萄");
        jb5 = new JButton("桔子");
        jb6 = new JButton("香蕉");

        // 设置布局管理器，
        //JPanel布局默认是BorderLoyout// 添加JPanel
        //JPanel属于容器类组件，可以加入别的组件
        jp1.add(jb1);
        jp1.add(jb2);
        
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);

        // 把jpanel 加入JFrame
        this.add(jp1, BorderLayout.NORTH);
        this.add(jb6, BorderLayout.CENTER);
        this.add(jp2, BorderLayout.SOUTH);

        this.setSize(300, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}