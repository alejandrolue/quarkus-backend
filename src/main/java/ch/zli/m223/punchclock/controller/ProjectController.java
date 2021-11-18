package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class ProjectController {
    @Inject
    ProjectService projectService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Entries", description = "Get's all Projects")
    public List<Project> list() {
        return projectService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets one Project", description = "Gets on Project by the ID")
    public Project getSingleEntry(@PathParam("id") Long id) {
        return projectService.getSingleProjekt(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Project", description = "The newly created Project is returned. The id may not be passed.")
    public Project add(Project project) {
        return projectService.createProject(project);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Remove all Project", description = "Removes Project by id")
    public void deleteProject(@PathParam("id") Long id) {
        projectService.delete(id);
    }
}
