package model.InvasionTheatre;

import java.util.ArrayList;
import java.util.Random;

import model.character.Character;
import model.food.Food;
import model.food.FreshnessLevel;
import model.place.Battlefield;
import model.place.Place;
import model.player.ClanChiefModel;

/**
* The model class for the InvasionTheater object.
* Contains the properties relative to the current game and methods related to it or to a group of object like fightBelligerents().
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class InvasionTheatreModel {
	/**
	* The name of the invasion theatre.
	*/
	private String name;
	/**
	* The maxNumberOfPlaces of the invasion theatre.
	*/
    private Integer maxNumberOfPlaces;
    /**
	* The places of the invasion theatre.
	*/
	private ArrayList<Place> places;
	/**
	* The chiefs of the invasion theatre.
	*/
	private ArrayList<ClanChiefModel> chiefs;
	/**
	* A random value to be initiated.
	*/
	private Random random;
	
	/** 
     * Creates an instance with the given parameters.
     *
     *
     * @param name		    	The name of the invasion theatre
     * @param maxNumberOfPlaces The maxNumberOfPlaces of the invasion theatre
     * @param places	    	The places of the invasion theatre
     * @param chiefs		    The chiefs of the invasion theatre
     * 
     * @return             The newly created object
     */
	public InvasionTheatreModel(String name,Integer maxNumberOfPlaces, ArrayList<Place> places, ArrayList<ClanChiefModel> chiefs) {
		this.name = name;
		this.maxNumberOfPlaces=maxNumberOfPlaces;
		this.places = places;
		this.chiefs = chiefs;
		this.random= new Random();
	}
	
	/**
	* Returns the name of the invasion theatre.
	* 
	* @return the name of the invasion theatre.
	*/
    public String getName() {
        return name;
    }
    
    /**
	* Returns the maxNumberOfPlaces of the invasion theatre.
	* 
	* @return the maxNumberOfPlaces of the invasion theatre.
	*/
    public Integer getMaxNumberOfPlaces() {
        return maxNumberOfPlaces;
    }

    /**
	* Returns the places of the invasion theatre.
	* 
	* @return the places of the invasion theatre.
	*/
    public ArrayList<Place> getPlaces() {
        return places;
    }

    /**
	* Returns the places names of the invasion theatre.
	* 
	* @return the places names of the invasion theatre.
	*/
    public ArrayList<String> getPlaceNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Place place : places) {
            names.add(place.getName() + " (" + place.getClass().getSimpleName() + ")");
        }
        return names;
    }

    /**
	* Returns the characters info of the invasion theatre.
	* 
	* @return the characters info of the invasion theatre.
	*/
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
    
    /**
	* Returns the chiefs of the invasion theatre.
	* 
	* @return the chiefs of the invasion theatre.
	*/
    public ArrayList<ClanChiefModel> getClanChiefs() {
        return chiefs;
    }

    /**
	* Returns the number of clan chiefs of the invasion theatre.
	* 
	* @return the number of clan chiefs of the invasion theatre.
	*/
    public Integer getNumberClanChiefs() {
    	return chiefs.size();
    }
	
	
    /**
	* Returns as a string all the places of the theatre.
	* To be used in the view.
	* 
	* @return String the places within the theatre.
	*/
	public String displayPlaces () {
		return this.places.toString();
	}

	/**
	* Returns the total number of characters of the invasion theatre.
	* 
	* @return the total number of characters of the invasion theatre.
	*/
    public int getTotalNumberOfCharacters() {
        int total = 0;
        for (Place place : places) {
            total += place.getPeople().size();
        }
        return total;
    }
	
    /**
	* Returns the battlefields of the invasion theatre.
	* 
	* @return the battlefields of the invasion theatre
	*/
    private ArrayList<Battlefield> getBattlefields() {
        ArrayList<Battlefield> battlefields = new ArrayList<>();
        for (Place place : places) {
            if (place instanceof Battlefield) {
                battlefields.add((Battlefield) place);
            }
        }
        return battlefields;
    }
	
    /**
	* Returns a boolean for the presence of a battlefield in the theatre.
	* 
	* @return boolean the presence of a battlefield in the theatre.
	*/
    public boolean isBattlefieldPresent() {
        return !getBattlefields().isEmpty();
    }
    
    /**
	* Triggers a fight between all the belligerents.
	* Will make the gallics and romans on the battlefield fight.
	* The deads will go back to their origin place.
	* 
	* @return rrayList<String> the messages to be displayed about the fight.
	*/
    public ArrayList<String> fightBelligerents() {
        ArrayList<String> combatMessages = new ArrayList<>();
        ArrayList<Battlefield> availableBattlefields = this.getAvailableBattlefields();
        
        for (Battlefield b : availableBattlefields) {
            ArrayList<Character> gallicPeople = b.getGallic();
            ArrayList<Character> romanPeople = b.getRoman();
            
            Character gallicFighter = gallicPeople.get(0);
            Character romanFighter = romanPeople.get(0);
            
            gallicFighter.strike(romanFighter);
            combatMessages.add(gallicFighter.getName()+ " du camps des Gaulois a frappé " + romanFighter.getName()+" du camp des Romains de "+
            gallicFighter.getStrength()*gallicFighter.getStamina()+" points de dégats. PV restants : "+romanFighter.getHealth() );
            
            romanFighter.strike(gallicFighter);
            combatMessages.add(romanFighter.getName() + " du camps des Romains a frappé " + gallicFighter.getName()+" du camps des Gaulois de "+
            romanFighter.getStrength()*romanFighter.getStamina()+" points de dégats. PV restants : "+gallicFighter.getHealth() );
            
            // Return to the original place
            b.removePeople(romanFighter);
            if (!romanFighter.passAway()) {
                combatMessages.add(romanFighter.getName() + " retourne à son lieu d'origine");
                romanFighter.getPlaceOfOrigin().addPeople(romanFighter);
            } else {
                combatMessages.add(romanFighter.getName() + " est mort au combat !");
                romanFighter.setCurrentPlace(null);
            }
            
            b.removePeople(gallicFighter);
            if (!gallicFighter.passAway()) {
                gallicFighter.getPlaceOfOrigin().addPeople(gallicFighter);
                combatMessages.add(gallicFighter.getName() + " retourne à son lieu d'origine");
            } else {
                combatMessages.add(gallicFighter.getName() + " est mort au combat !");
                gallicFighter.setCurrentPlace(null);
            }
        }
        
        return combatMessages;
    }
    
    /**
	* Returns, for all the battlefields in the theatre, all the available ones.
	* 
	* @return ArrayList<Battlefield> the available battlefield.
	*/
    public ArrayList<Battlefield> getAvailableBattlefields() {
    	ArrayList<Battlefield> availableBattlefields = new ArrayList<>();
    	for (Battlefield b : getBattlefields()) {
    		if (b.canFight()) {
    			availableBattlefields.add(b);
    		}
    	}
    	return availableBattlefields;
    }
    
    /**
	* Alters the characters hunger and potion level randomly.
	* 
	* @return void
	*/
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
	
	/**
	* Add boar and fairly fresh fish to all places except battlefield.
	* 
	* @return void
	*/
    public void spawnFood() {
        for (Place place : places) {
            // Ne pas spawner sur les champs de bataille
            if (!(place instanceof Battlefield)) {
                place.getFood().add(Food.BOAR);
                place.getFood().add(Food.FAIRLY_FRESH_FISH);
            }
        }
    }
	
    /**
	* decreases the freshness level of the food in the places.
	* 
	* @return void
	*/
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
    
    /**
	* Returns the possibility of adding a place to the theatre.
	* The method is based on the maxNumberOfPlaces property.
	* 
	* @return boolean is there available space in the theatre
	*/
    public boolean canAddPlace() {
        return places.size() < maxNumberOfPlaces;
    }

    /**
	* Returns the possibility of adding a place to the theatre and adds it to the places array
	* 
	* @return boolean is there available space in the theatre
	*/
    public boolean addPlace(Place place) {
        if (canAddPlace()) {
            places.add(place);
            return true;
        }
        return false;
    }

    /**
	* Returns the currentChiefIndex of the invasion theatre.
	* 
	* @return ClanChiefModel the currentChiefIndex of the invasion theatre.
	*/
	public ClanChiefModel getClanChief(int currentChiefIndex) {
		return this.chiefs.get(currentChiefIndex);
	}

	/**
	* Returns a list of all the transfer destination in the invasion theatre.
	* 
	* @return ArrayList<Place> list of all the transfer destination in the invasion theatre.
	*/
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
