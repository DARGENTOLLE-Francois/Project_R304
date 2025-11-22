package Menu;

import java.util.ArrayList;
import java.util.Iterator;

import Food.Food;
import Potion.MagicPotion;

public class Main {
	public static void main(String[] args) {
		Food boar = Food.BOAR;
		
		ArrayList<Food> lf1 = new ArrayList<>();
		lf1.add(boar);
		lf1.add(Food.CARROTS);
		lf1.add(boar);
		Iterator<Food> it = lf1.iterator();
		int a=0;
		while (it.hasNext()) {			
			System.out.println(it.next().getName()+ " : "+a);
			++a;
		}
		
		
		for (Food food: Food.values()) {
			System.out.println(food.getFreshnessLevel());
		}
		
	}
}
