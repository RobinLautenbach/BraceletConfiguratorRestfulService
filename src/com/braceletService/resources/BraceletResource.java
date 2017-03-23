package com.braceletService.resources;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.braceletService.model.Bracelet;
import com.braceletService.service.BraceletService;


@Consumes("application/xml")
@Produces("application/xml") 
@Path("bracelets")
public class BraceletResource {
	
	BraceletService service = new BraceletService();
    
    @GET
    public Response getAllBracelets(@QueryParam("start")@DefaultValue("-1") int start,@QueryParam("size")@DefaultValue("-1") int size) {
    	GenericEntity<List<Bracelet>> entity;
    	if(start >= 0 && size >= 0){
        	List<Bracelet> bracelets = service.getAllBraceletsPaginated(start, size);
        	entity = new GenericEntity<List<Bracelet>>(bracelets) {};
        	return Response.ok()
        			.header("braceletsInDB", service.getDBSize())
        			.entity(entity).build();
        }
        List<Bracelet> bracelets = service.getAllBracelets();
        entity = new GenericEntity<List<Bracelet>>(bracelets) {};
        return Response.ok()
        		.header("braceletsInDB", service.getDBSize())
        		.entity(entity).build();
    } 
    
    @GET
    @Path("/{braceletId}")	
    public Bracelet getBracelet(@PathParam("braceletId") long id) {
        return service.getBracelet(id);
    }
    
    @POST
    public Response addBracelet(Bracelet b, @Context UriInfo uriInfo) throws URISyntaxException{
    	Bracelet newBracelet = service.addBracelet(b);
    	String newId = String.valueOf(newBracelet.getId());
    	URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
    	return Response.created(uri)
    			.entity(newBracelet)
    			.build();
    }
    
    @PUT
    @Path("/{braceletId}")   
    public Bracelet updateBracelet(@PathParam("braceletId") long id, Bracelet b){
    	b.setId(id);
    	return service.updateBracelet(b);
    }
    
    @DELETE
    @Path("/{braceletId}")
    public void deleteBracelet(@PathParam("braceletId") long id){
    	service.removeBracelet(id);
    }
}