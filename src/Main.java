import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        welcome();
        System.out.println("Would you like to Book a night or Exit?");
        System.out.println("[1] Book a night");
        System.out.println("[0] Exit");
        while (true) {
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
                input.nextLine();
            }
        }
    }

    private static void welcome() {
        System.out.println("WELCOME TO HOTEL DE LUNA");
    }

    private static void displayOptions(Scanner input) {
        int roomType = 0, roomOcc = 0, nightCount = 0, guestCount = 0;
        float totalPrice;
        boolean finalComp = false;
        while (finalComp != true) {
            System.out.println();
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
                        roomType = getRoomType(input);
                        System.out.println("ROOM TYPE----> " + roomType);
                        break;
                    case 2:
                        roomOcc = getRoomOcc(input);
                        System.out.println("ROOM OCCUPANCY----> " + roomOcc);
                        break;
                    case 3:
                        nightCount = getNights(input);
                        System.out.println("NIGHTS----> " + nightCount);
                        break;
                    case 4:
                        guestCount = getGuests(input);
                        System.out.println("GUESTS----> " + guestCount);
                        break;
                    case 5:
                        totalPrice = finalCompute(roomType, roomOcc, nightCount, guestCount, input);
                        System.out.println("TOTAL----> " + totalPrice);
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
        System.out.println("\nSelect your Room Type");
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
        System.out.println("\nSelect your Room Occupancy");
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
        System.out.println("\nHow many nights will you be staying?");
        System.out.println("(15% discount is offered at checkout if you stay for more than 3 nights!)");
        System.out.print("ENTER a number: ");
        int nights = input.nextInt();
        return nights;
    }

    private static int getGuests(Scanner input) {
        System.out.println("\nHow many guests will be staying?");
        System.out.print("ENTER a number: ");
        int guests = input.nextInt();
        return guests;
    }

    private static float finalCompute(int roomType, int roomSize, int nights, int guests, Scanner input) {
        System.out.println("ROOM TYPE----> " + roomType);
        System.out.println("ROOM SIZE----> " + roomSize);
        System.out.println("NIGHTS----> " + nights);
        System.out.println("GUESTS----> " + guests);
        int roomBasePrice = 0, guestAddCharge = 0;
        float total;
        switch (roomType) {
            case 1:
                if (roomSize == 1) {
                    roomBasePrice = 1800;
                } else if (roomSize == 2) {
                    roomBasePrice = 2700;
                }
                break;
            case 2:
                if (roomSize == 1) {
                    roomBasePrice = 2300;
                } else if (roomSize == 2) {
                    roomBasePrice = 3200;
                }
                break;
            case 3:
                if (roomSize == 1) {
                    roomBasePrice = 3000;
                } else if (roomSize == 2) {
                    roomBasePrice = 4000;
                }
                break;
            default:
                    roomBasePrice = 4000;
                break;
        }

        total = roomBasePrice * nights;

        if (roomSize == 1) {
            guestAddCharge = (guests - 1) * (int)(roomBasePrice * 0.10);
        } else if (roomSize == 2 && guests > 1) {
            guestAddCharge = (guests - 2) * (int)(roomBasePrice * 0.10);
        }

        total += guestAddCharge;

        if (nights > 3) {
            total -= (total * 0.15);
        }

        System.out.println(total);
        total += (total * 0.12);
        return total;
    }
        
}