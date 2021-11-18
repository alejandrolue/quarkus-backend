package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projektName;

    @ManyToOne
    @JoinColumn(name="teams_id", nullable = false)
    private Teams teams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) {
        this.projektName = projektName;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }
}
