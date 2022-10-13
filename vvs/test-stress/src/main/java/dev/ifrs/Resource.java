package dev.ifrs;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Bulkhead;

@Path("/hello")
public class Resource {
    private static final Logger LOGGER = Logger.getLogger(Resource.class.getName());

    @GET
    @Path("{vu}")
    @Produces(MediaType.TEXT_PLAIN)
    @Bulkhead(2)
    public void hello(@PathParam("vu") String vu) {

        LOGGER.info(vu);
        
    }
}