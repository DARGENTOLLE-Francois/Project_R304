package model.map;

import java.util.ArrayList;

import model.place.Place;

public class PlaceData {
	private Place place;
	private Integer id;
	private ArrayList<Integer> links;

	public PlaceData(Place place, Integer id, ArrayList<Integer> links) {
		this.place = place;
		this.id = id;
		this.links = links;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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