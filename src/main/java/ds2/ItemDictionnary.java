package ds2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemDictionnary<T extends Identifiable & Matchable> extends HashMap<String, List<T>> {
    public void addItem(T item) {
        this.computeIfAbsent(item.getId(), k -> new ArrayList<>());
        this.get(item.getId()).add(item);

    }

    public boolean removeItem(T item) {
        boolean found = false;
        if (item == null) {
            return false;
        }
        if (this.containsKey(item.getId())) {
            List<T> itemList = this.get(item.getId());
            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i) == item) {
                    this.get(item.getId()).remove(i);
                    found = true;
                }
            }
            if (this.get(item.getId()).isEmpty()) {
                this.remove(item.getId());
            }
        }
        return found;
    }

    public List<T> findItems(T book2) {
        if (book2 != null) {
            return this.getOrDefault(book2.getId(), null);
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (String key : this.keySet()) {
            if (this.get(key).size() > 0) {
                size++;
            }
        }
        return size;
    }


    public List<T> findMatchableItems(String query) {
        List<T> out = new ArrayList<>();
        this.keySet().stream()
                .map(this::get)
                .forEach((itemList) -> itemList.forEach(item -> {
                    if (item.match(query)) {
                        out.add(item);
                    }
                }));

        return out;

    }
}
