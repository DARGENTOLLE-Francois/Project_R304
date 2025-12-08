package model.lycanthrope;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import model.character.*;

public class Pack {
	private List<FantasticCreaturesLycanthropes> members;
	private FantasticCreaturesLycanthropes alphaMale;
	private FantasticCreaturesLycanthropes alphaFemale;

	
	public Pack() {
		this.members = new ArrayList<FantasticCreaturesLycanthropes>();
	}
	
	public void addMember (FantasticCreaturesLycanthropes wolf) {
		members.add(wolf);
		//wolf.setPack(this);
		recalculateHierarchy();
	}
	public void removeMember (FantasticCreaturesLycanthropes wolf) {
		members.remove(wolf);
		//wolf.setPack(this);
		recalculateHierarchy();
	}
	
	public void recalculateHierarchy() {
		//TODO
		//determine le couple alpha
	}
	public void reproduce() {
		if (alphaMale != null && alphaFemale != null) {
			int litterSize = 1 + (int)(Math.random()*7);
			System.out.println("Ils se reproduisent avec une porté de" + litterSize);
			
			// a changer plus tard
			for (int i = 0; i < litterSize; i++) {
				//valeur au pif a adapter
				FantasticCreaturesLycanthropes child = new FantasticCreaturesLycanthropes("child" + 1, Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Alpha", 40, false, Rank.ALPHA, false, true);
				addMember(child);
			}
		}
	}
	
	public List<FantasticCreaturesLycanthropes> getMembersSortedByRank(){
		//TODO
		return getMembers();
	}
	
	public List<FantasticCreaturesLycanthropes> getMembers(){
		return members;
	}
	
	
}
