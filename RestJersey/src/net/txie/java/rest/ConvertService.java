package net.txie.java.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;



@Path("/ConvertService")
@Produces(MediaType.APPLICATION_JSON)
public class ConvertService {
	
	
	
	@GET
	@Path("/ctof")
	public Response cToF(){
		return Response.status(200).entity("This is the service to convert C to F").build();
	}

	
	
	@GET
	@Path("/ctof/{c}")
	public Response cToF(@PathParam("c") Double c){
		if(c==null)
			return Response.status(200).entity("This is the service to convert C to F").build();
		
		JSONObject json = new JSONObject();
		json.put("c", c);
		json.put("f", c*9/5+32);
		return Response.status(200).entity(json.toString(2)).build();
	}
	
	
	@GET
	@Path("/ftoc/{f}")
	public Response fToC(@PathParam("f") Double f){
		if(f==null)
			return Response.status(200).entity("This is the service to convert F to C").build();
		
		JSONObject json = new JSONObject();
		json.put("c", (f-32)*5/9);
		json.put("f", f);
		return Response.status(200).entity(json.toString(2)).build();
	}
	
	
	@GET
	@Path("/kmtomile/{km}")
	public Response kmTOMile(@PathParam("km") Double km){
		if(km==null)
			return Response.status(200).entity("This is the service to convert km to mile").build();
		
		JSONObject json = new JSONObject();
		json.put("km", km);
		json.put("mile", km*0.62137);
		return Response.status(200).entity(json.toString(2)).build();
	}
	
	
	@GET
	@Path("/miletokm/{mile}")
	public Response mileTOKM(@PathParam("mile") Double mile){
		if(mile==null)
			return Response.status(200).entity("This is the service to convert mile to km").build();
		
		JSONObject json = new JSONObject();
		json.put("km", mile/0.62137);
		json.put("mile", mile);
		return Response.status(200).entity(json.toString(2)).build();
	}
}
