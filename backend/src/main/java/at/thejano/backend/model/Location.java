package at.thejano.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    public Location() {

    }

    public Location(String street, String housenumber, String zipcode, String city, String country) {
        this.street = street;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.country = country;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String country;
    @Column
    private String street;
    @Column
    private String housenumber;
    @Column
    private String zipcode;
    @Column
    private String city;
    @OneToMany
    @Column
    private List<Contest> contestList;

    public List<Contest> getContestList() {
        return contestList;
    }

    public void setContestList(List<Contest> contestList) {
        this.contestList = contestList;
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
