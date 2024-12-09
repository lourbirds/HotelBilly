import java.util.Scanner;

public class HotelBilly {
	public static final String Reset     = "\033[0m";
	public static final String Black     = "\033[30m";
	public static final String Red       = "\033[31m";
	public static final String Green     = "\033[32m";
	public static final String Yellow    = "\033[33m";
	public static final String Blue      = "\033[34m";
	public static final String Magenta   = "\033[35m";
	public static final String Cyan      = "\033[36m";
	public static final String Gray      = "\033[37m";
	public static final String White     = "\033[97m";
	public static final String Bold      = "\033[1m";
	public static final String Italic    = "\033[3m";
	public static final String Underline = "\033[4m";
	public static final String Invert    = "\033[7m";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userChoice;

        welcome();
        while (true) {
            while (true) {
                System.out.println("\nWould you like to Book a night or Exit?");
                System.out.println("[1] Book a night");
                System.out.println("[0] Exit");
                System.out.print("ENTER 1 or 0: ");
                if (input.hasNextInt()) {
                    userChoice = input.nextInt();
                    switch (userChoice) {
                        case 1:
                            displayOptions(input);
                            break;
                        case 0:
                            System.out.println(Bold + Red + "EXITING PROGRAM..." + Reset);
                            System.exit(0);
                        default:
                            System.out.println("INCORRECT INPUT: Input out of range. Try Again.");
                            break;
                    }
                } else {
                    System.out.println("INCORRECT INPUT: Invalid input type. Try Again.");
                    input.next();
                }
            }
        }
    }

    private static void welcome() {
        System.out.println("WELCOME TO HOTEL DE LUNA");
    }

    private static void displayOptions(Scanner input) {
        int roomType = 0, roomOcc = 0, nightCount = 0, guestCount = 0;
        while (true) {
            roomType = getRoomType(input);
            roomOcc = getRoomOcc(input);
            guestCount = getGuests(roomType, roomOcc, input);
            nightCount = getNights(input);
            displaySelection(roomType, roomOcc, nightCount, guestCount, input);
            checkout(roomType, roomOcc, nightCount, guestCount, input);
            return;
        }
    }

    private static int getRoomType(Scanner input){
        System.out.println("\nSelect your Room Type");
        System.out.println("[1] Standard (1800.00 for Single Occupancy OR 2700.00 for Double Occupancy)");
        System.out.println("[2] Deluxe (2300.00 for Single Occupancy OR 3200.00 for Double Occupancy)");
        System.out.println("[3] Suite (3000.00 for Single Occupancy OR 4000.00 for Double Occupancy)");
        while (true) {
            System.out.print("ENTER a number between 1 to 3: ");
            if (input.hasNextInt()) {
                int roomSelection = input.nextInt();
                if (roomSelection > 0 && roomSelection < 4) {
                    return roomSelection;
                } else {
                    System.out.println("INCORRECT INPUT: Input out of range. Try Again.");
                }
            } else {
                System.out.println("INCORRECT INPUT: Invalid input type. Try Again.");
                input.next();
            }
        }
    }

    private static int getRoomOcc(Scanner input){
        System.out.println("\nSelect your Room Occupancy");
        System.out.println("[1] (Can Support 2, 4, or 6 guests)");
        System.out.println("[2] (Can support 3, 6, or 10 guests. Additional 900 per night.)");
        while (true) {
            System.out.print("ENTER a number between 1 to 2: ");
            if (input.hasNextInt()) {
                int roomSelection = input.nextInt();
                if (roomSelection > 0 && roomSelection < 3) {
                    return roomSelection;
                } else {
                    System.out.println("INCORRECT INPUT: Input out of range. Try Again.");
                }
            } else {
                System.out.println("INCORRECT INPUT: Invalid input type. Try Again.");
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
                } else if (guests <= maxGuests && guests > 0) {
                    return guests;
                } else  if (guests <= 0){
                    System.out.println("GUEST LIMIT SUBCEEDED: Guest number is incompatible with Room Type and Occupancy Size");
                } else {
                    System.out.println("GUEST LIMIT EXCEEDED: Guest number is incompatible with Room Type and Occupancy Size");
                }
            } else {
                System.out.println("INCORRECT INPUT: Invalid input type. Try Again.");
                input.next();
            }
        }
    }


    private static int getNights(Scanner input) {
        System.out.println("\nHow many nights will you be staying?");
        System.out.println("(15% discount is offered at checkout if you stay for more than 3 nights!)");
        while (true) {
            System.out.print("ENTER a number: ");
            if (input.hasNextInt()) {
                int nights = input.nextInt();
                if (nights > 0) {
                    return nights;
                }
            } else {
                System.out.println("INCORRECT INPUT: Invalid input type. Try Again.");
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

    private static void displaySelection(int roomType, int roomSize, int nights, int guests, Scanner input) {
        String roomTypeName, roomSizeName;
        switch (roomType) {
            case 1:
                roomTypeName = "Standard";
                break;
            case 2:
                roomTypeName = "Deluxe";
                break;
            case 3:
                roomTypeName = "Suite";
                break;
            default:
                roomTypeName = "";
                break;
        }
        switch (roomSize) {
            case 1:
                roomSizeName = "Single Occupancy";
                break;
            case 2:
                roomSizeName = "Double Occupancy";
                break;
            default:
                roomSizeName = "";
                break;
        }
        System.out.println("\nROOM TYPE: " + roomTypeName);
        System.out.println("OCCUPANCY SIZE: " + roomSizeName);
        System.out.println("GUESTS: " + guests);
        System.out.println("NUMBER OF NIGHTS: " + nights);
    }

    private static void checkout(int roomType, int roomSize, int nights, int guests, Scanner input) {
        String name, email;
        int age;
        long contact;
        float totalPrice;
        input.nextLine();
        System.out.println("\nPlease input your information to proceed to checkout");
        System.out.print("Enter your Name: ");
        name = input.nextLine();
        while (true) {
            System.out.print("Enter your Age: ");
            if (input.hasNextInt()) {
                age = input.nextInt();
                if (age > 0 && age < 200) {
                    break;
                } else {
                    System.out.println("INCORRECT INPUT: Input out of range. Try Again.");
                }
            } else {
                System.out.println("INCORRECT INPUT: Invalid input type. Try Again.");
                input.nextLine();
            }
        }
        while (true) {
            System.out.print("Enter your Contact Number: ");
            if (input.hasNextLong()) {
                contact = input.nextLong();
                if (String.valueOf(contact).length() > 6 && String.valueOf(contact).length() < 16) {
                    break;
                } else {
                    System.out.println("INCORRECT INPUT: Input out of range. Try Again.");
                }
            } else {
                System.out.println("INCORRECT INPUT: Invalid input type. Try Again.");
                input.nextLine();
            }
        }
        System.out.print("Enter your Email: ");
        input.nextLine();
        email = input.nextLine();

        totalPrice = finalCompute(roomType, roomSize, nights, guests, input);

        System.out.println("\n==========================================");
        System.out.printf("To be paid by: %s (%d)\n", name, age);
        System.out.println("Contact No.: " + contact);
        System.out.println("Email: " + email);
        System.out.println("TOTAL BILL: " + totalPrice);
        
        while (true) {
            System.out.print("\nProceed?\n");
            System.out.println("Enter yes/no:");
            String proceed = input.nextLine().toLowerCase();
            switch (proceed) {
                case "yes":
                    System.out.println("You have booked your stay at HOTEL DE LUNA!");
                    return;
                case "no":
                    System.out.println("Going back to menu...");
                    return;
                default:
                    System.out.println("INCORRECT INPUT: Input out of range. Try Again.");
                    break;
            }
        }
    }
}
