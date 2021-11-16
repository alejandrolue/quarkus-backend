package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import io.quarkus.netty.MainEventLoopGroup;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/auth")
public class AuthentificationController {
    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(User user) {
        if (authenticationService.checkIfUserExists(user)) {
            return authenticationService.GenerateValidJwtToken(user.getUsername());
        } else {
            throw new NotAuthorizedException("user:" + user.getUsername() + "was not found");
        }

    }

}
