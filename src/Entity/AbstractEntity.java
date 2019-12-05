package Entity;

public abstract class AbstractEntity{
    protected double posX;
    protected double posY;

    protected AbstractEntity (double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() { return posX; }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
