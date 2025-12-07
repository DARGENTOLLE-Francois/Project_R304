package model.InvasionTheatre;

import java.util.ArrayList;
import java.util.Random;

import model.character.Character;
import model.food.Food;
import model.food.FreshnessLevel;
import model.place.Battlefield;
import model.place.Place;
import model.player.ClanChiefModel;

public class InvasionTheatreModel {
	private String name;
    private Integer maxNumberOfPlaces;
	private ArrayList<Place> places;
	private ArrayList<ClanChiefModel> chiefs;
	private Random random;
	
	
	public InvasionTheatreModel(String name,Integer maxNumberOfPlaces, ArrayList<Place> places, ArrayList<ClanChiefModel> chiefs) {
		this.name = name;
		this.maxNumberOfPlaces=maxNumberOfPlaces;
		this.places = places;
		this.chiefs = chiefs;
		this.random= new Random();
	}
	
	
    public String getName() {
        return name;
    }

    public Integer getMaxNumberOfPlaces() {
        return maxNumberOfPlaces;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public ArrayList<String> getPlaceNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Place place : places) {
            names.add(place.getName() + " (" + place.getClass().getSimpleName() + ")");
        }
        return names;
    }

    
    
    public ArrayList<String> getAllCharactersInfo() {
        ArrayList<String> infos = new ArrayList<>();
        
        for (Place place : places) {
            infos.add("=== " + place.getName() + " ===");
            
            if (place.getPeople().isEmpty()) {
                infos.add("  (Aucun personnage)");
            } else {
                for (Character character : place.getPeople()) {
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
		return this.places.toString();
	}

    public int getTotalNumberOfCharacters() {
        int total = 0;
        for (Place place : places) {
            total += place.getPeople().size();
        }
        return total;
    }
	
    
    private ArrayList<Battlefield> getBattlefields() {
        ArrayList<Battlefield> battlefields = new ArrayList<>();
        for (Place place : places) {
            if (place instanceof Battlefield) {
                battlefields.add((Battlefield) place);
            }
        }
        return battlefields;
    }
	
    // Battlefield is valid if present in InvasionTheatre
    public boolean isBattlefieldPresent() {
        return !getBattlefields().isEmpty();
    }
    
    
    public void fightBelligerents() {
    	for (Battlefield b : getBattlefields()) {
    		if (b.canFight()) {
    			ArrayList<Character> gallicPeople = b.getGallic();
    			ArrayList<Character> romanPeople = b.getRoman();
    			
    			//Ajouter vérif effet de bord listes romanPeople et gallicPeople
    			Character gallicFighter = gallicPeople.get(0);
    			Character romanFighter = romanPeople.get(0);
    			
    			gallicFighter.strike(romanFighter);
    			romanFighter.strike(gallicFighter);
    			
    			//Renvoyer vers endroit d'origine
    			romanPeople.remove(romanFighter);
    			if (!romanFighter.passAway()) {
    				romanFighter.setCurrentPlace(romanFighter.getPlaceOfOrigin());
    			}
    			
    			gallicPeople.remove(gallicFighter);
    			if (!gallicFighter.passAway()) {
    				gallicPeople.remove(gallicFighter);
    				gallicFighter.setCurrentPlace(gallicFighter.getPlaceOfOrigin());	
    			}
    		}
    	}
    }

	public void alterCharacRandomly() {
		//Modify hunger by the value of randint
        for (Place place : places) {
            for (Character character : place.getPeople()) {
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
        for (Place place : places) {
            // Ne pas spawner sur les champs de bataille
            if (!(place instanceof Battlefield)) {
                place.getFood().add(Food.BOAR);
                place.getFood().add(Food.FAIRLY_FRESH_FISH);
            }
        }
    }
	
	
    public void decreaseFoodFreshness() {
        for (Place place : places) {
            for (Food food : place.getFood()) {
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

    

	public ClanChiefModel getClanChief(int currentChiefIndex) {
		return this.chiefs.get(currentChiefIndex);
	}


	public ArrayList<Place> getTransferDestinations() {
	    ArrayList<Place> destinations = new ArrayList<>();
	    for (Place place : places) {
	        if (place instanceof Battlefield || place.getClass().getSimpleName().equals("Enclos")) {
	            destinations.add(place);
	        }
	    }
	    return destinations;
	}

}
