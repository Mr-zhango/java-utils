package cn.myfreecloud.javautils.jwt;

//QQ登录界面制作
import java.awt.*;
import javax.swing.*;

public class Demo16 extends JFrame {

    // 北部区域
    JLabel jl1;

    // 南部区域
    JButton jb1, jb2, jb3;
    JPanel jp1;

    // 中部区域
    JTabbedPane jtp;// 选项卡窗格
    JPanel jp2, jp3, jp4;

    JLabel jl2, jl3, jl4, jl5;
    // 号码输入文本框
    JTextField jtf;
    // 密码
    JPasswordField jpf;
    // 清除号码
    JButton jb4;
    // 隐身登录、记住密码
    JCheckBox jcb1, jcb2;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Demo16();

    }

    public Demo16() {

        // 创建组件
        jl2 = new JLabel("QQ号码", JLabel.CENTER);
        jl3 = new JLabel("QQ密码", JLabel.CENTER);
        jl4 = new JLabel("忘记密码", JLabel.CENTER);
        jl4.setFont(new Font("宋体", Font.PLAIN, 16));// 设置字体样式
        jl4.setForeground(Color.BLUE);// 设置字体颜色
        jl5 = new JLabel("<html><a href='www.qq.com'>申请密码保护</a></html>");
        // 鼠标触发变化
        jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jtf = new JTextField();
        jpf = new JPasswordField();
        jb4 = new JButton(new ImageIcon("images\\login.png"));

        jcb1 = new JCheckBox("隐身登录");
        jcb2 = new JCheckBox("记住密码");

        // 北部区域
        jl1 = new JLabel(new ImageIcon("images\\headpicture.jpg"));

        // 南部区域
        jp1 = new JPanel();
        jb1 = new JButton(new ImageIcon("images\\login.png"));
        jb2 = new JButton(new ImageIcon("images\\delete.png"));
        jb3 = new JButton(new ImageIcon("images\\register.png"));

        // 中部区域
        jtp = new JTabbedPane();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp3.setBackground(Color.RED);// 给面板设置背景
        jp4 = new JPanel();
        jp4.setBackground(new Color(0, 0, 255));

        // 将面板添加到选项卡窗格上
        jtp.add("QQ号码", jp2);// 参数：选项卡名称，面板
        jtp.add("手机号码", jp3);
        jtp.add("电子邮箱", jp4);

        // 设置布局
        jp2.setLayout(new GridLayout(3, 3));

        // 添加组件
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);

        jp2.add(jl2);
        jp2.add(jtf);
        jp2.add(jb4);
        jp2.add(jl3);
        jp2.add(jpf);
        jp2.add(jl4);
        jp2.add(jcb1);
        jp2.add(jcb2);
        jp2.add(jl5);

        this.add(jp1, BorderLayout.SOUTH);
        this.add(jl1, BorderLayout.NORTH);
        this.add(jtp, BorderLayout.CENTER);

        // 展示组件
        ImageIcon icon = new ImageIcon("images\\qq.png");
        this.setIconImage(icon.getImage());// 给窗体设置图标方法
        this.setSize(400, 380);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}