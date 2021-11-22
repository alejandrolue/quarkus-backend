package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import java.util.List;

@ApplicationScoped

public class UserService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    public User getSingleUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void delete(Long id) {
        User userToDelete = getSingleUser(id);
        entityManager.remove(userToDelete);
    }
    @Transactional
    public User update(User user){
        entityManager.merge(user);
        return user;
    }


    public User matchCredentials(String username, String password) {
        TypedQuery<User> tq = entityManager.createQuery("From User WHERE username=?1", User.class);
        User result;
        try {
            result = tq.setParameter(1, username).getSingleResult();
        } catch (NoResultException e) {
            throw new BadRequestException("No User was found with that username: " + username);
        }
        if (result == null) {
            throw new BadRequestException("No User was found with that username: " + username);
        } else if (!result.getPassword().equals(password)) {
            throw new RuntimeException("passwords do not match");
        }
        return result;
    }
}
