package org.cirilgroup.model;

public class Adventurer {

    public int positionX;
    public int positionY;
    public String[] direction;

    public Adventurer(int positionX, int positionY, String[] direction){
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public Adventurer(){}

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String[] getDirection() {
        return direction;
    }

    public void setDirection(String[] direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return  "{" + positionX +
                ", " + positionY +
                "}";
    }
}
