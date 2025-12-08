package model.character;

public class LycanAlpha extends FantasticCreaturesLycanthropes {

    public LycanAlpha(String name, Sex sexe, double height, CategoryAge age, Integer strength,
			Integer stamina, Integer health, Integer hunger, Integer belligerence, Integer levelOfPotion,
			Integer domination_factor, double level, String domination_rank, Integer impentuosity_factor,
			boolean sickness, Rank rank, boolean human, boolean isMale) {
        super(name, sexe, height, age, strength, stamina, health, hunger, belligerence, levelOfPotion,
              domination_factor, level, domination_rank, impentuosity_factor,
              sickness, rank, human, isMale);
    }

    public FantasticCreaturesLycanthropes reproduce(LycanAlpha partner) {
        if(this.getSexenum() != partner.getSexenum()) {
            return new FantasticCreaturesLycanthropes(getName(), getSexenum(), getHeight(), getCategoryAge(), getStrength(), getStamina(), getHealth(), getHunger(), getBelligerence(), getLevelOfPotion());
        }
        else {
            return null;
        }
    }
}