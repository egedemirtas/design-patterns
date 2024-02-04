import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        TreasureChest treasureChest = new TreasureChest();
        Iterator<Item> itemIterator = treasureChest.getIterator();
        while (itemIterator.hasNext()) {
            System.out.println(itemIterator.next().toString());
        }
    }
}