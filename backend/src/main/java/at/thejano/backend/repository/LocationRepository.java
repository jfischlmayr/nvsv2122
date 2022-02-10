package at.thejano.backend.repository;

import at.thejano.backend.model.Location;
import at.thejano.backend.model.Participant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LocationRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public List<Location> getAll() {
        return em.createQuery("SELECT * FROM Location").getResultList();
    }

    @Transactional
    public void add(Location location) {
        em.persist(location);
    }

    @Transactional
    public void delete(long id) {
        em.remove(em.find(Participant.class, id));
    }
}
