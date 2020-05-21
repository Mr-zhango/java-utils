package cn.myfreecloud.javautils.jwt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent {

    public static void main(String[] args) {

        JFrame window1 =new JFrame("测试窗口"); //创建一个window1对象

        Container con = window1.getContentPane(); //调用容器的方法
        con.setBackground(Color.BLACK); //设置窗口的背景颜色
        window1.setVisible(true);//设置窗口可视化
        window1.setSize(800, 600); //设置生成窗口的大小
        window1.setLocation(380, 50);//设置生成窗口在屏幕上的位置
        window1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口的关闭功能

        Button button = new Button("Press Me");

        // 创建一个监听对象
        MyActionListener listener = new MyActionListener();

        // 把监听加入到按钮里面，监听按钮的动作，
        // 当按钮触发打击事件时，就会返回一个监听对象e
        // 然后就会自动执行actionPerformed方法
        button.addActionListener(listener);
        window1.add(button, BorderLayout.CENTER);
    }
}

// 自定义Monitor(监听)类实现事件监听接口ActionListener
// 一个类要想成为监听类，那么必须实现ActionListener接口
class MyActionListener implements ActionListener{

    //重写ActionListener接口里面的actionPerformed(ActionEvent e)方法
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("A Button has been Pressed");
    }
}
