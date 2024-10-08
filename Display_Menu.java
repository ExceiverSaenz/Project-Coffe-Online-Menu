import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Display_Menu {

    private File database = new File("/Users/marly/IdeaProjects/CoffeStore/Resources/menu.txt");

    public Display_Menu() {
        try {
            Scanner reader = new Scanner(database);
            reader.nextLine();

            while (reader.hasNextLine()){
                String item_Name = reader.next();
                String is_Beverage = reader.next();
                double cost = reader.nextDouble();
                System.out.println(item_Name + " " + is_Beverage + " " + cost);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
