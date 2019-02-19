package stdio.imis.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {

    public Tank myTank;

    public MyPanel() {
        myTank = new Tank(300, 150);
    }

    @Override
    //这里，Graphics 相当于一只画笔
    public void paint(Graphics g) {
        //调用父类完成初始化
        super.paint(g);

        g.setColor(Color.blue);
        //然后就可以在这里面画画啦

        drawTank(myTank.getx(), myTank.gety(), myTank.getDirection(), g);
    }

    public void drawTank(int x, int y, int direction, Graphics g) {
        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.drawOval(x + 7, y + 12, 5, 5);
                g.drawLine(x + 10, y + 10, x + 10, y + 2);
                g.drawLine(x, y + 3, x + 5, y + 3);
                g.drawLine(x, y + 10, x + 5, y + 10);
                g.drawLine(x, y + 17, x + 5, y + 17);
                g.drawLine(x, y + 24, x + 5, y + 24);
                g.drawLine(x + 15, y + 3, x + 20 - 1, y + 3);
                g.drawLine(x + 15, y + 10, x + 20 - 1, y + 10);
                g.drawLine(x + 15, y + 17, x + 20 - 1, y + 17);
                g.drawLine(x + 15, y + 24, x + 20 - 1, y + 24);
                break;
            case 1:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.drawOval(x + 7, y + 12, 5, 5);
                g.drawLine(x + 10, y + 28, x + 10, y + 18);
                g.drawLine(x, y + 4, x + 5 - 1, y + 4);
                g.drawLine(x, y + 11, x + 5 - 1, y + 11);
                g.drawLine(x, y + 18, x + 5 - 1, y + 18);
                g.drawLine(x, y + 25, x + 5 - 1, y + 25);
                g.drawLine(x + 15, y + 4, x + 20 - 1, y + 4);
                g.drawLine(x + 15, y + 11, x + 20 - 1, y + 11);
                g.drawLine(x + 15, y + 18, x + 20 - 1, y + 18);
                g.drawLine(x + 15, y + 25, x + 20 - 1, y + 25);
                break;
            case 2:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.drawOval(x + 12, y + 7, 5, 5);
                g.drawLine(x + 2, y + 10, x + 13, y + 10);
                g.drawLine(x + 4, y, x + 4, y + 5 - 1);
                g.drawLine(x + 11, y, x + 11, y + 5 - 1);
                g.drawLine(x + 18, y, x + 18, y + 5 - 1);
                g.drawLine(x + 25, y, x + 25, y + 5 - 1);
                g.drawLine(x + 4, y + 15, x + 4, y + 20 - 1);
                g.drawLine(x + 11, y + 15, x + 11, y + 20 - 1);
                g.drawLine(x + 18, y + 15, x + 18, y + 20 - 1);
                g.drawLine(x + 25, y + 15, x + 25, y + 20 - 1);
                break;
            case 3:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.drawOval(x + 12, y + 7, 5, 5);
                g.drawLine(x + 18, y + 10, x + 28, y + 10);
                g.drawLine(x + 3, y, x + 3, y + 5);
                g.drawLine(x + 10, y, x + 10, y + 5);
                g.drawLine(x + 17, y, x + 17, y + 5);
                g.drawLine(x + 24, y, x + 24, y + 5);
                g.drawLine(x + 3, y + 15, x + 3, y + 20 - 1);
                g.drawLine(x + 10, y + 15, x + 10, y + 20 - 1);
                g.drawLine(x + 17, y + 15, x + 17, y + 20 - 1);
                g.drawLine(x + 24, y + 15, x + 24, y + 20 - 1);
                break;
            default:
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //方向键监听
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirection(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirection(1);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirection(3);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirection(2);
            myTank.moveLeft();
        }
        //发射子弹监听
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (myTank.bullets.size() < 5)
                myTank.shoot();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}