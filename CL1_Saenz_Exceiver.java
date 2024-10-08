import java.util.Scanner;

public class CL1_Saenz_Exceiver{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int number = 0;
        StringBuilder cart = new StringBuilder();
        double precio = 0;

        final double tax = 1.0675;



        while(number != 5){
            System.out.println("Welcome! Please select an option below to continue:\n1. Display Menu\n2. Add item to order\n3. View cart\n4. Checkout\n5. Exit Mejia Coffee\n>");

            number = input.nextInt();

            switch (number){

                case 1:
                    Display_Menu showMenu = new Display_Menu();
                    break;

                case 2:
                    Add_Item_to_Order addItem = new Add_Item_to_Order(false);
                    addItem.handleItem(cart, precio);

                    if(addItem.getFound()) {
                        cart.append(addItem.getClientCart());
                        precio += addItem.getClientPrice();
                    }


                    break;

                case 3:

                    viewCart view = new viewCart(cart);


                    break;

                case 4:

                    System.out.print("---------------- YOUR CART ----------------\n" + cart);

                    System.out.println("\nSubtotal: $" + precio + "\nTotal after Taxes: $" + (precio * tax));

                    System.out.println("Please enter CHECKOUT to complete your purchase.");


                    String check = input.next();

                    if(check.equals("CHECKOUT")){
                        System.out.println("Thank you for your purchase. Enjoy!");
                    }
                    break;

                case 5:
                    Exit exit = new Exit(); break;
            }
        }

    }
}