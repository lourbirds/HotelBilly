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
        int roomType = 0, roomOcc = 0, nightCount = 0, guestCount = 0;
        boolean finalComp = false;
        while (finalComp != true) {
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
                        System.out.println("ROOM TYPE----> " + roomType);
                        break;
                    case 2:
                        System.out.println("ROOM OCCUPANCY...");
                        roomOcc = getRoomOcc(input);
                        System.out.println("ROOM OCCUPANCY----> " + roomOcc);
                        break;
                    case 3:
                        System.out.println("COUNTING NIGHTS...");
                        nightCount = getNights(input);
                        System.out.println("NIGHTS----> " + nightCount);
                        break;
                    case 4:
                        System.out.println("COUNTING GUESTS...");
                        guestCount= getGuests(input);
                        System.out.println("GUESTS----> " + guestCount);
                        break;
                    case 5:
                        System.out.println("CALCULATING...");
                        finalCompute(roomType, roomOcc, nightCount, guestCount, input);
                        finalComp = true;
                        break;
                    default:
                        System.out.println("INCORRECT INPUT. TRY AGAIN.");
                        break;
                }
            } else {
                System.out.println("INCORRECT INPUT. TRY AGAIN.");
                input.nextLine();
            }
        }
    	
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

    private static int getRoomOcc(Scanner input){
        System.out.println("Select your Room Occupancy");
        System.out.println("[1] (Can Support 2, 4, or 6 guests)");
        System.out.println("[2] (Can support 3, 6, or 10 guests. Additional 900 per night.)");
        System.out.print("ENTER a number between 1 to 2: ");
        int roomSelection = input.nextInt();
        switch (roomSelection) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    private static int getNights(Scanner input) {
        System.out.println("How many nights will you be staying?");
        System.out.println("(15% discount is offered at checkout if you stay for more than 3 nights!)");
        System.out.print("ENTER a number: ");
        int nights = input.nextInt();
        return nights;
    }

    private static int getGuests(Scanner input) {
        System.out.println("How many guests will be staying?");
        System.out.print("ENTER a number: ");
        int guests = input.nextInt();
        return guests;
    }

    private static int finalCompute(int roomType, int roomSize, int nights, int guests, Scanner input) {
        if (roomType == 1 && guests <= 2 && roomSize == 1) {
            
        } else if (roomType == 1 && guests <= 3 && roomSize == 2) {

        } else if (roomType == 2 && guests <= 4 & roomSize == 1) {

        } else if (roomType == 2 && guests <= 6 & roomSize == 2) {

        } else if (roomType == 3 && guests <= 6 & roomSize == 1) {

        } else if (roomType == 3 && guests <= 10 & roomSize == 2) {

        }

        if (nights > 3) {
            
        }

        final int taxRate = 12;
        return 0;
    }
        
}