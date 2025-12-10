package game;
import controller.lycanthrope.lycanthropeController;

public class Main {

    public static void main(String[] args) {
    	
        lycanthropeController lycanController = new lycanthropeController();
        lycanController.startSimulation(10);
        
        Game game = new Game();
        game.start();          
    }
}