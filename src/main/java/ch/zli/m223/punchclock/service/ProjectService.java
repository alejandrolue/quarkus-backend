package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped

public class ProjectService {

    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
        var query = entityManager.createQuery("From projekt");
        return query.getResultList();
    }

    @Transactional
    public void delete(Long id) {
        Project projectToDelete = getSingleProjekt(id);
        entityManager.remove(projectToDelete);
    }

    public Project getSingleProjekt(Long id) {
        return entityManager.find(Project.class, id);
    }

    @Transactional
    public Project createProject(Project project) {
        entityManager.persist(project);
        return project;
    }
}
