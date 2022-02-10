package at.thejano.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Participant {
    public Participant() {

    }

    public Participant(String firstname, String lastname, char gender, String email, String country, int age) {
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private char gender;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private String country;
    @Column
    private int age;
    @ManyToMany
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

