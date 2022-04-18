package at.thejano.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Make make;

    private String model;
    private double price;

    public Car() { }

    public Car(Make make, String model, double price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public Make getMake() {
        return this.make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String name) {
        this.model = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
