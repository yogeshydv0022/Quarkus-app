package org.ritpl.restclient.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.ritpl.restclient.dto.PostDto;

import java.util.List;

@RegisterRestClient(baseUri = "https://dummy-json.mock.beeceptor.com")
public interface PostProxy {



    @GET
    @Path("/posts")
    List<PostDto> getAll();


}
