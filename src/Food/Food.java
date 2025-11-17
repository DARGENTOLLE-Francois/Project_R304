package Food;

public enum Food {
	// Name, Freshness Level, Category, Nutritional Value, is in magic potion
	BOAR("Sanglier", FreshnessLevel.FRESH, Category.MEAT, NutritionalValue.GOOD, false),
	FAIRLY_FRESH_FISH("Poisson passablemment frais", FreshnessLevel.FAIRLY_FRESH, Category.FISH, NutritionalValue.MID, true),
	MISTLETOE("Gui", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.MID, true),
	LOBSTER("Homard", FreshnessLevel.FRESH, Category.FISH, NutritionalValue.GOOD, false),
	STRAWBERRY("Fraise", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.MID, false),
	CARROTS("Carottes", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.GOOD, true),
	SALT("Sel", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.BAD, true),
	FOURLEAF_CLOVER("Trèfle à quatre feuilles", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.BAD, true),
	TREELEAF_CLOVER("Trèfle à trois feuilles", FreshnessLevel.FRESH, Category.VEGETABLE, NutritionalValue.BAD, false),
	ROCK_OIL("Huile de roche", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.BAD, true),
	BEETROOT_JUICE("Jus de betterave", FreshnessLevel.FAIRLY_FRESH, Category.DRINK, NutritionalValue.MID, true),
	HONEY("Miel", FreshnessLevel.NONE, Category.DRINK, NutritionalValue.GOOD, true),
	WINE("Vin", FreshnessLevel.NONE, Category.DRINK, NutritionalValue.BAD, false),
	MEAD("Hydromel", FreshnessLevel.NONE, Category.DRINK, NutritionalValue.MID, true),
	MILK_FROM_A_TWOHEADED_UNICORN("Lait de licorne bicéphale", FreshnessLevel.FRESH, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.GOOD, true),
	IDEFIX_HAIR("Poil d'Idéfix", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.NONE, true),
	SECRET_INGREDIENT("Ingrédient secret", FreshnessLevel.NONE, Category.INGREDIENT_OF_MAGIC_POTION, NutritionalValue.NONE, true);

	private String name;
	private FreshnessLevel freshnessLevel;
	private Category category;
	private NutritionalValue nutritionalValue;
	private boolean isInMagicPotion;

	Food(String name, FreshnessLevel freshnessLevel, Category category, NutritionalValue nutritionalValue, boolean isInMagicPotion) {
		this.name = name;
		this.freshnessLevel = freshnessLevel;
		this.category = category;
		this.nutritionalValue = nutritionalValue;
		this.isInMagicPotion = isInMagicPotion;
	}

	public String getName() {
		return name;
	}

	public FreshnessLevel getFreshnessLevel() {
		return freshnessLevel;
	}

	public Category getCategory() {
		return category;
	}

	public NutritionalValue getNutritionalValue() {
		return nutritionalValue;
	}

	
	public boolean isInMagicPotion() {
		return isInMagicPotion;
	}
	
	
}