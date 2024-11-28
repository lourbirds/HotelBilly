import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        welcome();
        System.out.println("Would you like to Book a night or Exit?");
        System.out.println("[1] Book a night");
        System.out.println("[0] Exit");
        System.out.print("ENTER 1 or 0: ");

        if (input.hasNextInt()) {
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    displayOptions(input);
                    break;
                case 0:
                    System.out.println("EXITING PROGRAM...");
                    System.exit(0);
                default:
                    System.out.println("INCORRECT INPUT. TRY AGAIN.");
                    break;
            }
        } else {
            System.out.println("INCORRECT INPUT. TRY AGAIN.");
        }

        input.close();
    }

    private static void welcome() {
        System.out.println("WELCOME TO HOTEL DE LUNA");
    }
    private static void displayOptions(Scanner input) {
        int roomType, roomOcc, nightCount, guestCount;
        System.out.println("[1] Select Room Type");
        System.out.println("[2] Select Room Size");
        System.out.println("[3] Select Number of Nights");
        System.out.println("[4] Select Number of Guests");
        System.out.println("[5] Calculate Total Bill");
        System.out.print("ENTER a number between 1 to 5: ");
        if (input.hasNextInt()) {
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("ROOM TYPE...");
                    roomType = getRoomType(input);
                    break;
                case 2:
                    System.out.println("ROOM OCCUPANCY...");
                    System.exit(0);
                case 3:
                    System.out.println("COUNTING NIGHTS...");
                    System.exit(0);
                case 4:
                    System.out.println("COUNTING GUESTS...");
                    System.exit(0);
                case 5:
                    System.out.println("CALCULATING...");
                    System.exit(0);
                default:
                    System.out.println("INCORRECT INPUT. TRY AGAIN.");
                    break;
            }
        } else {
            System.out.println("INCORRECT INPUT. TRY AGAIN.");
        }
    //            int inputRoomSelection = getRoomType(input);
    //            int inputSizeSelection = getSize(inputRoomSelection,input);
    //            int priceofRoomSize = getPriceRoom(inputRoomSelection,inputSizeSelection);
    //            System.out.println("PRICE = "+ priceofRoomSize); //TEST

    //            //steph

    //            int numberofGuest = getHowManyGuest(input);

    //            if (inputRoomSelection==1 && inputSizeSelection == 1) {
	// 	       if (numberofGuest <= 2) {
	// 	       } else System.out.println("Too many guests for a Single Occupancy room. The maximum number of guests is 2."); 
    //  	} else if (inputRoomSelection == 1 && inputSizeSelection == 2) {
	// 	       if (numberofGuest <= 3 ) {
	// 	       } else System.out.println("Too many guests for a Double Occupancy room. The maximum number of guests is 3."); 
	//       } else if (inputRoomSelection == 2 && inputSizeSelection == 1) {
	// 	       if (numberofGuest <= 4 ) {
	// 	       } else System.out.println("Too many guests for a Single Occupancy room. The maximum number of guests is 4."); 
	//       } else if (inputRoomSelection == 2 && inputSizeSelection == 2) {
	// 	       if (numberofGuest <= 6 ) {
	// 	       } else System.out.println("Too many guests for a Double Occupancy room. The maximum number of guests is 6."); 
	//       } else if (inputRoomSelection == 3 && inputSizeSelection == 1) {
	// 	       if (numberofGuest <= 6 ) {
	// 	       } else System.out.println("Too many guests for a Single Occupancy room. The maximum number of guests is 6."); 
	//       } else if (inputRoomSelection == 3 && inputSizeSelection == 2) {
	// 	       if (numberofGuest <= 10 ) {
	// 	       } else System.out.println("Too many guests for a Double Occupancy room. The maximum number of guests is 10."); 
	// }
	
    	

    //            //izzy
    //            int nightofStay = getHowManyNights(input);

    //            int totalPrice = priceofRoomSize * nightofStay;

    //            System.out.println("Total cost: " + totalPrice);
   
    }
    private static double guestCharge(double totalBill){ 
        double charge = totalBill * 0.10;
        return charge;
   }
    private static int getRoomType(Scanner input){
        System.out.println("Select your Room Type");
        System.out.println("[1] Standard (1800.00 for Single Occupancy OR 2700.00 for Double Occupancy)");
        System.out.println("[2] Deluxe (2300.00 for Single Occupancy OR 3200.00 for Double Occupancy)");
        System.out.println("[3] Suite (3000.00 for Single Occupancy OR 4000.00 for Double Occupancy)");
        System.out.print("ENTER a number between 1 to 3: ");
        int roomSelection = input.nextInt();
        switch (roomSelection) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }
    }
    private static int getSize(int roomType, Scanner input){
        switch (roomType) {
            case 1:
                System.out.println("Select Size");
                System.out.print("[1] Single (1800.00) \n[2] Double (2700.00)\n");
                break;
            case 2:
                System.out.println("Select Size");
                System.out.print("[1] Single (2300.00) \n[2] Double (3200.00)\n");
                break;
            case 3:
                System.out.println("Select Size");
                System.out.print("[1] Single (3000.00) \n[2] Double (4000.00)\n");
                break;
            default:
                break;
        }
        System.out.print("~> ");
        return input.nextInt();
    }
    private static int getPriceRoom(int getRoomType, int userSizeChoice){
        int userChoicePrice = 0;
        int singleOccupancy , doubleOccupancy;
        switch (getRoomType){
            case 1://STANDARD
                singleOccupancy = 1800;
                doubleOccupancy = 2700;
                switch (userSizeChoice) {
                    case 1:
                        userChoicePrice = singleOccupancy;
                        break;
                    case 2:
                        userChoicePrice = doubleOccupancy;
                        break;
                    default:
                        break;
                }
                break;
            case 2://DELUXE
                singleOccupancy = 2300;
                doubleOccupancy = 3200;
                switch (userSizeChoice) {
                    case 1:
                        userChoicePrice = singleOccupancy;
                        break;
                    case 2:
                        userChoicePrice = doubleOccupancy;
                        break;
                    default:
                        break;
            }
                break;
            case 3://SUITE
                singleOccupancy = 3000;
                doubleOccupancy = 4000;
                switch (userSizeChoice) {
                    case 1:
                        userChoicePrice = singleOccupancy;
                        break;
                    case 2:
                        userChoicePrice = doubleOccupancy;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return userChoicePrice;
    }
    
    
     private static int getHowManyNights(Scanner input) {
        System.out.println("How many nights you will be staying?");
        System.out.print("~> ");
        return input.nextInt();
     }
        private static int getHowManyGuest(Scanner input) {
            System.out.println("How many guests will be staying?");
            System.out.print("~> ");
            return input.nextInt();
         }
        
    }
