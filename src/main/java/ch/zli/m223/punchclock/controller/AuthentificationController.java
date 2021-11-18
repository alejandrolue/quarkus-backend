package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import ch.zli.m223.punchclock.service.UserService;
import io.quarkus.netty.MainEventLoopGroup;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/auth")
@Tag(name = "Authentication", description = "Handles the Authentication")
public class AuthentificationController {
    @Inject
    AuthenticationService authenticationService;

    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new-user")
    @PermitAll
    @Operation(summary = "creates a new user", description = "creates a new user")
    public void newUser(User user) {
        userService.createUser(user);
    }

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
