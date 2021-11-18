package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.domain.Teams;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class TeamsService {
    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Teams> findAll() {
        var query = entityManager.createQuery("From teams");
        return query.getResultList();
    }

    @Transactional
    public void deleteTeam(Long id) {
        Teams teamsToDelete = getSingleTeams(id);
        entityManager.remove(teamsToDelete);
    }

    public Teams getSingleTeams(Long id) {
        return entityManager.find(Teams.class, id);
    }

    @Transactional
    public Teams createTeam(Teams team) {
        entityManager.persist(team);
        return team;
    }
}

