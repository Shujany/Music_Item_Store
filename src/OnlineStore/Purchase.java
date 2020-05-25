package OnlineStore;

public class Purchase {
    String itemId;
    String title;
    int qty;
    Date purchaseDate;
    double price;

    public String getItemId() {   //method to retrieve ItemId
        return itemId;
    }

    public void setItemId(String itemId) {  //method to set ItemId
        this.itemId = itemId;
    }

    public String getTitle() {     //method to retrieve Title
        return title;
    }

    public void setTitle(String title) {   //method to set Title
        this.title = title;
    }

    public int getQty() {          //method to retrieve Qty
        return qty;
    }

    public void setQty(int qty) {      //method to set Qty
        this.qty = qty;
    }

    public Date getPurchaseDate() {    // method to retrieve PurchaseDate
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {   //method to set PurchaseDate
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {   //method to retrieve Price
        return price;
    }

    public void setPrice(double price) {   //method to set price
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemID:"+itemId+", Title:"+title+", Qty:"+qty+", Total:"+(qty*price);
    }

    public String report() {
        return "ItemID:"+itemId+", Title:"+title+", Total Quantity:"+qty+"";
    }

}
