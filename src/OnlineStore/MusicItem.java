package OnlineStore;

import java.util.Objects;

public abstract class MusicItem implements Comparable<MusicItem> { //Generic Type, to override the compareto method we made music  item as abstract class
    protected String itemID;
    protected String theTitle;
    protected String theGenre;
    protected Date theReleaseDate;
    protected String theArtist;
    protected Double thePrice;

    public String getItemID() {
        return itemID;
    }    //method to retrieve ItemID

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }  //method to set Item iD

    public String getTheTitle() {
        return theTitle;
    }    //method to retrieve Title

    public void setTheTitle(String theTitle) {
        this.theTitle = theTitle;
    }   //method to set title

    public String getTheGenre() {
        return theGenre;
    }         //method to retrieve Genre

    public void setTheGenre(String theGenre) {
        this.theGenre = theGenre;
    }        //method to set Genre

    public Date getTheReleaseDate() {
        return theReleaseDate;
    }     //method to retrieve Release date

    public void setTheReleaseDate(Date theReleaseDate) {
        this.theReleaseDate = theReleaseDate;
    }  //method to set Release date

    public String getTheArtist() {
        return theArtist;
    }     //method to retrieve Artist

    public void setTheArtist(String theArtist) {
        this.theArtist = theArtist;
    }  //method to set Artist

    public Double getThePrice() {
        return thePrice;
    }    //method to retrieve Price

    public void setThePrice(Double thePrice) {
        this.thePrice = thePrice;
    }  //Method to  set price

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicItem musicItem = (MusicItem) o;
        return Objects.equals(itemID, musicItem.itemID) &&
                Objects.equals(theTitle, musicItem.theTitle) &&
                Objects.equals(theGenre, musicItem.theGenre) &&
                Objects.equals(theReleaseDate, musicItem.theReleaseDate) &&
                Objects.equals(theArtist, musicItem.theArtist) &&
                Objects.equals(thePrice, musicItem.thePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, theTitle, theGenre, theReleaseDate, theArtist, thePrice);
    }

    public MusicItem(String itemID, String theTitle, String theGenre, Date theReleaseDate, String theArtist, Double thePrice) {
        this.itemID = itemID;
        this.theTitle = theTitle;
        this.theGenre = theGenre;
        this.theReleaseDate = theReleaseDate;
        this.theArtist = theArtist;
        this.thePrice = thePrice;


    }

    @Override
    public int compareTo(MusicItem o) {
        return this.theTitle.compareTo(o.theTitle);
    }

    @Override
    public String toString() {
        return "MusicItem{" +
                "itemID='" + itemID + '\'' +
                ", theTitle='" + theTitle + '\'' +
                ", theGenre='" + theGenre + '\'' +
                ", theReleaseDate=" + theReleaseDate +
                ", theArtist='" + theArtist + '\'' +
                ", thePrice=" + thePrice +
                '}';
    }
}


