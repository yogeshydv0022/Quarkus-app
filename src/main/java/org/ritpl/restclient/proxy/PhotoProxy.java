package org.ritpl.restclient.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.ritpl.restclient.dto.PhotoDto;

import java.util.List;

@RegisterRestClient(baseUri = "https://jsonplaceholder.typicode.com")
public interface PhotoProxy {


    @Path("/photos")
    @GET
    List<PhotoDto> getAll();

}
