package Project6;

import java.util.*;

public class Town implements Comparable<Town>{
	private String name;
	private Town templateTown;
	
	
	
	/**
	 * Constructor. Requires town's name
	 * @param Name
	 */
	public Town(String name){
		this.name = name;
		this.templateTown = templateTown;
	   }
	  
	/**
	 * get template town
	 * @return
	 */
	public Town getTemplateTown() {
		return templateTown;
	}

	/**
	 * set template town
	 * @param templateTown
	 */
	public void setTemplateTown(Town templateTown) {
		this.templateTown = templateTown;
	}


	/**
	 * Return the town's name
	 * @return town's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set town's name 
	 * @param name town's name
	 */
	public void setName(String name) {
		this.name = name;
		
	}

	/**
	 *copy constructor
	 * @param templateTown an instance of Town
	 */
	public Town(Town templateTown){
	    this.setTemplateTown(templateTown);
	   }
	
	/**
	 * Compare to method
	 * @return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	public int compareTo(Town o){
		return name.compareTo(o.name);
	  
	   }

	/**
	 * to string method
	 * @return the town name
	 */
	public String toString()
	{
	       return "Town:" + name;
	   }

	/**
	 * @return the hashcode for the name of the town
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
		   
	 }
	   
	/**
	 *@return true if the town names are equal, false if not  
	 */
	@Override
	public boolean equals(Object obj) {
		Town town = (Town) obj;
        return this.name.compareTo(town.name) == 0;
		   
	}}



	