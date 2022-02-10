package at.thejano.backend.service;

import at.thejano.backend.model.Participant;
import at.thejano.backend.repository.ParticipantRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/participant") public class ParticipantService {

    @Inject
    ParticipantRepository repo;

    @Path("/init")
    @GET
    @Produces (MediaType.TEXT_PLAIN)
    public String init() {
        repo.add(new Participant("Jan", "Fischlmayr", 'M', "jan.fischlmayr@mail.com", "Austria", 18));
        repo.add(new Participant("David", "Braus", 'M', "david.braus@mail.com", "Austria", 18));
        repo.add(new Participant("Daniel", "Kastenarduino", 'M', "daniel.kastenarduino@mail.com", "Austria", 17));
        return "Init worked /findAll for a List of the Participants";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<Participant> findAll(){
        return repo.getAll();
    }

    @Path("delete/{id}")
    @DELETE
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {
        repo.delete(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public void add(Participant p) { repo.add(p); }
}
