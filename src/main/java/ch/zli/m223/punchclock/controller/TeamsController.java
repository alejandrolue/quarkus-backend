package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Teams;
import ch.zli.m223.punchclock.service.TeamsService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teams")
@Tag(name = "Teams", description = "Handling of Teams")
public class TeamsController {
    @Inject
    TeamsService teamsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Teams", description = "Get's all Teams")
    public List<Teams> list() {
        return teamsService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets one Project", description = "Gets one Team by the ID")
    public Teams getSingleEntry(@PathParam("id") Long id) {
        return teamsService.getSingleTeams(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Project", description = "The newly created Projekt is returned. The id may not be passed.")
    public Teams add(Teams teams) {
        return teamsService.createTeam(teams);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Remove Team by ID", description = "Removes Team by id")
    public void delete(@PathParam("id") Long id) {
        teamsService.deleteTeam(id);
    }
}
