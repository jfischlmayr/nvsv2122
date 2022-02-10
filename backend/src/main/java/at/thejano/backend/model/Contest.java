package at.thejano.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contest {
    public Contest() {

    }

    public Contest(Location location, String title) {
        this.location = location;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @Column
    private Location location;
    @Column
    private String title;
    @ManyToMany
    @Column
    private List<Participant> participants;

    public long getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}

