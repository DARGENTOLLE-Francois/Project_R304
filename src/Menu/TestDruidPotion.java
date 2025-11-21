package Menu;

// test réalisé par IA

import Character.Druid;
import Food.Food;
import Potion.MagicPotion;

import java.util.ArrayList;
import java.util.List;

public class TestDruidPotion {

    public static void main(String[] args) {
        System.out.println("=== VILLAGE GAULOIS : TEST DE POTION ===\n");

        Druid panoramix = new Druid(
                "Panoramix", "Homme", "1.80m", 90, // Nom, Sexe, Taille, Age
                10, 50, 100, 0, 0, // Force, Endu, Vie, Faim, Belligerance
                10 // Niveau de potion
        );
        
        System.out.println("Le druide " + panoramix.getName() + " est prêt à cuisiner.");
        System.out.println("------------------------------------------------");

        // =================================================================
        // SCÉNARIO 1 : La Potion Magique Classique (Succès)
        // =================================================================
        System.out.println("SCÉNARIO 1 : Tentative de potion classique...");

        List<Food> recipeSuccess = new ArrayList<>();
        recipeSuccess.add(Food.MISTLETOE);
        recipeSuccess.add(Food.CARROTS);
        recipeSuccess.add(Food.SALT);
        recipeSuccess.add(Food.FOURLEAF_CLOVER);
        recipeSuccess.add(Food.FAIRLY_FRESH_FISH); // Important !
        recipeSuccess.add(Food.HONEY);
        recipeSuccess.add(Food.MEAD);
        recipeSuccess.add(Food.SECRET_INGREDIENT);
        recipeSuccess.add(Food.ROCK_OIL); // L'ingrédient liant

        // Le druide prépare la potion
        MagicPotion potion1 = panoramix.MakePotion(recipeSuccess);

        // Analyse du résultat
        analyzeResult(potion1);


        // =================================================================
        // SCÉNARIO 2 : Erreur d'ingrédient (Vin au lieu d'Hydromel)
        // =================================================================
        System.out.println("SCÉNARIO 2 : Le druide est distrait (Vin au lieu d'Hydromel)...");

        List<Food> recipeFail = new ArrayList<>();
        recipeFail.add(Food.MISTLETOE);
        recipeFail.add(Food.CARROTS);
        recipeFail.add(Food.SALT);
        recipeFail.add(Food.FOURLEAF_CLOVER);
        recipeFail.add(Food.FAIRLY_FRESH_FISH);
        recipeFail.add(Food.HONEY);
        recipeFail.add(Food.WINE);             // << ERREUR ICI (Vin)
        recipeFail.add(Food.SECRET_INGREDIENT);
        recipeFail.add(Food.ROCK_OIL);

        MagicPotion potion2 = panoramix.MakePotion(recipeFail);
        analyzeResult(potion2);


        // =================================================================
        // SCÉNARIO 3 : Potion Spéciale (Vitesse + Goût Fraise)
        // =================================================================
        System.out.println("SCÉNARIO 3 : Potion améliorée (Vitesse + Fraise)...");

        List<Food> recipeSpecial = new ArrayList<>(recipeSuccess); // On reprend la base valide
        recipeSpecial.add(Food.MILK_FROM_A_TWOHEADED_UNICORN); // Ajout effet vitesse
        recipeSpecial.add(Food.STRAWBERRY);                    // Ajout goût

        MagicPotion potion3 = panoramix.MakePotion(recipeSpecial);
        analyzeResult(potion3);
    }

    // Méthode utilitaire pour afficher proprement les propriétés de la potion créée
    public static void analyzeResult(MagicPotion potion) {
        if (potion == null) {
            System.out.println("⚠️ Le druide n'a pas pu cuisiner (pas d'ingrédients ou flemme).");
            return;
        }

        System.out.println("--> Résultat de la marmite :");
        if (potion.isValid()) {
            System.out.println("   ✅ POTION RÉUSSIE !");
            System.out.println("   - Doses disponibles : " + potion.getDoses());
            System.out.println("   - Nourrissante : " + (potion.isNourishing() ? "OUI" : "NON"));
            System.out.println("   - Super Vitesse : " + (potion.givesSuperSpeed() ? "OUI" : "NON"));
            System.out.println("   - Lycanthropie  : " + (potion.causesLycanthropy() ? "OUI" : "NON"));
        } else {
            System.out.println("   ❌ POTION RATÉE (C'est de la soupe au goût bizarre).");
        }
        System.out.println("------------------------------------------------\n");
    }
}