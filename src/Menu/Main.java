package Menu;

import java.util.ArrayList;
import java.util.List;

import Character.Druid;
import Food.Food;
import Potion.MagicPotion;

public class Main {
	public static void main(String[] args) {
		Food boar = Food.BOAR;
		
		System.out.println(boar.getName());
		System.out.println(boar.getCategory());
		System.out.println(boar.getNutritionalValue());
	}
}
