package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped

public class RoleService {
    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        var query = entityManager.createQuery("FROM Role");
        return query.getResultList();
    }

    public Role getSingleRole(Long id) {
        return entityManager.find(Role.class, id);
    }
}
