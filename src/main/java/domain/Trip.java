package domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private double groupBalance;
    private Boolean isActive;

    private List<Account> participants;

    public Trip() {
    }

    public Trip(Long id, Date date,
                double groupBalance, Boolean isActive,
                List<Account> participants) {
        this.id = id;
        this.date = date;
        this.groupBalance = groupBalance;
        this.isActive = isActive;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getGroupBalance() {
        return groupBalance;
    }

    public void setGroupBalance(double groupBalance) {
        this.groupBalance = groupBalance;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Account> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Account> participants) {
        this.participants = participants;
    }
}
