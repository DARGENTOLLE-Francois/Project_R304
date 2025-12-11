package game;

import includes.exception.ExceptionValidationField;

/**
 * Main class of the program. Starts the game.
 * 
 * @author      Alexandre Benhafessa
 * @author      François Dargentolle
 * @author      William Edelstein 
 * @author      Nathan Griguer
 */
public class Main {
	/** 
	 * The Main function.
	 * Creates a game and starts it.
	 *
	 * @return             void
	 */
    public static void main(String[] args) throws ExceptionValidationField {
        Game game = new Game();
        game.start();          
    }
}