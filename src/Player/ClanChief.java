package Player;

import Character.Character;
import Character.*;
import Place.*;

import java.util.Scanner;

abstract class ClanChief {
	
	private String name;
	private String sex;
	private Integer age;
	private Scanner scanner;
	private Place place;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public ClanChief(String name, String sex, Integer age, Place place) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.place = place;
	}

	public void examinatePlace() {
		System.out.println(displaySpecifications() + '\n');
		System.out.println(getPeople() + '\n');
		System.out.println(getPresentAilment() + '\n');
	}
	
	public Character createACharacter() {
		int type = 0;
		scanner = new Scanner(System.in);
		System.out.println("Le nom de votre nouveau personnage : " + "\n");
		String name = scanner.nextLine();
		System.out.println("Le sexe de votre nouveau personnage : "+ "\n");
		String sex = scanner.nextLine();
		System.out.println("La taille de votre nouveau personnage : "+ "\n");
	    double height = scanner.nextDouble();
		System.out.println("L'Age de votre nouveau personnage : "+ "\n");
		int age = scanner.nextInt();
		System.out.println("Votre type de personnage : ");
		System.out.println("- 1 : druide" + "\n"
				+ "- 2 : forgerons"+ "\n" + "- 3 : aubergistes"+ "\n" + "- 4 : marchands"
				+ "\n" + "- 5 : légionnaires"+ "\n" + "- 6 : préfets"+ "\n" + "- 7: généraux"
				+ "\n" + "- 8 : lycantrophe");
		switch(type) {
			case 1:
				Druid druid = new Druid(name,sex,height,age,10,40,30,0,0,0);
				return druid;
				break;
			case 2:
				Blacksmith blacksmith = new Blacksmith(name,sex,height,age,20,30,20,0,0,0);
				break;
			case 3:
				Innkeeper innkeeper = new Innkeeper(name,sex,height,age,10,40,20,0,0,0);
				break;
			case 4:
				GallicMerchant merchant = new GallicMerchant(name,sex,height,age,15,20,25,0,0,0);
				break;
			case 5:
				Legionnaire legionnaire = new Legionnaire(name,sex,height,age,20,30,25,0,0,0);
				break;
			case 6:
				Prefect prefect = new Prefect(name,sex,height,age,22,12,35,0,0,0);
				break;
			case 7:
				General general = new General(name,sex,height,age,26,18,30,0,0,0);
				break;
			case 8:
				FantasticCreaturesLycantrophes lycantrophe = new FantasticCreaturesLycantrophes(name,sex,height,age,34,50,40,0,0,0);
			default:
				System.out.println("C'est pas un nombre valide(idiot)"+ "\n");
				return null;
		}
	}
	
	public void HealTheirCharacter() {
		ArrayList<Character> charc = Place.getCharacterPresent();
		for(int i=0; i < charc.length()-1; i++) {
			charc[i].heal();
		}
	}
	
	public void CharacterWillEat() {
		ArrayList<Character> charc = Place.getCharacterPresent();
		for(int i=0; i < charc.length()-1; i++) {
			charc[i].eat();
		}
	}
	
	
}
