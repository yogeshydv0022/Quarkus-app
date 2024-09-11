package org.ritpl.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.ritpl.restclient.dto.PhotoDto;
import org.ritpl.restclient.proxy.PhotoProxy;

import java.util.List;

@Path("/photos")
public class PhotoRestClientResource {

    @Inject
    @RestClient
    private PhotoProxy photoProxy;

    @Path("/")
    @GET
    public Response getAllPhotos(){
        List<PhotoDto> allPhotos=photoProxy.getAll();
        return Response.status(Response.Status.OK).entity(allPhotos).build();
    }
}
