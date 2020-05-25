package OnlineStore;
import java.util.Objects;

public class Vinyl extends MusicItem{
    private double diameter;
    private double speed;

    public Vinyl(String itemID, String theTitle, String theGenre, Date theReleaseDate, String theArtist, Double thePrice, Double speed, Double diameter) {
        super(itemID, theTitle, theGenre, theReleaseDate, theArtist, thePrice);
        this.diameter = diameter;
        this.speed = speed;
    }

    public double getDiameter() {
        return diameter;
    }  //method to retrieve diameter


    public double getSpeed() {
        return speed;
    }       //method to retrieve speed

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vinyl vinyl = (Vinyl) o;
        return Double.compare(vinyl.diameter, diameter) == 0 &&
                Double.compare(vinyl.speed, speed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter, speed);
    }

    @Override
    public String toString() {
        return "Vinyl{" +
                "diameter=" + diameter +
                ", speed=" + speed +
                ", itemID='" + itemID + '\'' +
                ", theTitle='" + theTitle + '\'' +
                ", theGenre='" + theGenre + '\'' +
                ", theReleaseDate=" + theReleaseDate +
                ", theArtist='" + theArtist + '\'' +
                ", thePrice=" + thePrice +
                '}';
    }
}



