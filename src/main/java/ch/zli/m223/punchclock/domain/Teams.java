package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String teamName;

    @OneToMany(mappedBy = "teams", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Project> project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProjects(List<Project> project) {
        this.project = project;
    }
}
