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
	private Rank firstRank = members.get(0).getRank();
	private Rank lastRank = members.get(members.size()-1).getRank();

	
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
		// TODO : 
	}
	public void reproduce() {
		if (alphaMale != null && alphaFemale != null) {
			int litterSize = 1 + (int)(Math.random()*7);
			System.out.println("Ils se reproduisent avec une porté de" + litterSize);
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
				FantasticCreaturesLycanthropes child = new FantasticCreaturesLycanthropes("child" + 1, Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Beta", 40, false, Rank.BETA, false, true);
				addMember(child);
			    }
			} else {
				for (int i = 0; i < litterSize; i++) {
				//valeur au pif a adapter
				FantasticCreaturesLycanthropes child = new FantasticCreaturesLycanthropes("child" + 1, Sex.MALE, 2.1, CategoryAge.ADULT, 85, 70, 100, 30, 60, 0, 50, 12.5, "Gamma", 40, false, Rank.GAMMA, false, true);
				addMember(child);
			    }
			}
			// a changer plus tard
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
