package at.thejano.backend.service;

import at.thejano.backend.model.Location;
import at.thejano.backend.repository.LocationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/location") public class LocationService {

    @Inject
    LocationRepository repo;

    @Path("/init")
    @GET
    @Produces (MediaType.TEXT_PLAIN)
    public String init() {
        repo.add(new Location("Rasthausstraße", "1a", "4482", "Ennsdorf", "Austria"));
        return "Init worked /findAll for a List of all Locations";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<Location> findAll(){
        return repo.getAll();
    }

    @Path("delete/{id}")
    @DELETE
    @Produces (MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {
        repo.delete(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public void add(Location l) { repo.add(l); }
}

