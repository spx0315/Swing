package stdio.imis.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {

    public Tank myTank;//我方坦克
    public Tank enemy;
    Vector<Tank> enemies = new Vector<Tank>();//敌方坦克集合
    Vector<Dead> booms = new Vector<Dead>();//击毁集合
    Page field = new Page();



    public MyPanel() {
        myTank = new Tank(300, 200,0,0);
        myTank.setField(field);
        //敌方7流氓创建
        for(int i = 0; i < 7;i++){
            enemy = new Tank(i*30,10,2,1);
            enemies.add(enemy);
            enemy.setField(field);
            new Thread(enemy).start();
        }

    }

    @Override
    //这里，Graphics 相当于一只画笔
    public void paint(Graphics g) {
        //调用父类完成初始化
        super.paint(g);

        //g.setColor(Color.blue);
        //然后就可以在这里面画画啦
        if(myTank.alive == true) {
            drawTank(myTank.getx(), myTank.gety(), myTank.getDirection(), g, 0);//画我的坦克
        }
        for (int i = 0; i < myTank.bullets.size(); i++) {// 循环时删除集合时，不要用foreach，用for
            Bullet b = new Bullet();
            b = myTank.bullets.get(i);
            if (b.alive == true) {
                g.setColor(Color.white);
                g.fill3DRect(b.getX(), b.getY(), 2, 2, false);
            } else
                myTank.bullets.remove(b);
        }

        //敌方坦克
        for(int i = 0; i < enemies.size();i++){
            Tank enemy = enemies.get(i);
            if(enemy.alive == true){
                drawEnemy(enemy.getx(),enemy.gety(),enemy.getDirection(),g,1);
            }
            if(enemy.alive == true){
                g.setColor(Color.GREEN);
                g.fill3DRect(enemy.getx(),enemy.gety(),2,2,false);
            }
            else{
                enemy.bullets.remove(enemy);
            }
        }
    }



    public void drawEnemy(int x,int y,int direction,Graphics g,int type){
        drawTank(x,y,direction,g,1);
    }

    public void drawTank(int x, int y, int direction, Graphics g,int type) {
        if(type == 0){
            g.setColor(Color.CYAN);
        }
        else {
            g.setColor(Color.GREEN);
        }
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
                //myTank.myBullet.setDirection(myTank.getDirection());
                myTank.shoot();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }
}