package OnlineStore;
import java.util.Objects;

public class CD extends MusicItem{

    private int duration;
    public CD(String itemID, String theTitle, String theGenre, Date theReleaseDate, String theArtist, Double thePrice,int duration) {
        super(itemID, theTitle, theGenre, theReleaseDate, theArtist, thePrice);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }   //method to retrieve duration

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CD cd = (CD) o;
        return duration == cd.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration);
    }


    @Override
    public String toString() {
        return "CD{" +
                "duration=" + duration +
                ", itemID='" + itemID + '\'' +
                ", theTitle='" + theTitle + '\'' +
                ", theGenre='" + theGenre + '\'' +
                ", theReleaseDate=" + theReleaseDate +
                ", theArtist='" + theArtist + '\'' +
                ", thePrice=" + thePrice +
                '}';
    }

    



}


