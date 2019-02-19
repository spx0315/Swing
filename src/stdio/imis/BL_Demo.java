package stdio.imis;

import javax.swing.*;
import java.awt.*;

public class BL_Demo extends JFrame{
    //首先还是定义控件
    //为了能够显示效果我们多定义几个按钮
    //那就上下左右中五个好了
    JButton jb1,jb2,jb3,jb4,jb5;
    //然后在构造函数中进行窗口的初始化
    public BL_Demo(){
        //创建控件
        jb1 = new JButton("这里是上");
        jb2 = new JButton("这里是下");
        jb3 = new JButton("这里是左");
        jb4 = new JButton("这里是右");
        jb5 = new JButton("这里是中间");

        //添加控件
        //边界式布局嘛，BorderLayout，控制方向
        //遵循上北下南左西右东
        this.add ( jb1, BorderLayout.NORTH );
        this.add ( jb2,BorderLayout.SOUTH );
        this.add ( jb3,BorderLayout.WEST );
        this.add ( jb4,BorderLayout.EAST );
        //最后中间是C位嘛，就是Center
        this.add( jb5,BorderLayout.CENTER );

        //然后后面就跟之前的是一样了
        //设置窗口属性，然后显示窗体
        //我们直接复制过来算了

        //设置窗口属性
        this.setTitle ( "BorderLayout_demo" );
        this.setSize ( 800,600 );
        this.setLocation ( 300,200 );
        this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );

        //显示窗体
        this.setVisible ( true );

        //好让我们来启动一下
        //大概就长这样
        //有点丑 但是算了 嘤
    }
}
