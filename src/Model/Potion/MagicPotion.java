package Model.Potion;

import java.util.List;

import Model.Food.Food;

public class MagicPotion {

    private int doses; // nbr de dose de potion dans une marmitte
    private final int MAX_DOSES = 5; 


    private boolean isValidRecipe;      // recette correct
    private boolean isNourishing;       // Ajout homard ou fraise
    private boolean givesSuperSpeed;    // Lait de licorne
    private boolean causesLycanthropy;  // Poil du chien

    // on pren la liste donner par le druide
    public MagicPotion(List<Food> ingredients) {
        this.doses = MAX_DOSES;
        analyzeMixture(ingredients);
    }

    private void analyzeMixture(List<Food> ingredients) {
        // On check si y a la food de base...
        boolean hasBaseIngredients = ingredients.contains(Food.MISTLETOE) &&
                                     ingredients.contains(Food.CARROTS) &&
                                     ingredients.contains(Food.SALT) &&
                                     ingredients.contains(Food.FOURLEAF_CLOVER) &&
                                     ingredients.contains(Food.FAIRLY_FRESH_FISH) &&
                                     ingredients.contains(Food.HONEY) &&
                                     ingredients.contains(Food.MEAD) &&
                                     ingredients.contains(Food.SECRET_INGREDIENT);

        // et l'un des 2 du subtitue
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

    // boire une dose (jsp si je dois la mettre la ou dans character)
    public boolean takeDose() {
        if (doses > 0) {
            doses--;
            return true;
        }
        return false;
    }

    public boolean isValid() { return isValidRecipe; }
    public boolean isNourishing() { return isNourishing; }
    public boolean givesSuperSpeed() { return givesSuperSpeed; }
    public boolean causesLycanthropy() { return causesLycanthropy; }
    public int getDoses() { return doses; }
}