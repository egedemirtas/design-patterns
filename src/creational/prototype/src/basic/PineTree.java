package basic;

public class PineTree extends TreePrototype{

    public PineTree(double mass, double height) {
        super();
        this.setMass(mass);
        this.setHeight(height);
    }

    @Override
    public TreePrototype getClone() {
        return new PineTree(this.getMass(), this.getHeight());
    }
}
