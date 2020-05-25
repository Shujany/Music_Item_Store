package OnlineStore;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {


    public static void main(String []args)throws Exception{
        DBManager db = new DBManager();
        db.openConnection();
        ArrayList<MusicItem> m = db.getItems();
        db.closeConnection();

        System.out.println(m);
    }

    private Connection conn;

    public void openConnection(){
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName).newInstance();

            String severName = "localhost";
            String mydatabase = "store_manager";
            String url = "jdbc:mysql://" + severName + "/" + mydatabase + "?serverTimezone=UTC";

            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void buyItem(Purchase c) {

        String sql = "INSERT INTO `purchase`(`itemId`, `qty`, `title`, `price`, `purchase_date`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getItemId());
            ps.setInt(2, c.getQty());
            ps.setString(3, c.getTitle());
            ps.setString(5, c.getPurchaseDate().toString());
            ps.setDouble(4, c.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addItem(MusicItem m){
        System.out.println(m instanceof CD);
        if(m instanceof CD){
            String sql="INSERT INTO `items`(`itemId`, `title`, `genre`, `releaseDate`, `artist`, `price`, `duration`, `type`) VALUES " +
                    "(?,?,?,?,?,?,?,?)";
            try {

                CD c = (CD)m;
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,c.getItemID());
                ps.setString(2,c.getTheTitle());
                ps.setString(3,c.getTheGenre());
                ps.setString(4,c.getTheReleaseDate().toString());
                ps.setString(5,c.getTheArtist());
                ps.setDouble(6,c.getThePrice());
                ps.setDouble(7,c.getDuration());
                ps.setInt(8,1);
                ps.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else {
            String sql="INSERT INTO `items`(`itemId`, `title`, `genre`, `releaseDate`, `artist`, `price`, `speed`,`diameter`, `type`) VALUES " +
                "(?,?,?,?,?,?,?,?,?)";
            try {

                Vinyl c = (Vinyl) m;
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,c.getItemID());
                ps.setString(2,c.getTheTitle());
                ps.setString(3,c.getTheGenre());
                ps.setString(4,c.getTheReleaseDate().toString());
                ps.setString(5,c.getTheArtist());
                ps.setDouble(6,c.getThePrice());
                ps.setDouble(7,c.getSpeed());
                ps.setDouble(8,c.getDiameter());
                ps.setInt(9,2);
                ps.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }



        }
    }

    public ArrayList<Purchase> getPurchaseReport(){
        ArrayList<Purchase> mi = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT itemId,sum(qty) as total,title, price FROM `purchase` group by itemId,title,price");
            while(rs.next()){
                int qty = rs.getInt("total");
                String itemId = rs.getString("itemId");
                String title= rs.getString("title");
                Double price= rs.getDouble("price");
                Purchase p = new Purchase();
                p.setQty(qty);
                p.setTitle(title);
                p.setPrice(price);
                p.setItemId(itemId);
                mi.add(p);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return mi;
    }

    public ArrayList<MusicItem> getItems(){
        ArrayList<MusicItem> mi = new ArrayList<>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from items");
            while(rs.next()){
                int type = rs.getInt("type");
                String itemId = rs.getString("itemId");
                String title= rs.getString("title");
                String genre= rs.getString("genre");
                Date releaseDate= new Date(rs.getString("releaseDate"));
                String artist= rs.getString("artist");
                Double price= rs.getDouble("price");
                int duration= rs.getInt("duration");
                Double speed= rs.getDouble("speed");
                Double diameter= rs.getDouble("diameter");

                if(type==1){
                    CD cd = new CD(itemId,title,genre,releaseDate,artist,price,duration);
                    mi.add(cd);
                }
                else{
                    Vinyl v = new Vinyl(itemId,title,genre,releaseDate,artist,price,speed,diameter);
                    mi.add(v);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return mi;
    }

    public void closeConnection(){
        try {
            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
