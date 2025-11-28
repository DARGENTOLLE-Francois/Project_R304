package InvasionTheatre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import Place.Battlefield;
import Place.Place;
import Player.ClanChief;
import Food.Food;
import Food.FreshnessLevel;
import Character.Character;
import Character.Gallic;
import Character.Roman;

public class InvasionTheatre {
    private String name;
    private static final Integer numberOfPlaces = 10;
    private ArrayList<Place> places;
    private ArrayList<ClanChief> chiefs;
    private Scanner scanner;
    
    public InvasionTheatre(String name, ArrayList<Place> places, ArrayList<ClanChief> chiefs) {
        this.name = name;
        this.places = places;
        this.chiefs = chiefs;
        this.scanner = new Scanner(System.in);
    }
    
    // Afficher les lieux
    public String displayPlaces() {
        return this.places.toString();
    }
    
    public Integer displayNumberCharacter() {
        int total = 0;
        Iterator<Place> it = this.places.iterator();
        while(it.hasNext()) {
            Place p = it.next();
            total += p.getPeople().size();
        }
        System.out.println("Population totale du théâtre : " + total);
        return total;
    }
    
    public void displayAllCharacters() {
        for(Place p : this.places) {
            System.out.println("Lieu : " + p.getName() + " -> " + p.getPeople());
        }
    }
    
    // j'imagine dans les champs de bataille avec des camp opposés + retour origine
    public void fightBelligerents() {
        System.out.println(">>> Phase de combat !");
        
        for (Place currentPlace : this.places) {
            if (currentPlace instanceof Battlefield) {
                
                ArrayList<Gallic> GallicCamp = new ArrayList<>();
                ArrayList<Roman> RomanCamp = new ArrayList<>();
                
                // Séparation des combattants présents
                for(Character c : currentPlace.getPeople()) {
                    if(c instanceof Gallic && c.estVivant()) GallicCamp.add((Gallic)c);
                    else if(c instanceof Roman && c.estVivant()) RomanCamp.add((Roman)c);
                }
                
                Random rand = new Random();
                
                // Tant qu'il y a gens des 2 cotés
                while(!GallicCamp.isEmpty() && !RomanCamp.isEmpty()) {
                    Gallic g = GallicCamp.remove(rand.nextInt(GallicCamp.size()));
                    Roman r = RomanCamp.remove(rand.nextInt(RomanCamp.size()));
                    
                    // j'ai fait la fonction dans seBattre (faire la dif entre bataille de belligerent et bagarre de con)
                    g.seBattre(r);
                    
                    // Gestion du retour au camp pour les survivants 
                    if(g.estVivant()) {
                        currentPlace.getPeople().remove(g);
                        g.returnToCamp(); // retours au village
                    } else {
                        currentPlace.getPeople().remove(g);
                    }
                    
                    if(r.estVivant()) {
                        currentPlace.getPeople().remove(r); // retours au village
                        r.returnToCamp();
                    } else {
                        currentPlace.getPeople().remove(r);
                    }
                }
            }
        }
    }
    
    // Modifier aléatoirement l'état
    public void alterCharacRandomly() {
        System.out.println("Modifications Aléatoires des personnages...");
        Random rand = new Random();

        for (int i=0; i<this.places.size(); ++i) {
            Place currentPlace = this.places.get(i);
            Iterator<Character> it = currentPlace.getPeople().iterator();
            
            while (it.hasNext()) {
                Character currentChar = it.next();
                
                if(rand.nextInt(3) == 0) {
                    int randint = rand.nextInt(3); // 0, 1 ou 2
                    currentChar.modifyHunger(randint);         // Donner faim
                    currentChar.modifyLevelOfPotion(-randint); // Baisser potion
                }
            }
        }
    }
    
    // Apparition d'aliments sauf champ de batailles
    public void spawnFood() {
    	System.out.println("DEBUG: Lancement de spawnFood..."); // TEST 1
        System.out.println("Apparition d'aliments...");
        Iterator<Place> it = this.places.iterator();
        while(it.hasNext()) {
            Place currentPlace = it.next();
            if (!(currentPlace instanceof Battlefield)) {
                currentPlace.getListFood().add(Food.BOAR);
                currentPlace.getListFood().add(Food.FAIRLY_FRESH_FISH);
            }
        }
    }
    
    // Changer frais en pas frais
    public void decreaseFreshness() {
        for (int i=0; i<this.places.size(); ++i) {
            Place currentPlace = this.places.get(i);
            Iterator<Food> it = currentPlace.getListFood().iterator();
            
            System.out.println("Changement fraicheur sur : " + currentPlace.getName());
            while (it.hasNext()) {
                Food currentFood = it.next();
                FreshnessLevel currentFreshness = currentFood.getFreshnessLevel();
                
                switch(currentFreshness) {
                case FRESH:
                    currentFood.setFreshnessLevel(FreshnessLevel.FAIRLY_FRESH);
                    break;
                case FAIRLY_FRESH:
                    currentFood.setFreshnessLevel(FreshnessLevel.STALE); // Pas frais
                    break;
                default:
                    break;
                }
            }
        }
    }

    // au chef de jouer ^^
    public void execClanChief(int turn) {
        if (turn >= chiefs.size()) turn = 0;

        int maxActions = 3; // a check si jamais
        int choice;
        
        ClanChief currentChief = chiefs.get(turn);
        
        System.out.println("\n--- Tour du Chef : " + currentChief.getName() + " ---");
        
        for (int i=0; i<maxActions; ++i) {
            System.out.println("Actions restantes : "+ (maxActions-i));
            System.out.println(
                    "1 : Examiner son lieu"
                    +"\n"+
                    "2 : Créer un nouveau personnage"
                    +"\n"+
                    "3 : Soigner les personnages"
                    +"\n"+
                    "4 : Nourrir les personnages"
                    +"\n"+
                    "5 : Transférer vers Champ de Bataille"
                    +"\n"+
                    "0 : Passer son tour"
                    );
            System.out.print("Choix : ");
            
            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                case 1:
                    currentChief.examinatePlace();
                    break;
                case 2:
                    currentChief.createACharacter();
                    break;
                case 3:
                    currentChief.HealTheirCharacter();
                    break;
                case 4:
                    currentChief.CharacterWillEat();
                    break;
                case 5:
                    System.out.println("Envoi de troupes au front !");
                    
                    Place champDeBataille = null;
                    for (Place p : this.places) {
                        if (p instanceof Battlefield) {
                            champDeBataille = p;
                            break;
                        }
                    }
                    
                    if (champDeBataille != null) {
                        currentChief.transferCharacter(champDeBataille);
                    } else {
                        System.out.println("Erreur : Aucun champ de bataille trouvé dans le théâtre !");
                    }
                    break;
                case 0:
                    i = maxActions;
                    break;
                default:
                    System.out.println("Choix incorrect");
                    i--; // On est sympa, on compte pas cette grossière erreur ^^
                }
            } else {
                scanner.next(); // honnetement ia cette ligne
                i--;
            }
        }
    }
    
    public ArrayList<ClanChief> getChiefs(){
        return this.chiefs;
    }
}