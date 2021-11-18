package ch.zli.m223.punchclock.domain;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @ManyToOne
    @JoinColumn(name="teams_id", nullable = false)
    private Teams teams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }
}
