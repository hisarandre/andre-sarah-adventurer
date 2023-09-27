package org.cirilgroup.model;

import java.util.List;

public class Plan {
    public List<Tree> trees;
    public int borderLimitX;
    public int borderLimitY;

    public Plan(List<Tree> trees, int borderLimitX, int borderLimitY ) {
        this.trees = trees;
        this.borderLimitX = borderLimitX;
        this.borderLimitY = borderLimitY;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public int getBorderLimitX() {
        return borderLimitX;
    }

    public void setBorderLimitX(int borderLimitX) {
        this.borderLimitX = borderLimitX;
    }

    public int getBorderLimitY() {
        return borderLimitY;
    }

    public void setBorderLimitY(int borderLimitY) {
        this.borderLimitY = borderLimitY;
    }
}
