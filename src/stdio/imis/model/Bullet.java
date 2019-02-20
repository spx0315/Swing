package stdio.imis.model;

import stdio.imis.dao.KeyListenner;

import java.awt.event.KeyEvent;

public class Bullet {
    private int x;
    private int y;
    private int speed;
    private int direction;
    public boolean alive=true;
    public Bullet(int x, int y, int speed, int direction) {
        super();
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        new Thread(new BulletThread()).start();
    }
    public Bullet() {
        super();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    class BulletThread implements Runnable, KeyListenner {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                switch (direction) {//判断方向坐标移动
                    case 0:
                        y -= speed;
                        break;
                    case 1:
                        y += speed;
                        break;
                    case 2:
                        x -= speed;
                        break;
                    case 3:
                        x += speed;
                        break;
                }
                if (x < 0 || y < 0 || x > 500 || y > 500||alive == false) {
                    alive=false;
                    break;
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
