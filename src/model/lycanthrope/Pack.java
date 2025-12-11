package model.lycanthrope;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import model.character.*;
/**
 * Class of the pack of Lycanthrope objects
 * 
 * <p> This class is used to initialize the methods used in the pack of lycanthrope</p>
 * @author Benhafessa Alexandre
 * @author Dargentolle François
 * @author Edelstein William
 * @author Griguer Nathan
 */
public class Pack {
	private List<FantasticCreaturesLycanthropes> members;
	private FantasticCreaturesLycanthropes alphaMale;
	private FantasticCreaturesLycanthropes alphaFemale;

	
	public Pack() {
		this.members = new ArrayList<FantasticCreaturesLycanthropes>();
	}
	
	/**
	 * Method that add an object lycanthrope to the list of members of a pack
	 * @param wolf
	 * @return void
	 */
	public void addMember (FantasticCreaturesLycanthropes wolf) {
		members.add(wolf);
		//wolf.setPack(this);
		recalculateHierarchy();
	}
	
	/**
	 * Method that remove an object lycanthrope to the list of members of a pack and recalculate the hierarchy
	 * @param wolf
	 * @return void
	 */
	public void removeMember (FantasticCreaturesLycanthropes wolf) {
		members.remove(wolf);
		//wolf.setPack(this);
		recalculateHierarchy();
	}
	
	/**
	 * Method that re-arrange the hierarchy of the pack (mostly the alpha couple)
	 * <p> This methode will verify if a male and female are worthy of becoming alpha and if they do, then their rank will change in consequence
	 *  only if there isn't another alpha from the same gender as them </p>
	 * @return void
	 */
	public void recalculateHierarchy() {
		for (FantasticCreaturesLycanthropes member : members) {
			if(member.getLevel() < alphaMale.getLevel() && !member.equals(alphaMale) && member.isMale()) {
				setAlphaMale(member);
			}
			if(member.getLevel() < alphaFemale.getLevel() && !member.equals(alphaFemale) && !member.isMale()) {
				setAlphaFemale(member);
			}
		}
		
	}
	
	/**
	 * Method that will make baby out of the alpha couple
	 * <p> This method will make the couple reproduce a random number of cub between 1 and 7. The method also assign the attribute of the cub while 
     * the rank of everyone in the pack</p>
     * @return void
	 */
	public void reproduce() {
		if (alphaMale != null && alphaFemale != null) {
			int litterSize = 1 + (int)(Math.random()*7);
			//System.out.println("Ils se reproduisent avec une porté de" + litterSize);
			Integer countBeta = 0;
			// Check if there is already a Beta in the pack
			for (FantasticCreaturesLycanthropes member : members) {
				if (member.getRank() == Rank.BETA) {
					countBeta++;
				}
			}
			if(countBeta == 0){
				for (int i = 0; i < litterSize; i++) {
				//valeur au pif a adapter
				FantasticCreaturesLycanthropes child = new FantasticCreaturesLycanthropes("child" + i, Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Beta", 40, false, Rank.BETA, false, true);
				addMember(child);
			    }
			} else {
				for (int i = 0; i < litterSize; i++) {
				//valeur au pif a adapter
				FantasticCreaturesLycanthropes child = new FantasticCreaturesLycanthropes("child" + i, Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Gamma", 40, false, Rank.GAMMA, false, true);
				addMember(child);
			    }
			}
			// a changer plus tard
		}
	}
	
	/**
	 * Method that will sort the lycanthrope thanks to their rank
	 * @return result the list of lycanthrope sorted by rank
	 */
	public List<FantasticCreaturesLycanthropes> getMembersSortedByRank(){
		List<FantasticCreaturesLycanthropes> result = new ArrayList<>();
		result.addAll(getMembers());
		result.sort(Comparator.comparingInt((FantasticCreaturesLycanthropes e) -> e.getRank().getValue()).reversed());		
		return result;
	}
	
	/**
	 * Getter of the list of lycanthrope
	 * @return members
	 */
	public List<FantasticCreaturesLycanthropes> getMembers(){
		return members;
	}
	
	/**
	 * Setter of the alpha male
	 * @param male
	 * @return void
	 */
	public void setAlphaMale(FantasticCreaturesLycanthropes male) {
		this.alphaMale = male;
	}
	
	/**
	 * Setter of the alpha female
	 * @param female
	 * @return void
	 */
	public void setAlphaFemale(FantasticCreaturesLycanthropes female) {
		this.alphaFemale = female;
	}
	
	/**
	 * Getter of the alpha male
	 * @return alphaMale
	 */
	public FantasticCreaturesLycanthropes getAlphaMale() {
		return this.alphaMale;
	}
	
	/**
	 * Getter of the alpha female
	 * @return alphaFemale
	 */
	public FantasticCreaturesLycanthropes getAlphaFemale() {
		return this.alphaFemale;
	}
	
	public String coupleAlphaString() {
		return alphaMale.toString() + alphaFemale.toString();
	}
	
}
