package at.thejano.backend.repository;

import at.thejano.backend.model.Contest;
import at.thejano.backend.model.Participant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ContestRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public List<Contest> getAll() {
        return em.createQuery("SELECT * FROM Contest ").getResultList();
    }

    @Transactional
    public void add(Contest contest) {
        em.persist(contest);
    }

    @Transactional
    public void delete(long id) {em.remove(em.find(Participant.class, id));}
}
