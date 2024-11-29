import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        welcome();
        while (true) {
            System.out.println("\nWould you like to Book a night or Exit?");
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
                input.next();
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
            System.out.println("\n[1] Select Room Type");
            System.out.println("[2] Select Room Size");
            System.out.println("[3] Select Number of Guests");
            System.out.println("[4] Select Number of Nights");
            System.out.println("[5] Display Current Selection");
            System.out.println("[6] CHECKOUT");
            System.out.println("[0] Exit");
            System.out.print("ENTER a number between 1 to 5: ");
            if (input.hasNextInt()) {
                int userChoice = input.nextInt();
                switch (userChoice) {
                    case 1:
                        roomType = getRoomType(input);
                        break;
                    case 2:
                        roomOcc = getRoomOcc(input);
                        break;
                    case 3:
                        guestCount = getGuests(roomType, roomOcc, input);
                        break;
                    case 4:
                        nightCount = getNights(input);
                        break;
                    case 6:
                        totalPrice = finalCompute(roomType, roomOcc, nightCount, guestCount, input);
                        // Wanted to use a String List or a Class to hold multiple values but too risky.
                        // TODO: Ask if it is okay to use Classes.
                        checkout(roomType, roomOcc, nightCount, guestCount, input);
                        finalComp = true;
                        System.out.println(totalPrice);
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
                input.next();
            }
        }
    	
    }

    private static int getRoomType(Scanner input){
        System.out.println("\nSelect your Room Type");
        System.out.println("[1] Standard (1800.00 for Single Occupancy OR 2700.00 for Double Occupancy)");
        System.out.println("[2] Deluxe (2300.00 for Single Occupancy OR 3200.00 for Double Occupancy)");
        System.out.println("[3] Suite (3000.00 for Single Occupancy OR 4000.00 for Double Occupancy)");
        System.out.println("[0] Go back");
        while (true) {
            System.out.print("ENTER a number between 1 to 3: ");
            if (input.hasNextInt()) {
                int roomSelection = input.nextInt();
                if (roomSelection == 0) {
                    return 0;
                } else if (roomSelection > 0 || roomSelection < 4) {
                    return roomSelection;
                } else {
                    System.out.println("INCORRECT INPUT. TRY AGAIN.");
                }
            } else {
                System.out.println("INCORRECT INPUT. TRY AGAIN.");
                input.next();
            }
        }
    }

    private static int getRoomOcc(Scanner input){
        System.out.println("\nSelect your Room Occupancy");
        System.out.println("[1] (Can Support 2, 4, or 6 guests)");
        System.out.println("[2] (Can support 3, 6, or 10 guests. Additional 900 per night.)");
        System.out.println("[0] Go back");
        while (true) {
            System.out.print("ENTER a number between 1 to 2: ");
            if (input.hasNextInt()) {
                int roomSelection = input.nextInt();
                if (roomSelection == 0) {
                    return 0;
                } else if (roomSelection > 0 || roomSelection < 3) {
                    return roomSelection;
                } else {
                    System.out.println("INCORRECT INPUT. TRY AGAIN.");
                }
            } else {
                System.out.println("INCORRECT INPUT. TRY AGAIN.");
                input.next();
            }
        }
    }

    private static int getGuests(int roomType, int roomOcc, Scanner input) {
        System.out.println("\nHow many guests will be staying?");
        int maxGuests;

        switch (roomType) {
            case 1:
                maxGuests = (roomOcc == 1) ? 2 : 3;
                break;
            case 2:
                maxGuests = (roomOcc == 1) ? 4 : 6;
                break;
            case 3:
                maxGuests = (roomOcc == 1) ? 6 : 10;
                break;
            default:
                System.out.println("Invalid Room Type or Occupancy.");
                return 0;
        }

        while (true) {
            System.out.print("ENTER a number (0 to Go back): ");
            if (input.hasNextInt()) {
                int guests = input.nextInt();
                if (guests == 0) {
                    return 0;
                } else if (guests <= maxGuests) {
                    return guests;
                } else {
                    System.out.println("Guest number is incompatible with Room Type and Occupancy Size");
                }
            } else {
                System.out.println("INCORRECT INPUT. TRY AGAIN.");
                input.next();
            }
        }
    }


    private static int getNights(Scanner input) {
        System.out.println("\nHow many nights will you be staying?");
        System.out.println("(15% discount is offered at checkout if you stay for more than 3 nights!)");
        while (true) {
            System.out.print("ENTER a number (0 to Go back): ");
            if (input.hasNextInt()) {
                int nights = input.nextInt();
                if (nights == 0) {
                    return 0;
                } else {
                    return nights;
                }
            } else {
                System.out.println("INCORRECT INPUT. TRY AGAIN.");
                input.next();
            }
        }
    }

    private static float finalCompute(int roomType, int roomSize, int nights, int guests, Scanner input) {
        int roomBasePrice = 0, guestAddCharge = 0;
        float total = 0;
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

        if (roomSize == 1) {
            guestAddCharge = (guests - 1) * (int)(roomBasePrice * 0.10);
        } else if (roomSize == 2 && guests > 1) {
            guestAddCharge = (guests - 2) * (int)(roomBasePrice * 0.10);
        }

        roomBasePrice += guestAddCharge;

        total = roomBasePrice * nights;

        if (nights > 3) {
            total -= (total * 0.15);
        }
        total += (total * 0.12);

        return total;
    }

    private static void checkout(int roomType, int roomSize, int nights, int guests, Scanner input) {
        System.out.println("Please input your information to proceed to checkout");
        System.out.println("Enter your Name: ");
        System.out.println("Enter your Age: ");
        System.out.println("Enter your Contact Number: ");
        System.out.println("Enter your Email: ");
    }
        
}