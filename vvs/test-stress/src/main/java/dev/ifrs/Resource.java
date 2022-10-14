package dev.ifrs;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Asynchronous;
import org.eclipse.microprofile.faulttolerance.Bulkhead;

import io.smallrye.mutiny.Uni;

@Path("/hello")
public class Resource {
    private static final Logger LOGGER = Logger.getLogger(Resource.class.getName());

    @GET
    @Path("{vu}")
    @Produces(MediaType.TEXT_PLAIN)
    @Asynchronous
    @Bulkhead(value = 5, waitingTaskQueue = 100)
    public Uni<Void> hello(@PathParam("vu") String vu) {
        
        LOGGER.info(vu);
        return null;
        
    }
}