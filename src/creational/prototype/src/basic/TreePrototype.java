package basic;

public abstract class TreePrototype {
    private double height;
    private double mass;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public abstract TreePrototype getClone();
}
