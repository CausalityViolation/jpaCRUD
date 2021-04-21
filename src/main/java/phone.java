import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class phone implements Serializable {

    @Id
    private String phoneNr;
    private String carrier;

    public phone() {
    }

    public phone(String phoneNr, String carrier) {
        this.phoneNr = phoneNr;
        this.carrier = carrier;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Phone Number: " + phoneNr + "\nCarrier: " + carrier;
    }
}
