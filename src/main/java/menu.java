public class menu {

    public int showMenu() {

        System.out.println("1. Add student");
        System.out.println("2. Update a students name");
        System.out.println("3. Delete students");
        System.out.println("4. Search students by ID");
        System.out.println("5. Search students by Name");
        System.out.println("6. Search students by Age");
        System.out.println("7. Display all table entries");
        System.out.println("8. Student Phone Numbers Sub Menu");
        System.out.println("0. Exit");

        int choice = Main.input.nextInt();
        Main.input.nextLine();
        return choice;

    }

    public static void switchChoice(int choice) {

        switch (choice) {

            case 1:
                management.createStudent();
                break;
            case 2:
                management.updateStudent();
                break;
            case 3:
                management.deleteStudent();
                break;
            case 4:
                management.showByID();
                break;
            case 5:
                management.findByName();
                break;
            case 6:
                management.findByAge();
                break;
            case 7:
                management.showAll();
                break;
            case 8:

                System.out.println("<Phone Sub Menu>");
                System.out.println("1. Display all phone numbers on record");
                System.out.println("2. Search for phone number by owner ID");
                System.out.println("3. Search for phone number by owner NAME");
                System.out.println("4. Add a new phone number to registry");
                System.out.println("5. Simultaneously add (new)Student (new)phone number");
                System.out.println("6. Connect an existing phone number to a Student");
                System.out.println("7. Disconnect phone number from a Student");
                System.out.println("8. Add a NEW Phone number to an existing Student");
                System.out.println("9. Display Phone Number by Carrier");
                System.out.println("0. Exit");

                int subChoice = Main.input.nextInt();
                Main.input.nextLine();
                subMenuChoice(subChoice);
                break;
            case 0:
                Main.loop = false;
                break;
            default:
                throw new IllegalStateException("Unacceptable input parameter. Please Input a number between 1 and 8. 0 to exit.");
        }
    }


    public static void subMenuChoice(int subChoice) {

        switch (subChoice) {

            case 1:
                management.displayAllPhoneNumbers();
                break;
            case 2:
                management.searchPhoneByID();
                break;
            case 3:
                management.searchPhoneByName();
                break;
            case 4:
                management.addPhone();
                break;
            case 5:
                management.addPhoneAndStudent();
                break;
            case 6:
                management.connectPhoneWithStudent();
                break;
            case 7:
                management.disconnectPhone();
                break;
            case 8:
                management.addNewPhoneNumberToStudent();
                break;
            case 9:
                management.displayCarrier();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unacceptable input parameter. Please Input a number between 1 and 7. 0 to exit.");
        }
    }
}




