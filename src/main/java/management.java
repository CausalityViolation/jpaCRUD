import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class management {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public static void createStudent() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.println("Name: ");
        String name = Main.input.nextLine();

        System.out.println("Age: ");
        int age = Main.input.nextInt();
        Main.input.nextLine();

        student s1 = new student(name, age);

        em.getTransaction().begin();
        em.persist(s1);
        em.getTransaction().commit();
        em.close();

    }

    public static void updateStudent() {

        System.out.println("ID: ");

        Long id = Main.input.nextLong();
        Main.input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        student s1 = em.find(student.class, id);
        System.out.println(s1);

        System.out.println("New Name: ");
        String name = Main.input.nextLine();

        em.getTransaction().begin();
        s1.setName(name);
        em.getTransaction().commit();
        em.close();

    }

    public static void deleteStudent() {

        System.out.println("Input the ID of the Student you'd like to delete: ");

        Long id = Main.input.nextLong();
        Main.input.nextLine();

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

        Long id = Main.input.nextLong();
        Main.input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        student s1 = em.find(student.class, id);

        System.out.println(s1);

        em.close();

    }

    public static void findByName() {

        System.out.println("Enter the name of the Student(s) you'd like to display additional information about: ");

        String name = Main.input.nextLine();

        EntityManager em = entityManagerFactory.createEntityManager();

        List<student> queryResultList = em.createQuery("Select c From student c", student.class).getResultList();

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

        List<student> queryResultList = em.createQuery("Select c From student c", student.class).getResultList();

        System.out.println("<Displaying all table entries>");
        for (Object s : queryResultList) {
            System.out.println(s);
        }
        System.out.println("<End of list>\n");
        em.close();
    }

    public static void findByAge() {

        System.out.println("<Enter the AGE interval of the Student(s) you'd like to display additional information about>");
        System.out.print("Low end:");
        int lowEnd = Main.input.nextInt();
        Main.input.nextLine();

        System.out.print("High end:");
        int highEnd = Main.input.nextInt();
        Main.input.nextLine();

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

    public static void displayAllPhoneNumbers() {

        EntityManager em = entityManagerFactory.createEntityManager();

        @SuppressWarnings("unchecked")
        List<String> queryResultList = em.createQuery("select p.phoneNr From phone p").getResultList();

        System.out.println("<Displaying all table entries>");
        for (String s : queryResultList) {
            System.out.println(s);
        }
        System.out.println("<End of list>\n");
        em.close();

    }

    public static void addPhone() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.println("Input new Phone Number: ");
        String nr = Main.input.nextLine();

        System.out.println("Input new Carrier: ");
        String carrier = Main.input.nextLine();

        phone newP = new phone(nr, carrier);
        em.getTransaction().begin();
        em.persist(newP);
        em.getTransaction().commit();
        em.close();

    }

    public static void searchPhoneByID() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.print("Input Student ID: ");
        long id = Main.input.nextLong();
        Main.input.nextLine();

        student s = em.find(student.class, id);

        System.out.println(s);
        em.close();

    }

    public static void addPhoneAndStudent() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.println("<Enter new Student Information>");
        System.out.print("Input NAME: ");
        String name = Main.input.nextLine();

        System.out.print("Input AGE: ");
        int age = Main.input.nextInt();
        Main.input.nextLine();

        student s = new student(name, age);

        System.out.print("Input Phone Number: ");
        String phoneNr = Main.input.nextLine();

        System.out.print("Input Carrier: ");
        String carrier = Main.input.nextLine();

        phone p = new phone(phoneNr, carrier);

        s.setPhoneNr(p);

        em.getTransaction().begin();
        em.persist(s);
        em.persist(p);
        em.getTransaction().commit();
        em.close();

    }

    public static void searchPhoneByName() {

        EntityManager em = entityManagerFactory.createEntityManager();
        System.out.println("Enter the name of the Student(s) whose phone number you'd like to display: ");
        String name = Main.input.nextLine();

        List<student> queryResultList = em.createQuery("Select c From student c", student.class).getResultList();

        System.out.println("<Displaying Phone Numbers with references to the name " + "<" + name + ">>");
        for (student s : queryResultList) {

            if (s.getName().equals(name)) {
                System.out.println(s.getPhoneNr());
            }
        }
        System.out.println("<End of list>\n");
        em.close();
    }

    public static void connectPhoneWithStudent() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.print("Input the ID of the student you'd like to connect to an existing Phone Number: ");
        long id = Main.input.nextLong();
        Main.input.nextLine();

        System.out.print("Enter an existing Phone Number to link with: ");
        String phoneNr = Main.input.nextLine();

        student s = em.find(student.class, id);
        phone p = em.find(phone.class, phoneNr);

        em.getTransaction().begin();
        s.setPhoneNr(p);
        em.getTransaction().commit();
        em.close();

    }

    public static void disconnectPhone() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.print("Enter the ID of the student whose Phone Number you'd like to disconnect:  ");
        long id = Main.input.nextLong();
        Main.input.nextLine();

        student s = em.find(student.class, id);

        em.getTransaction().begin();
        s.setPhoneNr(null);
        em.getTransaction().commit();
        em.close();

    }

    public static void addNewPhoneNumberToStudent() {

        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.print("Enter the ID of the student to whom you'd like to add a NEW Phone Number: ");
        long id = Main.input.nextLong();
        Main.input.nextLine();

        System.out.println("<Warning>");
        System.out.println("<This will overwrite previously recorded entries>");
        System.out.println("<Warning>");

        System.out.print("\nEnter a NEW Phone Number: ");
        String phoneNr = Main.input.nextLine();

        System.out.print("Input Carrier: ");
        String carrier = Main.input.nextLine();

        student s = em.find(student.class, id);
        phone p = new phone(phoneNr, carrier);

        s.setPhoneNr(p);

        em.getTransaction().begin();
        em.persist(p);
        em.persist(s);
        em.getTransaction().commit();
        em.close();

    }

    public static void displayCarrier() {

        EntityManager em = entityManagerFactory.createEntityManager();
        System.out.println("Input Carrier name: ");
        String carrierName = Main.input.nextLine();

        List<phone> queryResultList = em.createQuery("Select p From phone p", phone.class).getResultList();

        System.out.println("<Displaying Phone Numbers with references to the carrier " + "<" + carrierName + ">>");
        for (phone p : queryResultList) {

            if (p.getCarrier().equals(carrierName)) {
                System.out.println(p.getPhoneNr());
            }
        }
        System.out.println("<End of list>\n");
        em.close();

    }


}
