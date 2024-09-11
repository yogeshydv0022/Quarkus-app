package org.ritpl.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.ritpl.restclient.dto.PostDto;
import org.ritpl.restclient.proxy.PostProxy;

import java.util.List;


@Path("/post")
public class PostRestClientResource {

    @RestClient
    private PostProxy postProxy;


    @GET
    @Path("/")
    public Response getAll() {
        List<PostDto> allPost = postProxy.getAll();
        return Response.ok(allPost).build();
    }

}
