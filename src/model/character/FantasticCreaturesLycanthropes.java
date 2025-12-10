package model.character;

public class FantasticCreaturesLycanthropes  extends Character implements Fight{

	public FantasticCreaturesLycanthropes(String name, Sex sexe, double height, CategoryAge age, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
	}
	
	private Integer domination_factor;
	private double level;
	private String domination_rank;
	private Integer Impentuosity_factor;
	private boolean sickness;
	private Rank rank;
	private boolean human;
	private CategoryAge cage;
	private boolean isMale;
	//private Pack pack
	
	public FantasticCreaturesLycanthropes(String name, Sex sexe, double height, CategoryAge age, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion,
			Integer domination_factor, double level, String domination_rank, Integer impentuosity_factor,
			boolean sickness, Rank rank, boolean human, boolean isMale) {
		super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion);
		this.domination_factor = domination_factor;
		this.level = level;
		this.domination_rank = domination_rank;
		Impentuosity_factor = impentuosity_factor;
		this.sickness = sickness;
		this.rank = rank;
		this.human = human;
		this.isMale = isMale;
	}

	public CategoryAge getCage() {
		return cage;
	}

	public void setCage(CategoryAge cage) {
		this.cage = cage;
	}

	public Integer getDomination_factor() {
		return domination_factor;
	}

	public void setDomination_factor(Integer domination_factor) {
		this.domination_factor = domination_factor;
	}

	public double getLevel() {
		return level;
	}
	
	public void setLevel(double level) {
		this.level = level;
	}

	public String getDomination_rank() {
		return domination_rank;
	}

	public void setDomination_rank(String domination_rank) {
		this.domination_rank = domination_rank;
	}

	public Integer getImpentuosity_factor() {
		return Impentuosity_factor;
	}

	public void setImpentuosity_factor(Integer impentuosity_factor) {
		Impentuosity_factor = impentuosity_factor;
	}

	public boolean isSickness() {
		return sickness;
	}

	public void setSickness(boolean sickness) {
		this.sickness = sickness;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public boolean isHuman() {
		return human;
	}

	public void setHuman(boolean human) {
		this.human = human;
	}
	public boolean isMale() {
		return this.isMale;
	}
	
	public double CalculateLevel() {
		return (rank.getValue()+ domination_factor * Impentuosity_factor) * cage.getValue(); 
	}
	
	public void transformationHuman() {
		this.human = true;
		
	}
	
	public void attemptDomination(FantasticCreaturesLycanthropes target) {
		//TODO
		
	}
	public void howl(String message) {
		System.out.println("Je suis le loup" + this.getName()+ "et je crie jsp pk");
		
	}
	@Override
    public String toString() {
        return getName() + " [" + rank + "] (Lvl: " + getLevel() + ")";
    }
	
	public void naturalHierachydown() {
		if (this.rank != Rank.OMEGA) {
			if(this.rank.getValue() < 3) {
				this.rank.setValue(this.rank.getValue() - 1);
				System.out.println(this.getName() + " descend dans la hiérarchie au rang de " + this.rank);
			}
		}
	}

}
