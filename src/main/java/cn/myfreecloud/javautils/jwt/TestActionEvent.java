package cn.myfreecloud.javautils.jwt;

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent {

    public static void main(String[] args) {
        Frame frame = new Frame("TestActionEvent");

        Button button = new Button("Press Me");

        // 创建一个监听对象
        MyActionListener listener = new MyActionListener();

        // 把监听加入到按钮里面，监听按钮的动作，
        // 当按钮触发打击事件时，就会返回一个监听对象e
        // 然后就会自动执行actionPerformed方法
        button.addActionListener(listener);

        frame.add(button, BorderLayout.CENTER);
        frame.pack();

        addWindowClosingEvent(frame);

        frame.setVisible(true);

    }

    //点击窗体上的关闭按钮关闭窗体

    private static void addWindowClosingEvent(Frame frame){

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
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
