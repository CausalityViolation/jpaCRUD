public class menu {

    public int showMenu() {

        System.out.println("1. Add student");
        System.out.println("2. Update a students name");
        System.out.println("3. Delete students");
        System.out.println("4. Search students by ID");
        System.out.println("5. Search students by Name");
        System.out.println("6. Search students by Age");
        System.out.println("7. Display all table entries");
        System.out.println("0. Exit");

        int choice = Main.input.nextInt();
        Main.input.nextLine();

        return choice;

    }

}
