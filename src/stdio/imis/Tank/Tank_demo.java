package stdio.imis.Tank;

import stdio.imis.model.MyPanel;

import javax.swing.*;
import java.awt.*;

public class Tank_demo extends JFrame {
    //控件的话，一个面板就好啦
    MyPanel mp;

    public static void main(String[] args) {
        Tank_demo demo = new Tank_demo();
    }

    public Tank_demo() {
        mp = new MyPanel();//创建
        mp.setBackground(Color.black);//底色
        this.add(mp);//添加
        //设置窗体
        this.setTitle("Tank Battle");
        this.setSize(500, 500);
        this.setLocation(400, 470);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}