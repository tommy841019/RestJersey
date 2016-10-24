package net.txie.java.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/GreetingService")
public class GreetingService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response greeting(){
		return Response.status(200).entity(new String("Hello")).build();
	}
	
	
	
	@Path("{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response greetingTo(@PathParam("name") String name){
		return Response.status(200).entity(new String("Hello "+name)).build();
	}
	
	
	
	@Path("{year}/{month}/{day}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day){
		JSONObject json = new JSONObject();
		json.put("year", year);
		json.put("month", month);
		json.put("day", day);
		json.put("full", String.format("%d/%d/%d", day, month, year));
		return Response.status(200).entity(json.toString(2)).build();
	}
}
