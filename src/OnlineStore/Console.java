package OnlineStore;


import java.util.ArrayList;  //program uses Array list
import java.util.Scanner;   //program uses Scanner

public class Console extends WestminsterMusicStoreManager {
    //main method begins program execution
    public static void main(String[] args) throws StoreItemNotFoundException {


        Scanner choice = new Scanner(System.in); //Creating an object of Scanner class for input
        int option;  //Creating an integer variable called option to deal with the user selections.
        StoreManager storeManager = new WestminsterMusicStoreManager();
        do {
            //User Selection Part
            System.out.println("Welcome to Westminster Music Store");   //Options of music store
            System.out.println("What you like to do:");
            System.out.println("    1. Add New Items");
            System.out.println("    2. Delete Items");
            System.out.println("    3. Print List Items");
            System.out.println("    4. Sort Items");
            System.out.println("    5. Buy an Items");
            System.out.println("    6. Generate Sales Report");
            System.out.println("    7. Search");
            System.out.println("    8. Exit Westminster Music Store");
            //Asking for user input
            System.out.print("          Enter Option : ");
            while (!choice.hasNextInt()) {
                System.out.println("Invalid Input!!! Please enter a number which gave in the menu: ");
                choice.next();
            }


            option = choice.nextInt();


            //Using if condition to get user input

            if (option == 1) {
                System.out.println("Select Type:");   // Asking for item type
                System.out.println("1.CD");
                System.out.println("2.Vinyl");
                option = choice.nextInt();
                if (option == 1) {   //If item type is CD, User should enter following details

                    System.out.println("Enter item ID");
                    String itemId = choice.next();
                    System.out.println("Enter title");
                    String title = choice.next();
                    System.out.println("Enter Genre");
                    String genre = choice.next();
                    System.out.println("Enter Artist name");
                    String artist = choice.next();
                    System.out.println("Enter Release date");
                    String date = choice.next();
                    System.out.println("Enter Price");
                    Double price = choice.nextDouble();
                    System.out.println("Enter duration");
                    int duration = choice.nextInt();
                    CD cd = new CD(itemId, title, genre, new Date(date), artist, price, duration);
                    try {
                        storeManager.addItems(cd);
                    } catch (StoreFullException ex) {
                        System.out.println(ex.getMessage());
                    }

                } else if (option == 2) {        //If item type is Vinyl, User should enter following details
                    System.out.println("Enter item ID");
                    String itemId = choice.next();
                    System.out.println("Enter title");
                    String title = choice.next();
                    System.out.println("Enter Genre");
                    String genre = choice.next();
                    System.out.println("Enter Artist name");
                    String artist = choice.next();
                    System.out.println("Enter Release date");
                    String date = choice.next();
                    System.out.println("Enter Price");
                    Double price = choice.nextDouble();
                    System.out.println("Enter duration");
                    int duration = choice.nextInt();
                    System.out.println("Enter speed");
                    Double speed = choice.nextDouble();
                    System.out.println("Enter diameter");
                    Double diameter = choice.nextDouble();
                    Vinyl vinyl = new Vinyl(itemId, title, genre, new Date(date), artist, price, speed, diameter);
                    try {
                        storeManager.addItems(vinyl);
                    } catch (StoreFullException ex) {
                        System.out.println(ex.getMessage());
                    }

                } else {
                    System.out.println("You entered invalid option");
                }


                //storeManager.delItems();
            } else if (option == 2) {
                System.out.println("Enter the item ID");
                String ItemID = choice.next();

                try {
                    storeManager.delItems(ItemID);

                } catch (StoreItemNotFoundException e) {
                    System.out.println("Item not found");
                }
                //storeManager.listItems();
            } else if (option == 3) {
                storeManager.listItems();
                //storeManager.sortItems
            } else if (option == 4) {
                storeManager.sortItems(SortCategory.TITLE);
                //storeManager.buyItems
            } else if (option == 5) {
                System.out.println("Enter the item ID");
                String ItemID = choice.next();
                System.out.println("Enter Quantity");
                int qty = choice.nextInt();
                Purchase p = storeManager.buyItems(ItemID, qty);
                System.out.println(p);
                //storeManager.generateSalesReport
            } else if (option == 6) {
                ArrayList<Purchase> report = storeManager.generateReport();
                for (Purchase p : report) {
                    System.out.println(p.report());
                }
                //storeManager.search
            } else if (option == 7) {
                System.out.println("Enter title");
                String title = choice.next();
                MusicItem m = storeManager.search(title);
                if (m != null) {
                    System.out.println(m);
                } else {
                    System.out.println("Item not found");
                }
                //Exit Music Store
            } else if (option == 8) {
                exMusic();
            } else {
                System.out.println("You entered an invalid choice");
            }

        } while (option >= 1 && option <= 8); //loop works until the option greater than equal to one and less than equal to 8
    }

    private static double getDouble() {
        Scanner sc=new Scanner(System.in);
        while (!sc.hasNextDouble()){
            System.out.println("Invalid Choice");
            System.out.println("Re enter:");
            sc.next();
        }
        return sc.nextDouble();
    }

    private static void exMusic() {     //Exiting the Music Store
        Scanner exit = new Scanner(System.in);
        System.out.println("Are you sure you want to exit Westminster Music Store? Y/N");
        String exMusic = exit.next();
        if (exMusic.toUpperCase().equals("Y")) {
            System.out.println("Thanks for using Westminster Music Store\nCome Again");
            System.exit(0);
        }
    }




}




