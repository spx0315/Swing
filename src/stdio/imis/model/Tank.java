package stdio.imis.model;

import java.util.Vector;

public class Tank implements Runnable{
    private int x = 0;
    private int y = 0;
    private int speed = 5;
    private int type = 0;
    private Page map;
    private int direction = 0;//0-上,1-右,2-下,3-左;
    public Vector<Bullet> bullets = new Vector<Bullet>();
    private Bullet myBullet;
    public boolean alive = true;
    public boolean start = true;

    public void setMap(Page map) {
        this.map = map;
    }

    public Tank(int x, int y){
        this.x=x;
        this.y=y;
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
                myBullet = new Bullet(x + 30, y + 10, 5, 1);
                bullets.add(myBullet);
                break;
            case 2:
                myBullet = new Bullet(x + 10, y + 30, 5, 2);
                bullets.add(myBullet);
                break;
            case 3:
                myBullet = new Bullet(x, y + 10, 5, 3);
                bullets.add(myBullet);
                break;
        }
    }

    public void moveUp() {
        if (y - speed < 0) {
            y = 0;
        } else {
            y -= speed;
        }
    }

    public void moveDown() {
        if (y + speed > 470) {
            y = 470;
        } else {
            y += speed;
        }
    }

    public void moveLeft() {
        if (x - speed < 0) {
            x = 0;
        } else {
            x -= speed;
        }
    }

    public void moveRight() {
        if (x + speed > 470) {
            x = 470;
        } else {
            x += speed;
        }
    }

    @Override
    public void run() {
        while (alive) {
            if (start) {
                int step;
                int s;
                try {
                    switch (direction) {
                        case 0:
                            step = (int) (Math.random() * 30);
                            for (int i = 0; i < step; i++) {
                                moveUp();
                                if (y <= 0)
                                    break;// 撞墙跳出循环
                                if (y >= 30)// 仿数组越界
                                    if (map.location[x][y - 30] == 1 || map.location[x][y - 20] == 1) {
                                        map.location[x][y - 30] = 0;//这里没分开判断
                                        map.location[x][y - 20] = 0;
                                        break;
                                    }
                                Thread.sleep(80);
                            }
                            break;
                        case 1:
                            step = (int) (Math.random() * 30);
                            for (int i = 0; i < step; i++) {
                                moveRight();
                                if (x >= 500)
                                    break;
                                if (x < 470)
                                    if (map.location[x + 20][y] == 1 || map.location[x + 30][y] == 1) {
                                        map.location[x + 20][y] = 0;
                                        map.location[x + 30][y] = 0;
                                        break;
                                    }
                                Thread.sleep(80);
                            }
                            break;
                        case 2:
                            step = (int) (Math.random() * 30);
                            for (int i = 0; i < step; i++) {
                                moveDown();
                                if (y >= 500)
                                    break;
                                if (y < 470)
                                    if (map.location[x][y + 30] == 1 || map.location[x][y + 20] == 1) {
                                        map.location[x][y + 30] = 0;
                                        map.location[x][y + 20] = 0;
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
                                    if (map.location[x - 20][y] == 1 || map.location[x - 30][y] == 1) {
                                        map.location[x - 20][y] = 0;
                                        map.location[x - 30][y] = 0;
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
                s = (int) (Math.random() * 10);
                if (s > 8) {
                    shoot();
                }
            }
        }
    }
}
