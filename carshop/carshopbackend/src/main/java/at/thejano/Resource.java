package at.thejano;

import at.thejano.model.*;
import at.thejano.repository.Repository;
import at.thejano.util.*;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashSet;

@Path("/api")
@RequestScoped
public class Resource {

    @Inject
    JsonWebToken jwt;

    @Inject
    Repository repository;

    @GET
    @Path("init")
    public Response init() {
        Make skoda = new Make("Skoda");
        Make lamborghini = new Make("Lamborghini");
        Make audi = new Make("Audi");
        repository.addNewCar(new Car(skoda, "Fabia", 15000.00D));
        repository.addNewCar(new Car(skoda, "Octavia", 30868.00D));
        repository.addNewCar(new Car(skoda, "Octavia RS", 55231.00D));
        repository.addNewCar(new Car(skoda, "Kodiaq", 45123.00D));
        repository.addNewCar(new Car(audi, "R8", 112000.00D));
        repository.addNewCar(new Car(audi, "A6", 63560.00D));
        repository.addNewCar(new Car(audi, "RS6", 82205.00D));
        repository.addNewCar(new Car(lamborghini, "Aventador", 270715.00D));
        repository.addNewCar(new Car(lamborghini, "Huracan", 210325.00D));
        repository.addNewCar(new Car(lamborghini, "Urus", 265010.00D));
        return Response.ok(repository.getCars()).build();
    }

    @GET
    @Path("getCars")
    @RolesAllowed("User")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars() {
        return Response.ok(repository.getCars()).build();
    }

    @POST
    @Path("login")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Login loginModel) {
        String hashedPassword = HashUtil.hashString(loginModel.password);

        //Get user
        ShopUser user = repository.getUser(loginModel.userName);
        if (user != null) {
            if (hashedPassword == null || !hashedPassword.equals(user.getPasswordHash())) {
                return Response.status(401).build();
            }
        }
        else {
            return Response.status(404).build();
        }

        //Generate a JWT for User
        String jwt = Jwt.issuer("https://luxurycarshop.at/")
                .upn("jan.fischlmayr@gmx.net")
                .groups(new HashSet<>(Collections.singletonList("User")))
                .claim(Claims.nickname, loginModel.userName)
                .claim(JWTClaim.USER_ID.getValue(), user.getId())
                .sign();

        return Response.ok(new Login.LoginResult(jwt)).build();
    }

    @POST
    @Path("register")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(Register registerModel) {
        String hashedPassword = HashUtil.hashString(registerModel.password);

        //Check if a user already exists
        ShopUser user = repository.getUser(registerModel.userName);
        if (user != null) {
            return Response.status(401).build();
        }

        //Save new user
        user = new ShopUser(registerModel.userName, hashedPassword);
        repository.registerUser(user);
        return Response.ok().build();
    }

    @GET
    @Path("info")
    @RolesAllowed("User")
    @Produces(MediaType.APPLICATION_JSON)
    public Response info() {
        var id = Long.parseLong(jwt.claim(JWTClaim.USER_ID.getValue()).stream().findFirst().orElse("-1").toString());
        var user = repository.getUserById(id);

        if (user == null) {
            return Response.status(401).build();
        }
        return Response.ok(user).build();
    }
}