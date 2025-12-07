package view.map;

import java.util.ArrayList;

import model.map.PlaceData;
import model.map.mapModel;

public class mapView {
	public void displayMap(mapModel map){
		ArrayList<PlaceData> data = map.getThePlaces();
		System.out.println(""
				+ "		┌──2──┬──5──┐\n"
				+ "		│     │     │\n"
				+ "	 1 ─────┤     4     ├──7\n"
				+ "		│     │     │\n"
				+ "		└──3──┴──6──┘\n"
				+ "				"
				);
		//for each places, prints the info about them
		for(PlaceData place: data) {
			//"id of the graph, the conqueror of it, the name of the place".
			System.out.println(place.getId()+ ": "+place.getThePlace().getBelongsToName()+ ", "+ place.getThePlace().getName());
		}
				
		
	}
}
