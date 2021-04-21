import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean loop = true;
    static Scanner input = new Scanner(System.in);
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


    public static void main(String[] args) {

        menu mainMenu = new menu();

        while (loop) {

            switchChoice(mainMenu.showMenu());

        }
    }


    public static void switchChoice(int choice) {

        switch (choice) {

            case 1:
                createStudent();
                break;
            case 2:
                updateStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                showByID();
                break;
            case 5:
                findByName();
                break;
            case 6:
                findByAge();
                break;
            case 7:
                showAll();
                break;
            case 0:
                loop = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    public static void createStudent() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.println("Name: ");
        String name = input.nextLine();

        System.out.println("Age: ");
        int age = input.nextInt();
        input.nextLine();

        student s1 = new student(name, age);

        em.getTransaction().begin();
        em.persist(s1);
        em.getTransaction().commit();
        em.close();

    }

    public static void updateStudent() {

        System.out.println("ID: ");

        Long id = input.nextLong();
        input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        student s1 = em.find(student.class, id);
        System.out.println(s1);

        System.out.println("New Name: ");
        String name = input.nextLine();

        em.getTransaction().begin();
        s1.setName(name);
        em.getTransaction().commit();
        em.close();

    }

    public static void deleteStudent() {

        System.out.println("Input the ID of the Student you'd like to delete: ");

        Long id = input.nextLong();
        input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        student s1 = em.find(student.class, id);

        em.getTransaction().begin();
        em.remove(s1);
        em.getTransaction().commit();
        em.close();

        System.out.println("<Student with the ID " + id + " has been successfully deleted>");

    }

    public static void showByID() {

        System.out.println("Enter the ID of the Student you'd like to display additional information about: ");

        Long id = input.nextLong();
        input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        student s1 = em.find(student.class, id);

        System.out.println(s1);

        em.close();

    }

    public static void findByName() {

        System.out.println("Enter the name of the Student(s) you'd like to display additional information about: ");

        String name = input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        @SuppressWarnings("unchecked")
        List<student> queryResultList = em.createQuery("Select c From student c").getResultList();

        System.out.println("<Displaying records containing the name " + "<" + name + ">>");
        for (student s : queryResultList) {

            if (s.getName().equals(name)) {
                System.out.println(s);
            }
        }
        System.out.println("<End of list>\n");
        em.close();

    }

    public static void showAll() {

        EntityManager em = entityManagerFactory.createEntityManager();

        @SuppressWarnings("unchecked")
        List<student> queryResultList = em.createQuery("Select c From student c").getResultList();

        System.out.println("<Displaying all table entries>");
        for (student s : queryResultList) {
            System.out.println(s);
        }
        System.out.println("<End of list>\n");
        em.close();
    }

    public static void findByAge() {

        System.out.println("<Enter the AGE interval of the Student(s) you'd like to display additional information about>");
        System.out.print("Low end:");
        int lowEnd = input.nextInt();
        input.nextLine();

        System.out.print("High end:");
        int highEnd = input.nextInt();
        input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        @SuppressWarnings("unchecked")
        List<student> queryResultList = em.createQuery("Select c From student c").getResultList();

        System.out.println("<Displaying all table entries with the age interval " + lowEnd + " to " + highEnd + ">");
        for (student s : queryResultList) {
            if (s.getAge() >= lowEnd && s.getAge() <= highEnd) {
                System.out.println(s);
            }
        }
        System.out.println("<End of list>\n");
        em.close();


    }

}

