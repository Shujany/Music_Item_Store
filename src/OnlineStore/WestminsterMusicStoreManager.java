package OnlineStore;

import java.text.*;

import java.util.*;

public class WestminsterMusicStoreManager implements StoreManager{
    private List<MusicItem> storeitem = new ArrayList<MusicItem>();
   // private List<MusicItem> cart = new ArrayList<MusicItem>();
    private static final int MAX_COUNT = 1000;

    DBManager db;
    public WestminsterMusicStoreManager(){
        db=new DBManager();
        db.openConnection();
        storeitem = db.getItems();
        db.closeConnection();
    }

    @Override
    public void addItems(MusicItem item) throws StoreFullException {  //Add Items
        if (storeitem.size()<1000){   //System can store maximum 1000 items
            storeitem.add(item);
            db.openConnection();
            db.addItem(item);
            db.closeConnection();
        }else {
            throw new StoreFullException("store is full with 1000 items");
        }
    }

    @Override
    public boolean delItems(String id) throws StoreItemNotFoundException {  //Delete Items
        MusicItem item=null;
        for(int i=0;i<storeitem.size();i++){
            if(storeitem.get(i).getItemID().equals(id))
            {
                item= storeitem.get(i);
                break;
            }
        }
        if (storeitem.contains(item)) {             //If store contains particular item remove it from store items
            return storeitem.remove(item);
        }
        else {
            throw new StoreItemNotFoundException("Item not found");   //throw messagr if item not found
        }
    }

    @Override
    public void listItems() {                      // Print the List of Items
        System.out.println("List of CDs");
        for (MusicItem item : storeitem){
            if (item instanceof CD){
                System.out.println(item);        // Print the details of CD
            }
        }

        System.out.println("List of Vinyls");
        for (MusicItem item : storeitem){
            if (item instanceof Vinyl){
                System.out.println(item);       //Print the details of Vinyl
            }
        }
    }

    @Override
    public void sortItems(SortCategory c)  {    //Sort the item
        if (c == SortCategory.PRICE){
            Collections.sort(storeitem);
        }else if (c == SortCategory.TITLE){
            Collections.sort(storeitem, new TitleComparator()); //Sorting according to item title
            listItems();
        }else if (c == SortCategory.ITEMID){
            Collections.sort(storeitem, new ItemNoComparator());
        }else if (c == SortCategory.ARTIST){
            Collections.sort(storeitem);
        }else if (c == SortCategory.GENRE){
            Collections.sort(storeitem);
        }else if (c == SortCategory.RELEASEDATE){
            Collections.sort(storeitem);
        }else {
           // throw new SortItemException("Can't sort the list");
        }
    }

    @Override
    public Purchase buyItems(String id,int qty) throws StoreItemNotFoundException {   //Buy Items
        MusicItem item=null;
        for(int i=0;i<storeitem.size();i++){
            if(storeitem.get(i).getItemID().equals(id))    //Selecting the item using Item ID
            {
                item= storeitem.get(i);
                break;
            }
        }
        if (item==null) {
            throw new StoreItemNotFoundException("Item not found"); //if item is not found throw exception
        }
        else{
            Purchase p = new Purchase();
            p.setItemId(item.getItemID());
            p.setPrice(item.getThePrice());
            p.setTitle(item.getTheTitle());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new java.util.Date();
            Date d = new Date(dateFormat.format(date));
            p.setPurchaseDate(d);
            p.setQty(qty);
            db.openConnection();
            db.buyItem(p);
            db.closeConnection();
            return p;
        }
    }

    @Override
    public ArrayList<Purchase> generateReport() {    //Generate Purchase Report
        db.openConnection();
        ArrayList<Purchase> p = db.getPurchaseReport();
        db.closeConnection();
        return p;
    }

    @Override
    public MusicItem search(String title) {     //Searching for particular item
        for(int i=0;i<storeitem.size();i++){
            if(storeitem.get(i).getTheTitle().equals(title))
            {
                return storeitem.get(i);
            }
        }
        return null;
    }

}

class ItemNoComparator implements Comparator<MusicItem>{

    @Override
    public int compare(MusicItem o1, MusicItem o2) {
        return o1.getItemID().compareTo(o2.getItemID());
    }
}

class TitleComparator implements Comparator<MusicItem>{

    @Override
    public int compare(MusicItem o1, MusicItem o2) {
        return o1.getTheTitle().compareTo(o2.getTheTitle());
    }
}

