package stdio.imis.model;

public class Dead {
    private int x;
    private int y;
    public boolean alive = true;
    private int life = 5;

    public Dead(){
        super();
    }

    public Dead(int x,int y){
        super();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLife() {
        return life;
    }

    public void reduceLife(){
        if(life > 0){
            life--;
        }
        else {
            alive = false;
        }
    }
}
