import javax.persistence.*;
import java.io.Serializable;

@Entity
public class student implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    @OneToOne
    public phone phoneNr;

    public student() {
    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public student(String name, phone phone) {
        this.name = name;
        this.phoneNr = phone;
    }

    public phone getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(phone phoneNr) {
        this.phoneNr = phoneNr;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\n" + phoneNr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Long) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof student)) {
            return false;
        }
        student other = (student) object;
        return this.id.equals(other.id);
    }
}
