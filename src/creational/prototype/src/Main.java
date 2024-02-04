import basic.PineTree;
import clonable.FlatHouse;
import clonable.HousePrototype;

public class Main {
    public static void main(String[] args) {
        PineTree pineTree = new PineTree(2.0, 5.0);
        PineTree pineTreeClone = (PineTree) pineTree.getClone();
        System.out.println("Real: " + pineTree);
        System.out.println("Clone: " + pineTreeClone);

        FlatHouse flatHouse = new FlatHouse(145.54, 234.76);
        FlatHouse flatHouseClone = (FlatHouse) flatHouse.clone();
        System.out.println("Real: " + flatHouse);
        System.out.println("Clone: " + flatHouseClone);
    }
}