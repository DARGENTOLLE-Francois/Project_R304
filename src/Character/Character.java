package Character;

import java.util.ArrayList;
import Food.Food;
import Food.NutritionalValue;
import Potion.MagicPotion;
import Place.Place;

public abstract class Character {
    
    protected String name;
    protected String sexe;
    protected double height;
    protected Integer age;
    protected Integer strength;
    protected Integer stamina;
    protected Integer health;
    protected Integer hunger;
    protected Integer belligerence;
    protected Integer levelOfPotion;

    protected boolean isInvincible = false;
    protected boolean isPetrified = false;
    protected boolean isLycanthrope = false;
    protected boolean hasSuperSpeed = false;
    protected int dosesConsumed = 0;

    protected Place originPlace; 

    public Character(String name, String sexe, double height, Integer age, Integer strength, Integer stamina,
            Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
        this.name = name;
        this.sexe = sexe;
        this.height = height;
        this.age = age;
        this.strength = strength;
        this.stamina = stamina;
        this.health = health;
        this.hunger = hunger;
        this.belligerence = belligerence;
        this.levelOfPotion = levelOfPotion;
    }

    // LES COMBATS OUAIIIII
    
    public void seBattre(Character adversaire) {
        // Une statue ou un mort donc cheh
        if (this.isPetrified || !this.estVivant()) return;

        System.out.println(this.name + " attaque " + adversaire.getName() + " !");

        // Calcul des dégâts : Ma Force - Son Endurance => A revoir
        int degatsInfliges = Math.max(0, this.strength - adversaire.getStamina());
        
        // Calcul de la riposte : Sa Force - Mon Endurance
        int degatsRecus = Math.max(0, adversaire.getStrength() - this.stamina);

        adversaire.recevoirCoups(degatsInfliges);

        if (!this.isInvincible) {
            this.recevoirCoups(degatsRecus);
        } else {
            System.out.println(this.name + " est invincible et ignore la riposte !");
        }
    }

    public void recevoirCoups(int degats) {
        if (this.isInvincible) {
            System.out.println(this.name + " ne sent rien (Invincible) !");
            return;
        }

        this.health -= degats;
        System.out.println(this.name + " prend " + degats + " dégâts. (Santé: " + this.health + ")");

        if (this.health <= 0) {
            this.trepasser(); // 
        }
    }

    public void trepasser() {
        this.health = 0;
        System.out.println("☠️ " + this.name + " a trépassé !");
    }

    // "camp de base" pour quand renvoie
    public void setOriginPlace(Place place) {
        this.originPlace = place;
    }

    public Place getOriginPlace() {
        return originPlace;
    }

    public void returnToCamp() {
        if (this.originPlace != null && this.estVivant()) {
            // On suppose que la classe Place a une méthode pour ajouter un personnage
            if (!this.originPlace.getPeople().contains(this)) { //on évite le doublement tah naruto
                this.originPlace.getPeople().add(this);
            }
            System.out.println("🏠 " + this.name + " retourne à " + this.originPlace.getName());
        }
    }

    public void eat(Food food) {
        if (this.isPetrified) return;

        System.out.println(this.name + " mange " + food.getName());

        // 
        if (food.getNutritionalValue() == NutritionalValue.BAD) { // ca sent le caca liquide
            this.health -= 5;
            System.out.println("🤢 Beurk ! C'était avarié (Santé -5)");
        }
        
        // Réduction de la faim => a changer plus tard
        switch (food.getNutritionalValue()) {
            case GOOD -> this.hunger = Math.max(0, this.hunger - 20);
            case MID -> this.hunger = Math.max(0, this.hunger - 10);
            case BAD -> this.hunger = Math.max(0, this.hunger - 5);
        }
    }

    public void modifyHunger(Integer val) {
        // Si on a pas faim, on mange pas gros gourmand
        this.hunger += val;
        if (this.hunger < 0) this.hunger = 0;
    }


    public void drinkMagicPotion(MagicPotion potion) {
        if (this.isPetrified) {
            System.out.println("Une statue ne peut pas boire !");
            return;
        }

        if (potion != null && potion.takeDose()) {
            if (potion.isValid()) {
                System.out.println("Glu et glou ! " + this.name + " boit de la potion.");
                
                this.levelOfPotion++;
                this.dosesConsumed++;
                this.strength += 50; // Force surhumaine temporaire
                this.isInvincible = true;

                // Effets spéciaux ingrédients 
                if (potion.givesSuperSpeed()) this.hasSuperSpeed = true;
                if (potion.causesLycanthropy()) this.isLycanthrope = true;
                if (potion.isNourishing()) this.hunger = Math.max(0, this.hunger - 20);

                // Effets cumulés (Marmites) 
                if (this.dosesConsumed >= 10) { // a changer => 10 doses = 2 marmites
                    this.isPetrified = true;
                    this.strength = 0; 
                    this.isInvincible = false;
                    System.out.println(this.name + " se transforme en statue de granit !");
                }
            }
        } else {
            System.out.println("Il n'y a plus de potion !");
        }
    }


    public void heal() { // 
        if (!this.isPetrified && this.estVivant()) {
            this.health += 10;
            System.out.println(this.name + " se soigne.");
        }
    }

    // --- Getters et Setters

    public boolean estVivant() {
        return this.health > 0;
    }
    
    // Modification belligérance (pour alterCharacRandomly)
    public void modifyBelligerence(Integer val) {
        this.belligerence += val;
    }
    
    // Modification niveau potion (baisse avec le temps) penser a le faire avec des threads
    public void modifyLevelOfPotion(Integer val) {
        this.levelOfPotion += val;
        if (this.levelOfPotion <= 0) {
            this.levelOfPotion = 0;
            // Plus de potion, plus de bonus
            if (this.isInvincible && !this.isPetrified) {
                this.isInvincible = false;
                this.strength -= 50; // On retire le bonus de force
                System.out.println("Les effets de la potion se dissipent pour " + this.name);
            }
        }
    }

    // Getters standards
    public String getName() { return name; }
    public Integer getStrength() { return strength; }
    public Integer getStamina() { return stamina; }
    public Integer getHealth() { return health; }
    public Integer getHunger() { return hunger; }
    
    // j'ai pas eu l'idée de la surcharge c l'ia
    @Override
    public String toString() {
        return name + " (" + this.getClass().getSimpleName() + ") [Santé:" + health + ", Force:" + strength + "]";
    }
}