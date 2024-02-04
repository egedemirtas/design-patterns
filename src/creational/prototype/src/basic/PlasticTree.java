package basic;

public class PlasticTree extends TreePrototype {
    public PlasticTree(double mass, double height) {
        super();
        this.setMass(mass);
        this.setHeight(height);
    }

    @Override
    public TreePrototype getClone() {
        return new PlasticTree(this.getMass(), this.getHeight());
    }
}
