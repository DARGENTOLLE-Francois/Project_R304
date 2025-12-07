package model.map;

import java.util.ArrayList;

import model.place.Place;

/**
* A class to manage the places among an area.
* Contains an id, and a link vector representing the existing paths to another area.
*/
public class PlaceData {
	private Place thePlace;
	private Integer id;
	private ArrayList<Integer> links;

	public PlaceData(Place thePlace, Integer id, ArrayList<Integer> links) {
		this.thePlace = thePlace;
		this.id = id;
		this.links = links;
	}
	
	public Place getThePlace() {
		return this.thePlace;
	}
	
	/**
	* Returns the id of the place.
	*/
	public Integer getId() {
		return this.id;
	} 
	
	/**
	* Sets the id of the place.
	* 
	* @param Integer id the id to be set
	*/
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	* Adds a link to the link vectors.
	* 
	* @param Integer id the id to be set
	*/
	public boolean addLink(Integer link) {
		if (link != this.id) {
			this.links.add(link);
			return true;
		}
		return false;
	}
	
	public boolean removeLink(Integer link) {
		if (this.links.contains(link)){
			this.links.remove(link);
			return true;
		}
		return false;
	}
}