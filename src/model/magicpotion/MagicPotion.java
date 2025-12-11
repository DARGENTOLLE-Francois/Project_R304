package model.magicpotion;

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

    private int doses;
    private final int MAX_DOSES = 5; 

    private boolean isValidRecipe;
    private boolean isNourishing;
    private boolean givesSuperSpeed;
    private boolean causesLycanthropy;

    public MagicPotion(List<Food> ingredients) {
        analyzeMixture(ingredients);
    }

    private void analyzeMixture(List<Food> ingredients) {

        boolean hasBaseIngredients = ingredients.contains(Food.MISTLETOE) &&
                                     ingredients.contains(Food.CARROTS) &&
                                     ingredients.contains(Food.SALT) &&
                                     ingredients.contains(Food.FOURLEAF_CLOVER) &&
                                     ingredients.contains(Food.FAIRLY_FRESH_FISH) &&
                                     ingredients.contains(Food.HONEY) &&
                                     ingredients.contains(Food.MEAD) &&
                                     ingredients.contains(Food.SECRET_INGREDIENT);


        boolean hasBindingAgent = ingredients.contains(Food.ROCK_OIL) ||
                                  ingredients.contains(Food.BEETROOT_JUICE);

        this.isValidRecipe = hasBaseIngredients && hasBindingAgent;
        this.doses=MAX_DOSES;

        if (this.isValidRecipe) {
            this.isNourishing = ingredients.contains(Food.LOBSTER) ||
                               ingredients.contains(Food.STRAWBERRY) ||
                               ingredients.contains(Food.BEETROOT_JUICE);

            this.givesSuperSpeed = ingredients.contains(Food.MILK_FROM_A_TWOHEADED_UNICORN);

            this.causesLycanthropy = ingredients.contains(Food.IDEFIX_HAIR);
        }
    }


    @Override
    public String toString() {
        if (!isValidRecipe) {
            return "Potion invalide - Recette incorrecte";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Dose de potion magique :"+this.getDoses()+" - Effets: ");

        if (isNourishing) {
            sb.append("Nourrissante");
        }
        if (givesSuperSpeed) {
            sb.append("Super-vitesse");
        }
        if (causesLycanthropy) {
            sb.append("Lycanthropie");
        }

        if (!isNourishing && !givesSuperSpeed && !causesLycanthropy) {
            sb.append("Standard (force + invincibilité)");
        }

        return sb.toString();
    }

    public boolean isValid() {
        return isValidRecipe;
    }

    public boolean isNourishing() {
        return isNourishing;
    }

    public boolean givesSuperSpeed() {
        return givesSuperSpeed;
    }

    public boolean causesLycanthropy() {
        return causesLycanthropy;
    }

    public boolean takeDose() {
        if (doses > 0) {
            doses--;
            return true;
        }
        return false;
    }

    public int getDoses() { return doses; }
}