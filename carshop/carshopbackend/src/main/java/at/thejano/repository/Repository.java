package at.thejano.repository;

import at.thejano.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class Repository {

    @Inject
    private EntityManager entityManager;

    public Collection<Car> getCars() {
        return entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }

    public Collection<Make> getMakes() {
        return entityManager.createQuery("SELECT m FROM Make m", Make.class).getResultList();
    }

    @Transactional
    public void addNewCar(Car car) {
        if (getMakes().stream().noneMatch(m -> m.getName().equals(car.getMake().getName()))) {
            entityManager.persist(car.getMake());
        }
        var make = getMakes()
                .stream()
                .filter(m -> m.getName().equals(car.getMake().getName()))
                .findFirst()
                .orElseThrow();

        if (getCars().stream().noneMatch(c -> c.getModel().equals(car.getModel()))) {
            car.setMake(make);
            entityManager.persist(car);
        }
    }

    public ShopUser getUserById(long userId) {
        return entityManager.find(ShopUser.class, userId);
    }

    public ShopUser getUser(String username) {
        TypedQuery<ShopUser> query = entityManager.createQuery("SELECT u FROM ShopUser u WHERE u.name = :name", ShopUser.class);
        ShopUser user = query.setParameter("name", username).getResultList().stream().findFirst().orElse(null);
        return user;
    }

    public Collection<ShopUser> getUsers() {
        return entityManager.createQuery("SELECT u FROM ShopUser u ", ShopUser.class).getResultList();
    }

    @Transactional
    public void registerUser(ShopUser user) {
        entityManager.persist(user);
    }
}
