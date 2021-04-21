import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class student {

    private Long id;
    private String name;
    private int age;

    public student() {
    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
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
        return "\nStudent ID: " + getId() + "\nName: " + getName() + "\nAge: " + getAge() + "\n";
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
