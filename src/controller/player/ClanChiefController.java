package controller.player;

import model.player.ClanChief;
import model.character.Character;
import view.player.ClanChiefView;

import java.util.Scanner;

public class ClanChiefController {

    private ClanChief clanChief;
    private ClanChiefView view;
    private Scanner scanner;

    public ClanChiefController(ClanChief clanChief, ClanChiefView view) {
        this.clanChief = clanChief;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    // Examine place
    public void examinePlace() {
    	String info = clanChief.getPlace().getSpecifications();
        view.showPlaceInfo(info);
    }

    // Create character
    public Character createCharacter() {
        view.showMessage("Enter character name: ");
        String name = scanner.nextLine();

        view.showMessage("Enter character sex: ");
        String sex = scanner.nextLine();

        view.showMessage("Enter character height: ");
        double height = scanner.nextDouble();

        view.showMessage("Enter character age: ");
        int age = scanner.nextInt();

        view.showMessage("Enter character type: ");
        view.showType();
        int type = scanner.nextInt();
        scanner.nextLine();

        Character character = clanChief.createCharacter(name, sex, height, age, type);
        
        

        if (character == null) {
            view.showMessage("Invalid type. Character not created.");
        } else {
            view.showMessage("Character created successfully!");
        }

        return character;
    }

    // Heal all characters
    public void healAllCharacters() {
        clanChief.healAllCharacters();
        view.showMessage("All characters have been healed!");
    }

    // Characters eat
    public void charactersEat() {
        String result = clanChief.getPlace().feedPeople();
        view.showMessage(result);
    }
}
