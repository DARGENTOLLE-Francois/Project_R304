package view.character;

import model.character.Blacksmith;

public class BlacksmithView {
	public void showBlacksmith(Blacksmith b) {
        System.out.println("==== " + b.getName() + " - Blacksmith ====");
        System.out.println("Name - " + b.getName());
        System.out.println("Sexe - " + b.getSexe());
        System.out.println("Height - " + b.getHeight());
        System.out.println("Age - " + b.getAge());
        System.out.println("Strength - " + b.getStrength());
        System.out.println("Stamina - " + b.getStamina());
        System.out.println("Health - " + b.getHealth());
        System.out.println("Hunger - " + b.getHunger());
        System.out.println("Belligerence - " + b.getBelligerence());
        System.out.println("Level of Potion - " + b.getLevelOfPotion());
        System.out.println("======================================");
    }

}
