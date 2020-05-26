package com.sai.RestApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	
	
	Connection con=null;
	List<Alien> aliens;
	
	public AlienRepository() 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		}catch(Exception e)
		{
		}
	}
	public List<Alien> getAlien() throws SQLException{
		aliens=new ArrayList<Alien>();
		
		         Statement st=con.createStatement();
               ResultSet rs=st.executeQuery("select * from Alien");
               while(rs.next()){
		         Alien a=new Alien();
		          a.setAid(rs.getInt(1));
           	   a.setAname(rs.getString(2));
           	  a.setAtech(rs.getString(3));   
           	  aliens.add(a);
               }	return aliens;
	}
	
	public Alien getalien(int id) throws SQLException {

        Statement st=con.createStatement();
      ResultSet rs=st.executeQuery("select * from Alien where id"+id);
      Alien a=new Alien();
      if(rs.next()) {
         a.setAid(rs.getInt(1));
  	   a.setAname(rs.getString(2));
  	  a.setAtech(rs.getString(3));  
      }
		return a;		
	}
      public Alien createAlien(Alien a1) throws SQLException {
    	  PreparedStatement pt=con.prepareStatement("insert into alien values(?,?,?");
    	  pt.setInt(1,a1.getAid());
    	  pt.setString(2, a1.getAname());
    	  pt.setString(3,a1.getAtech());
    	  pt.executeUpdate();
		return a1;
    	  
      }
      public void deleteAlien(int id) throws SQLException {
    	  PreparedStatement pt=con.prepareStatement("Delete alien where id=?");
    	  pt.setInt(1, id);
		
    	  
      }
	
	
	/** this is just dummy repostiory or data base 
	List<Alien> aliens;
	public AlienRepository()	{
		aliens=new ArrayList();
			Alien a=new Alien();
			a.setAid(101);
			a.setAname("prakash");
			a.setAtech("java");
			Alien a1=new Alien();
			a.setAid(102);
			a.setAname("siva");
			a.setAtech("c++");
			aliens.add(a);
			aliens.add(a1);		
	 }
	public List<Alien> getAliens(){
		return aliens;
	}
	public Alien getAlien(int id){
		for(Alien a:aliens){
			if(a.getAid()==id){
				return a;
			}}
		return null;
	}
	public Alien creatalien(Alien a1) {
		aliens.add(a1);
		return null;
	}
	*/

}
