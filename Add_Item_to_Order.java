import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Add_Item_to_Order {

    private static final double[] sizes = {0.00, 1.50, 2.75};
    private String clientCart;
    private double clientPrice;
    private boolean found;

    Scanner input = new Scanner(System.in);


    public Add_Item_to_Order(boolean found) {
        this.clientCart = "";
        this.clientPrice = 0;
        this.found = found;
    }

    public String getClientCart() {
        return this.clientCart;
    }

    public double getClientPrice() {
        return this.clientPrice;
    }

    public boolean getFound() {
        return this.found;
    }


    public void handleItem(StringBuilder cart, double precio) {
        try (Scanner reader = new Scanner(new File("/Users/marly/IdeaProjects/CoffeStore/Resources/menu.txt"))) {
            System.out.print("Please enter the name of the item as shown on the menu:\n");
            Scanner input = new Scanner(System.in);
            String itemName = input.next();

            reader.nextLine();
            while (reader.hasNextLine()) {
                String item_Name = reader.next();
                boolean is_Beverage = reader.nextBoolean();
                double cost = reader.nextDouble();

                if (itemName.equals(item_Name)) {
                    this.found = true;
                    beverageOrFood(is_Beverage, cost, item_Name);
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("This archive does not exist");
        }

        if (!found) {
            System.out.println("I'm sorry. We do not carry that item.");
        }
    }



    public void beverageOrFood (boolean is_Beverage, double cost, String item_Name) {
        if(is_Beverage){
            isBeverage( cost, item_Name);
        } else {
            isFood( cost, item_Name);
        }
    }

    private void isBeverage (double cost, String item_Name) {
        System.out.println("1. Tall(+$ " + this.sizes[0] + ")\n2. Grande (+" + this.sizes[1] + ")\n3. Venti(+" + this.sizes[2] + ")\n");
        int beverage = input.nextInt();
        while(beverage<1 || beverage>3){
            System.out.println("Select other number");
            beverage = input.nextInt();
        }

        beverageSize( beverage, cost, item_Name);
    }

    private void beverageSize (int beverage, double cost, String item_Name) {
        if(beverage >= 1 && beverage <= 3){
            double finalCost = cost + sizes[beverage-1];
            this.clientCart += item_Name + " " + finalCost + "\n";
            this.clientPrice += finalCost;
            System.out.println(item_Name + " " + finalCost + " added to the cart.\n");
        } else {
            System.out.println("Invalid beverage size");
        }
    }



    private void isFood (double finalCost, String item_Name) {
        System.out.println("How many would you like?\n");
        int food = input.nextInt();
        for(int i=0;i<food;i++){
            this.clientCart += item_Name + " " + finalCost + "\n";
            this.clientPrice += finalCost;
        }
        System.out.println("Item was added to your cart.\n");
    }
}
