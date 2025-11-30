package game;

import controller.player.ClanChiefController;
import model.player.ClanChief;
import model.place.GallicVillage;
import model.food.Food;
import view.player.ClanChiefView;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private boolean running = true;
    private ClanChiefController controller;

    public Game() {

        // Create one test village
        GallicVillage village = new GallicVillage(
                "Gaul Village",
                1200,
                0,
                new ArrayList<>(),
                new ArrayList<>()
        );

        // Add some food
        village.getFood().add(Food.BOAR);
        village.getFood().add(Food.MEAD);

        // Create the player
        ClanChief player = new ClanChief("Asterix", "M", 35, village);

        // MVC wiring
        ClanChiefView view = new ClanChiefView();
        controller = new ClanChiefController(player, view);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Examine the place");
            System.out.println("2. Create a character");
            System.out.println("3. Heal all characters");
            System.out.println("4. Make characters eat");
            System.out.println("5. Quit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    controller.examinePlace();
                    break;
                case 2:
                    controller.createCharacter();
                    break;
                case 3:
                    controller.healAllCharacters();
                    break;
                case 4:
                    controller.charactersEat();
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
