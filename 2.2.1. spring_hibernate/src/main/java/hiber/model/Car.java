package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car {

    @Column(name = "model")
    private String model;
    @Id
    @Column(name = "series")
    private int series;
//    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    @OneToOne(optional = false, mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
