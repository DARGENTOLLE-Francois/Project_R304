package controller.character;

import model.character.Character;
import model.food.Food;
import model.magicpotion.MagicPotion;
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
*  
* @author      Alexandre Benhafessa
* @author      François Dargentolle
* @author      William Edelstein 
* @author      Nathan Griguer
*/
public class CharacterController {
	/** 
     * The character to control.
     */
    private Character character;
    /** 
     * The character view.
     */
    private CharacterView view;
    /** 
     * The scanner ti scan with.
     */
    private Scanner scanner;

    /** 
    * Creates a CharacterController object. will make a relation with it's model and view.
    *  
    * @param character    Character to control.
    * @param view         The view that will show this character's info.
    * @return             the newly created object
    */
    public CharacterController(Character character, CharacterView view) {
        this.character = character;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    /** 
     * Sends the character given in parameters to the view to be shown.
     *  
     * @param character    Character to be shown.
     * @return             void
     */
    public void showCharacter() {
        view.showCharacter(character);
    }

    /** 
     * Attemps to drink a magic potion. Sends the signal to the model and displays the messages that it returns with the view.
     *  
     * @param potion       The potion to drink.
     * @return             void
     */
    public void drinkPotion(MagicPotion potion) {
        List<String> messages = character.drinkMagicPotion(potion); // Model returns messages
        for (String msg : messages) {
            view.showMessage(msg); // View prints them
        }
    }
    
    /** 
     * Attemps to eat food. Sends the signal to the model and displays the messages that it returns with the view.
     *
     * @param potion       The food to eat.
     * @return             void
     */
    public void eatFood(Food food) {
        character.eat(food);
        view.showMessage(character.getName() + " a mangé " + food.getName() + "!");
    }

    /** 
     * Attemps to heal. Sends the signal to the model and displays the messages that it returns with the view.
     *
     * @return             void
     */
    public void heal() {
        character.heal();
        view.showMessage(character.getName() + " s'est soigné!");
    }

    /** 
     * Attemps to modify the hunger level of the character. Sends the signal to the model and displays the messages that it returns with the view.
     *
     * @param potion       The amount of hunger to vary of.
     * @return             void
     */
    public void modifyHunger(int amount) {
        character.modifyHunger(amount);
        view.showMessage("La satiété de "+character.getName() + " a changé: " + amount);
    }
}
