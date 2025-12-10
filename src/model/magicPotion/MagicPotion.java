package model.magicPotion;

import java.util.List;

import model.food.Food;


/**
* The model class for the MagicPotion object.
* Contains the properties of the magic potion's game logic.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class MagicPotion {

	/**
	* Amount of doses in the potion.
	*/
    private int doses;
    /**
	* Max amount of doses in the potion.
	*/
    private final int MAX_DOSES = 5; 
    /**
	* Is the potion made of a valid recipe.
	*/
    private boolean isValidRecipe;
    /**
	* Is the potion made out of lobster or strawberries (in addition to the main recipe)
	*/
    private boolean isNourishing;
    /**
	* Is the potion made out of licorn's milk (in addition to the main recipe)
	*/
    private boolean givesSuperSpeed;
    /**
	* Is the potion made out of the dog's fur (in addition to the main recipe)
	*/
    private boolean causesLycanthropy;

    /** 
     * Creates an instance with the given parameters.
     * The ingredients are given by the druid.
     * The analyzeMixture method will also check if some side effects should be added.
     *
     * @param ingredients  The ingredients given by the druid
     * 
     * @return             The newly created object
     */
    public MagicPotion(List<Food> ingredients) {
        this.doses = MAX_DOSES;
        analyzeMixture(ingredients);
    }

    /** 
     * Checks if the main recipe is given and afterward if some side effect should be added.
     *
     * @param ingredients  The ingredients given by the druid
     * 
     * @return             The newly created object
     */
    private void analyzeMixture(List<Food> ingredients) {
        // check if the base recipe is fulfilled 
        boolean hasBaseIngredients = ingredients.contains(Food.MISTLETOE) &&
                                     ingredients.contains(Food.CARROTS) &&
                                     ingredients.contains(Food.SALT) &&
                                     ingredients.contains(Food.FOURLEAF_CLOVER) &&
                                     ingredients.contains(Food.FAIRLY_FRESH_FISH) &&
                                     ingredients.contains(Food.HONEY) &&
                                     ingredients.contains(Food.MEAD) &&
                                     ingredients.contains(Food.SECRET_INGREDIENT);

        // and one of the two substitutes...
        boolean hasOilOrBeetroot = ingredients.contains(Food.ROCK_OIL) || 
                                   ingredients.contains(Food.BEETROOT_JUICE);

        this.isValidRecipe = hasBaseIngredients && hasOilOrBeetroot;

        if (this.isValidRecipe) {
        	
            this.isNourishing = ingredients.contains(Food.LOBSTER) || 
                                ingredients.contains(Food.STRAWBERRY);
            
            this.givesSuperSpeed = ingredients.contains(Food.MILK_FROM_A_TWOHEADED_UNICORN);

            this.causesLycanthropy = ingredients.contains(Food.IDEFIX_HAIR);
        }
    }

    /** 
     * Removes a dose from the potion.
     * 
     * @return             boolean a dose was into the potion.
     */
    public boolean takeDose() {
        if (doses > 0) {
            doses--;
            return true;
        }
        return false;
    }
    
    /**
	* Returns validity of the recipe for the the potion
	* 
	* @return isValidRecipe is the recipe viable
	*/
    public boolean isValid() { return isValidRecipe; }
    /**
	* Returns nourishing-ness of the recipe for the the potion
	* 
	* @return isNourishing is the recipe nourishing
	*/
    public boolean isNourishing() { return isNourishing; }
    /**
	* Returns superspeed-ness of the recipe for the the potion
	* 
	* @return givesSuperSpeed does the potion give super speed
	*/
    public boolean givesSuperSpeed() { return givesSuperSpeed; }
    /**
	* Returns causesLycanthropy-ness of the recipe for the the potion
	* 
	* @return causesLycanthropy does the potion cause lycanthropy
	*/
    public boolean causesLycanthropy() { return causesLycanthropy; }
    /**
	* Returns the amount of doses in the potion
	* 
	* @return doses the amount of doses in the potion
	*/
    public int getDoses() { return doses; }
}