package OnlineStore;

import java.util.ArrayList;
import java.util.List;

public interface StoreManager {
    void addItems(MusicItem item) throws StoreFullException;
    boolean delItems(String id) throws StoreItemNotFoundException;
    void listItems();
    void sortItems( SortCategory c);
    Purchase buyItems(String item,int qty) throws StoreItemNotFoundException;
    ArrayList<Purchase> generateReport();
    MusicItem search(String title);

}
