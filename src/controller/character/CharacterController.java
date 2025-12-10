package controller.character;

import model.character.Character;
import model.food.Food;
import model.magicPotion.MagicPotion;
import view.character.CharacterView;

import java.util.List;
import java.util.Scanner;


/**
* The controller class for the Character element.
* Contains all the tool for the operator to use the character objects through the MVC architecture.
* It can:
* - Send character info to the view
* - Send a signal to drink a potion to the model and display it's success
* - Send a signal to eat food to the model and display it's success
* - Send a signal to heal to the model and display it's success
* - Send a signal to modify the hunger level to the model and display it's state
* <p>
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class CharacterController {
    private Character character;
    private CharacterView view;
    private Scanner scanner;

    public CharacterController(Character character, CharacterView view) {
        this.character = character;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    // Display full character info
    public void showCharacter() {
        view.showCharacter(character);
    }

    // Handle drinking a magic potion
    public void drinkPotion(MagicPotion potion) {
        List<String> messages = character.drinkMagicPotion(potion); // Model returns messages
        for (String msg : messages) {
            view.showMessage(msg); // View prints them
        }
    }
    // Handle eating food
    public void eatFood(Food food) {
        character.eat(food);
        view.showMessage(character.getName() + " a mangé " + food.getName() + "!");
    }

    // Handle simple heal
    public void heal() {
        character.heal();
        view.showMessage(character.getName() + " s'est soigné!");
    }

    // Modify hunger (example)
    public void modifyHunger(int amount) {
        character.modifyHunger(amount);
        view.showMessage("La satiété de "+character.getName() + " a changé: " + amount);
    }
}
