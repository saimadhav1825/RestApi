package com.sai.RestApi;

import java.sql.SQLException;
import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("AlienController")
public class AlienController {
	AlienRepository repo=new AlienRepository();
	@GET
	@Path("aliens")
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAlien() throws SQLException {
		return repo.getAlien();	
	}
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien(@PathParam("id") int id) throws SQLException
	{
		return repo.getalien(id);
	}
	
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_XML)
	public Alien createAlien(Alien a1) throws SQLException
	{
		return repo.createAlien(a1);
		
	}
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Alien deletAlien(@PathParam("id") int id) throws SQLException {
		Alien a=repo.getalien(id);
	
		if(a.getAid()==0)
		
		repo.deleteAlien(id);
		return a;	
	}
	/**@GET ->to fetch data use get @get anotation
	 
	@Produces(MediaType.APPLICATION_XML)  @GET
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien() {
		Alien a=new Alien();
		a.setAid(101);
		a.setAname("prakash");
		a.setAtech("java");
		return a;	
	}*/
	
	/**@GET    ->if we want to fetch list of data or resources
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAlien() {
		Alien a=new Alien();
		a.setAid(101);
		a.setAname("prakash");
		a.setAtech("java");
		Alien a1=new Alien();
		a.setAid(102);
		a.setAname("siva");
		a.setAtech("c++");
		list<Alien> aliens=Arrays.aslist(a,a1)
		return aliens;	
	}*/
	
	

}
