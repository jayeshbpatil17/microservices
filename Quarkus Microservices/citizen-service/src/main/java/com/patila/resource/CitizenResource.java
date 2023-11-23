package com.patila.resource;

import com.patila.entity.Citizen;
import com.patila.repository.AadharRepository;
import com.patila.repository.CitizenRepository;
import jakarta.inject.Inject;
import jakarta.json.JsonArray;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/citizen")
public class CitizenResource {

    @Inject
    CitizenRepository citizenRepository;

    @Inject
    AadharRepository aadharRepository;

    @GET
    public List<Citizen> getCitizen(){
        List<Citizen> citizens = citizenRepository.listAll();
        return citizens;
    }

    @POST
    @Transactional
    public Response saveCitizenAadhar(Citizen citizen){
        citizenRepository.persist(citizen);
        return Response.status(Response.Status.CREATED).build();
    }
}
