package clonable;

public abstract class HousePrototype implements Cloneable {
    public double area;
    public double price;

    public HousePrototype(double area, double price) {
        this.area = area;
        this.price = price;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
