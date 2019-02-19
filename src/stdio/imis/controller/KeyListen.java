package stdio.imis.controller;

import stdio.imis.dao.KeyListenner;
import stdio.imis.model.MyPanel;

import java.awt.event.KeyEvent;

public class KeyListen implements KeyListenner {
    private MyPanel mp=null;

    public KeyListen(MyPanel mp) {
        super();
        this.mp = mp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //方向键监听
        if(e.getKeyCode()==KeyEvent.VK_W){
            mp.myTank.setDirection(0);
            mp.myTank.moveUp();
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            mp.myTank.setDirection(2);
            mp.myTank.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_D){
            mp.myTank.setDirection(1);
            mp.myTank.moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_A){
            mp.myTank.setDirection(3);
            mp.myTank.moveLeft();
        }
        //发射子弹监听
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            //if(mp.myTank.bullet.size()<5)
                mp.myTank.shoot();
        }
        mp.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
