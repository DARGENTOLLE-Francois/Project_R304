package model.InvasionTheatre;

import java.util.ArrayList;
import java.util.Random;

import model.character.Character;
import model.food.Food;
import model.food.FreshnessLevel;
import model.map.PlaceData;
import model.map.mapModel;
import model.place.Battlefield;
import model.place.Place;
import model.player.ClanChiefModel;

public class InvasionTheatreModel {
	private String name;
    private Integer maxNumberOfPlaces;
	private ArrayList<ClanChiefModel> chiefs;
	private Random random;
	
	private mapModel map;
	
	
	public InvasionTheatreModel(String name,Integer maxNumberOfPlaces, ArrayList<ClanChiefModel> chiefs) {
		this.name = name;
		this.maxNumberOfPlaces=maxNumberOfPlaces;
		this.chiefs = chiefs;
		this.random= new Random();
		this.map = mapModel.getInstance();
	}
	
    public String getName() {
        return name;
    }
    
    public mapModel getMap() {
    	return this.map;
    }

    public Integer getMaxNumberOfPlaces() {
        return maxNumberOfPlaces;
    }

    public ArrayList<PlaceData> getPlaces() {
        return this.map.getThePlaces();
    }

    public ArrayList<String> getPlaceNames() {
        ArrayList<String> names = new ArrayList<>();
        for (PlaceData place : this.map.getThePlaces()) {
            names.add(place.getThePlace().getName() + " (" + place.getClass().getSimpleName() + ")");
        }
        return names;
    }

    
    
    public ArrayList<String> getAllCharactersInfo() {
        ArrayList<String> infos = new ArrayList<>();
        
        for (PlaceData place : map.getThePlaces()) {
            infos.add("=== " + place.getThePlace().getName() + " ===");
            
            if (place.getThePlace().getPeople().isEmpty()) {
                infos.add("  (Aucun personnage)");
            } else {
                for (Character character : place.getThePlace().getPeople()) {
                    infos.add("  - " + character.getName() + 
                             " (" + character.getClass().getSimpleName() + ")" +
                             " | Santé: " + character.getHealth() +
                             " | Faim: " + character.getHunger() +
                             " | Potion: " + character.getLevelOfPotion());
                }
            }
            infos.add("");
        }
        
        return infos;
    }
    
    public ArrayList<ClanChiefModel> getClanChiefs() {
        return chiefs;
    }

    
    public Integer getNumberClanChiefs() {
    	return chiefs.size();
    }
	
	
	// print all places in the theatre
	public String displayPlaces () {
		return this.map.getThePlaces().toString();
	}

    public int getTotalNumberOfCharacters() {
        int total = 0;
        for (PlaceData place : map.getThePlaces()) {
            total += place.getThePlace().getPeople().size();
        }
        return total;
    }
	
	
    
    public void fightBelligerents() {
        for (PlaceData place : map.getThePlaces()) {
        	if (place.getThePlace() instanceof Battlefield) {
        		//TODO
        	}
        }
    }

	public void alterCharacRandomly() {
		//Modify hunger by the value of randint
        for (PlaceData place : map.getThePlaces()) {
            for (Character character : place.getThePlace().getPeople()) {
                if (!character.isPetrified()) {
                    int hungerChange = random.nextInt(3);
                    int potionChange = random.nextInt(2);
                    
                    character.modifyHunger(hungerChange);
                    character.modifyLevelOfPotion(-potionChange);
                }
            }
        }
	}
	
	
	// Add boar and fairly fresh fish to all places except battlefield
    public void spawnFood() {
        for (PlaceData place : map.getThePlaces()) {
            // Ne pas spawner sur les champs de bataille
            if (!(place.getThePlace() instanceof Battlefield)) {
                place.getThePlace().getFood().add(Food.BOAR);
                place.getThePlace().getFood().add(Food.FAIRLY_FRESH_FISH);
            }
        }
    }
	
	
    public void decreaseFoodFreshness() {
        for (PlaceData place : map.getThePlaces()) {
            for (Food food : place.getThePlace().getFood()) {
                FreshnessLevel currentFreshness = food.getFreshnessLevel();
                
                switch (currentFreshness) {
                    case FRESH:
                        food.setFreshnessLevel(FreshnessLevel.FAIRLY_FRESH);
                        break;
                    case FAIRLY_FRESH:
                        food.setFreshnessLevel(FreshnessLevel.STALE);
                        break;
                    case STALE:
                    case NONE:
                        break;
                }
            }
        }
    }
    
    
    public boolean checkBattleFieldIsPresent() {
    	for (PlaceData place : map.getThePlaces()) {
    		if (place.getThePlace() instanceof Battlefield) {
    			return true;
    		}
    	}
		return false;
    	
    }
    
/*
    public boolean canAddPlace() {
        return places.size() < maxNumberOfPlaces;
    }

    public boolean addPlace(Place place) {
        if (canAddPlace()) {
            places.add(place);
            return true;
        }
        return false;
    }
*/
    

	public ClanChiefModel getClanChief(int currentChiefIndex) {
		return this.chiefs.get(currentChiefIndex);
	}


	public ArrayList<Place> getTransferDestinations() {
	    ArrayList<Place> destinations = new ArrayList<>();
	    for (PlaceData place : map.getThePlaces()) {
	        if (place.getThePlace() instanceof Battlefield || place.getThePlace().getClass().getSimpleName().equals("Enclos")) {
	            destinations.add(place.getThePlace());
	        }
	    }
	    return destinations;
	}

}
