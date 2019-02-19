package stdio.imis;

import javax.swing.*;

public class JF_Demo extends JFrame {
    JButton jButton;

    public JF_Demo(){
        jButton=new JButton("这是一个按钮");
        this.add(jButton);
        this.setTitle("this is a title.");
        this.setLocation(200,300);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JF_Demo.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
