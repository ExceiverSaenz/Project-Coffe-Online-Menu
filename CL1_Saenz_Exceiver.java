import java.util.Scanner;
import java.io.File;

public class CL1_Saenz_Exceiver{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int number = 0;
		String cart = "";
		double precio = 0;
		double venti = 2.75;
		double grande = 1.5;

		
		while(number != 5){
				System.out.println("Welcome to Mejia Coffee! Please select an option below to continue:\n1. Display Menu\n2. Add item to order\n3. View cart\n4. Checkout\n5. Exit Mejia Coffee\n>");

				number = input.nextInt();

				switch (number){

					case 1: 
						try{
						File database = new File("menu.txt");
						Scanner reader = new Scanner(database);
							reader.nextLine();

						while (reader.hasNextLine()){
						String item_Name = reader.next();
						String is_Beverage = reader.next();
						double cost = reader.nextDouble();
						System.out.println(item_Name + " " + is_Beverage + " " + cost);
					}
				}
					catch(Exception e){
					System.out.println("Error");
				}
						break;

					case 2:System.out.print("Please enter the name of the item as shown on the menu:\n");

						String item = input.next();

						try{

						File database = new File("menu.txt");
						Scanner reader = new Scanner(database);
				
							reader.nextLine();
						boolean found = false;
						while (reader.hasNextLine()){
						String item_Name = reader.next();
						boolean is_Beverage = reader.nextBoolean();
						double cost = reader.nextDouble();

						if(item.equals(item_Name)){

							found = true;

						if(is_Beverage){
							System.out.println("1. Tall(+$0.00)\n2. Grande (+$1.50)\n3. Venti(+$2.75)\n");
							int beverage = input.nextInt();

							while(beverage<1 || beverage>3){
					
								System.out.println("Select other number");
								beverage = input.nextInt();
							
							}

							if(beverage == 1){
								cart+=item_Name + " " + cost + "\n";
								precio+= cost;
								System.out.println("Item was added to your cart.");
							}else if (beverage == 2) {
								cart+=item_Name + " " + (cost+grande) + "\n";
								precio+= cost + grande;
								System.out.println("Item was added to your cart.");
							}else if(beverage == 3){
								cart+=item_Name + " " + (cost+venti) + "\n";
								precio+= cost + venti;

								System.out.println("Item was added to your cart.");

							}

						} else if(!is_Beverage){
							System.out.println("How many would you like?\n");
							int food = input.nextInt();

							for(int i=0;i<food;i++){
								cart+=item_Name + " " + cost + "\n";
								precio+= cost;
							}
							System.out.println("Item was added to your cart.\n");
						}
					}
					}

					if(!found)
					System.out.println("I'm sorry. We do not carry that item.");
				}
					catch(Exception e){
					System.out.println("This archive not exist");
				}

						break;

					case 3:System.out.print("---------------- YOUR CART ----------------\n" + cart);
						System.out.println();

						 break;

					case 4:System.out.print("---------------- YOUR CART ----------------\n" + cart);



						System.out.println("\nSubtotal: $" + precio + "\nTotal after Taxes: $" + (precio*1.0675));

						System.out.println("Please enter CHECKOUT to complete your purchase.");


						String check = input.next();

						if(check.equals("CHECKOUT")){ 
							System.out.println("Thank you for your purchase. Enjoy!");} break;

					case 5: System.out.println("ADIOS"); break;
			}
		}

	}
}