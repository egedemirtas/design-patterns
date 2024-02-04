import java.util.Iterator;
import java.util.List;

public class TreasureChest {

    private final List<Item> items;

    public TreasureChest() {
        items = List.of(
                new Item(ItemType.POTION, "Potion of courage"),
                new Item(ItemType.RING, "Ring of shadows"),
                new Item(ItemType.POTION, "Potion of wisdom"),
                new Item(ItemType.POTION, "Potion of blood"),
                new Item(ItemType.WEAPON, "Sword of silver +1"),
                new Item(ItemType.POTION, "Potion of rust"),
                new Item(ItemType.POTION, "Potion of healing"),
                new Item(ItemType.RING, "Ring of armor"),
                new Item(ItemType.WEAPON, "Steel halberd"),
                new Item(ItemType.WEAPON, "Dagger of poison"));
    }

    public TreasureChestItemIterator getIterator() {
        return new TreasureChestItemIterator();
    }

    public class TreasureChestItemIterator implements Iterator<Item> {

        int index;

        @Override
        public boolean hasNext() {

            if (index < items.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Item next() {

            if (this.hasNext()) {
                return items.get(index++);
            }
            return null;
        }
    }
}