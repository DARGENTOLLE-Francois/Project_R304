package view.character;

import model.character.Character;

/**
* The view class for the Character object .
* Displays informations about the characters given in the constructor.
*
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class CharacterView {
    public void showCharacter(Character c) {
        System.out.println("==== " + c.getName() + " - " + c.getClass().getSimpleName() + " ====");
        System.out.println("Name - " + c.getName());
        System.out.println("Sexe - " + c.getSexe());
        System.out.println("Height - " + c.getHeight());
        System.out.println("Age - " + c.getAge());
        System.out.println("Strength - " + c.getStrength());
        System.out.println("Stamina - " + c.getStamina());
        System.out.println("Health - " + c.getHealth());
        System.out.println("Hunger - " + c.getHunger());
        System.out.println("Belligerence - " + c.getBelligerence());
        System.out.println("Level of Potion - " + c.getLevelOfPotion());

        // Status Effects Section
        boolean hasStatus = c.isInvincible() || 
        		c.isPetrified() || 
        		c.isLycanthrope() || 
        		c.hasSuperSpeed() || 
        		c.getDosesConsumed() > 0;
        if (hasStatus) {
            System.out.println("------ Afflictions ------");
            if (c.isInvincible()) {
                System.out.println("Invincible");
            }
            if (c.isPetrified()) {
                System.out.println("Petrified");
            }
            if (c.isLycanthrope()) {
                System.out.println("Lycanthrope");
            }
            if (c.hasSuperSpeed()) {
                System.out.println("Has Super Speed");
            }
            if (c.getDosesConsumed() > 0) {
                System.out.println("Doses Consumed - " + c.getDosesConsumed());
            }
        }

        System.out.println("======================================");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
