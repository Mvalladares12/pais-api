package org.mv.municipio;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.mv.departamento.Departamento;

import java.util.List;

@Path("/municipio")
public class MunicipioResources {

    @Inject
    MunicipioRepository municipioRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Municipio> findAll() {
        return municipioRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Municipio getDep(@PathParam("id") Long id) {
        return municipioRepository.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Municipio municipio) {
        municipioRepository.persist(municipio);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id){
        municipioRepository.deleteById(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Municipio update(@PathParam("id")Long id, Municipio municipio) {
        var entity = municipioRepository.findById(id);
        if (entity != null) {
            entity.setCodigo(municipio.getCodigo());
            entity.setNombre(municipio.getNombre());
            municipioRepository.persist(entity);
            return entity;
        }else {
            throw new NotFoundException();
        }
    }
}
