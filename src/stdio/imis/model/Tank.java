package stdio.imis.model;

import java.util.Vector;

public class Tank implements Runnable{
    private int x = 0;
    private int y = 0;
    private int speed = 5;
    private int type = 0;
    private Page field;
    private int direction = 0;//0-上,1-下,2-左,3-右;
    public Vector<Bullet> bullets = new Vector<Bullet>();
    public Bullet myBullet;
    public boolean alive = true;
    public boolean start = true;

    public void setField(Page field) {
        this.field = field;
    }

    public Tank(){

    }

    public Tank(int x, int y,int direction,int type){
        this.x=x;
        this.y=y;
        this.direction=direction;
        this.type=type;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
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

    public void shoot(){
        switch (direction) {
            case 0:
                myBullet = new Bullet(x + 10, y, 5, 0);
                bullets.add(myBullet);
                break;
            case 1:
                myBullet = new Bullet(x + 10, y + 10, 5, 1);
                bullets.add(myBullet);
                break;
            case 2:
                myBullet = new Bullet(x + 10, y + 10, 5, 2);
                bullets.add(myBullet);
                break;
            case 3:
                myBullet = new Bullet(x + 10, y + 10, 5, 3);
                bullets.add(myBullet);
                break;
        }
    }

    public void moveUp() {
        if (y - speed < 0) {
            y = 0;
        } else {
            y -= speed;
            field.location[x][y]=1;
        }
    }

    public void moveDown() {
        if (y + speed > 420) {
            y = 420;
        } else {
            y += speed;
            field.location[x][y]=1;
        }
    }

    public void moveLeft() {
        if (x - speed < 0) {
            x = 0;
        } else {
            x -= speed;
            field.location[x][y]=1;
        }
    }

    public void moveRight() {
        if (x + speed > 450) {
            x = 450;
        } else {
            x += speed;
            field.location[x][y]=1;
        }
    }

    @Override
    public void run() {
        while (alive) {
            if (start) {
                int step;
                int biu;
                try {
                    switch (direction) {
                        case 0:
                            step = (int) (Math.random() * 30);
                            for (int i = 0; i < step; i++) {
                                moveUp();
                                if (y <= 0)
                                    break;// 撞墙跳出循环
                                if (y >= 30)
                                    if (field.location[x][y - 30] == 1 || field.location[x][y - 20] == 1) {
                                        field.location[x][y - 30] = 0;
                                        field.location[x][y - 20] = 0;
                                        break;
                                    }
                                Thread.sleep(80);
                            }
                            break;
                        case 1:
                            step = (int) (Math.random() * 30);
                            for (int i = 0; i < step; i++) {
                                moveRight();
                                if (x >= 480)
                                    break;
                                if (x < 450)
                                    if (field.location[x + 20][y] == 1 || field.location[x + 30][y] == 1) {
                                        field.location[x + 20][y] = 0;
                                        field.location[x + 30][y] = 0;
                                        break;
                                    }
                                Thread.sleep(80);
                            }
                            break;
                        case 2:
                            step = (int) (Math.random() * 30);
                            for (int i = 0; i < step; i++) {
                                moveDown();
                                if (y >= 450)
                                    break;
                                if (y < 420)
                                    if (field.location[x][y + 30] == 1 || field.location[x][y + 20] == 1) {
                                        field.location[x][y + 30] = 0;
                                        field.location[x][y + 20] = 0;
                                        break;
                                    }
                                Thread.sleep(80);
                            }
                            break;
                        case 3:
                            step = (int) (Math.random() * 30);
                            for (int i = 0; i < step; i++) {
                                moveLeft();
                                if (x <= 0)
                                    break;
                                if (x >= 30)
                                    if (field.location[x - 20][y] == 1 || field.location[x - 30][y] == 1) {
                                        field.location[x - 20][y] = 0;
                                        field.location[x - 30][y] = 0;
                                        break;
                                    }
                                Thread.sleep(80);
                            }
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                direction = (int) (Math.random() * 4);// 随机方向
                biu = (int) (Math.random() * 10);
                if (biu > 8) {
                    shoot();
                }
            }
        }
    }
}
