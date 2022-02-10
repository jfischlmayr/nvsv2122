package at.thejano.backend.service;

import at.thejano.backend.model.Contest;
import at.thejano.backend.model.Location;
import at.thejano.backend.repository.ContestRepository;
import at.thejano.backend.repository.LocationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/contest") public class ContestService {

    @Inject
    ContestRepository repo;
    @Inject
    LocationRepository locrepo;

    @Path("/init")
    @GET
    @Produces (MediaType.TEXT_PLAIN)
    public String init() {
        List<Location> locations = locrepo.getAll();
        repo.add(new Contest(locations.get(1), "Fischer Contest"));
        return "Init worked /findAll for a List of all Contests";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<Contest> findAll(){
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
    public void add(Contest c) { repo.add(c); }
}
