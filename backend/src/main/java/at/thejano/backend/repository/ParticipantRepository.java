package at.thejano.backend.repository;

import at.thejano.backend.model.Participant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ParticipantRepository {

    @Inject private EntityManager em;

    @Transactional
    public List<Participant> getAll() {
        return em.createQuery("SELECT * FROM Participant").getResultList();
    }

    @Transactional
    public void add(Participant participant) {
        em.persist(participant);
    }

    @Transactional
    public void delete(int id) {
        em.remove(em.find(Participant.class, id));
    }
}
